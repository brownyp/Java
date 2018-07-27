package Method;

import Business.Driver;
import Business.Order;
import Business.User;
import Configure.ConfigureABusiness;

import java.math.BigDecimal;
import java.util.*;

public class UsersInListMethod {
    public UsersInListMethod() {

    }

    public void userInListMethod(ConfigureABusiness c, HashMap<List<Double>, List<Driver>> driverMap, ArrayList<Driver> driverOffList, Queue<User> userQueue) {
        int uTime = 1477929720;//初始时间
        int oriTime = 1477929720;

        Methods methods = new Methods();

        //网格数量显示
        int mapNumber = methods.showBlockNumber(driverMap);
        System.out.println(mapNumber);

        //订单list
        ArrayList<Order> orderslist = new ArrayList<>();

        //订单数量计数器
        int successNum = 0;

        //司机数量计数器
        int driverNumber;

        while (!userQueue.isEmpty()) {
            ArrayList<User> userQueueList = new ArrayList<>();
            //检查车辆在线状态
            methods.checkDriverStatus(uTime, oriTime, driverOffList, driverMap);

            //同一秒的user同时入场
            while (userQueue.peek().getStartT() == uTime) {
                userQueueList.add(userQueue.peek());
                userQueue.poll();
            }

            if (userQueueList.size() == 1) {
                //原始方案，搜索最近的车
                System.out.println("只有一人进场情况====");
            } else {
                //用户与搜索到的司机
                HashMap<User, List<Driver>> userGetDriverMap = new HashMap<>();


                //需要下线的车辆
                List<List<Double>> needOffDriverLo = new ArrayList<>();

                for (int i = 0; i < userQueueList.size(); i++) {
                    System.out.println("UserID：" + userQueueList.get(i).getUserID());

                    //初始化方格step
                    int blockNum = 0;

                    //初始化方格list
                    List<Driver> userAimDriverListForBlocks = new ArrayList<>();

                    double ux = userQueueList.get(i).getUserLocation().get(0);
                    double uy = userQueueList.get(i).getUserLocation().get(1);

                    //转化user坐标为三位小数
                    ux = methods.transTo3Dec(ux);
                    uy = methods.transTo3Dec(uy);

                    //存为List，作为key进行寻找driver
                    List<Double> userFindLo = new ArrayList<>();
                    userFindLo.add(ux);
                    userFindLo.add(uy);

                    //只要在这一圈格搜到车，就停止
                    //存入已找过的方格
                    Set<List<Double>> alreadySearchBlocks = new HashSet<>();
                    while (userAimDriverListForBlocks.isEmpty()) {
                        if (blockNum == 0) {
                            if (driverMap.containsKey(userFindLo)) {
                                List<Driver> blockNum0 = driverMap.get(userFindLo);
                                if (blockNum0.size() != 0) {
                                    for (int k = 0; k < blockNum0.size(); k++) {
                                        userAimDriverListForBlocks.add(blockNum0.get(k));
                                    }
                                }
                            }
                        } else {
                            //搜集方格并存入list
                            List<List<Double>> blocks = new ArrayList<>();
//                            List<List<Driver>> test = new ArrayList<>();

                            //搜集方格并存入list
                            userAimDriverListForBlocks=methods.searchInBlocks(alreadySearchBlocks,blockNum,userFindLo,blocks,driverMap,userAimDriverListForBlocks);
                            System.out.println("====搜索了：" + blocks.size() + "格子" + "搜索到的车有：" + userAimDriverListForBlocks.size() + "车");
                        }
                        blockNum++;
                    }
//                    System.out.println(userAimDriverListForBlocks.size());

                    //将每个user周围对应的driverList存到map中
                    userGetDriverMap.put(userQueueList.get(i), userAimDriverListForBlocks);

                    User user = userQueueList.get(i);
                    List<Driver> userAimDriver = methods.getAimDriverList(userAimDriverListForBlocks, ux, uy);
                    System.out.println("目标车辆数量：" + userAimDriver.size());

                    //创建订单
                    Order order = methods.createOrder(uTime,userAimDriver,userQueue,ux,uy);
                    orderslist.add(order);

                    //改变车辆状态（下线）
                    Driver aimDriver = userAimDriver.get(0);
                    aimDriver.setDriverStatus("off");
                    System.out.println("====成功叫车");

                    //下线车辆
                    for (int j = 0; j < needOffDriverLo.size(); j++) {
                        List<Driver> driverFromMap = driverMap.get(needOffDriverLo.get(j));
                        for (int k = 0; k < driverFromMap.size(); k++) {
                            if (driverFromMap.get(k).getDriverID() == aimDriver.getDriverID()) {
                                driverFromMap.remove(k);
                                System.out.println("下线一辆车");
                                if (k != 0) {
                                    k--;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            uTime++;
        }
    }
}

