package Method;

import Business.Driver;
import Business.Order;
import Business.User;
import Configure.ConfigureABusiness;

import java.math.BigDecimal;
import java.util.*;

public class UserQueueMethod {

    public UserQueueMethod() {

    }

    public void userQueueMethod(ConfigureABusiness c, HashMap<List<Double>, List<Driver>> driverMap, ArrayList<Driver> driverOffList, Queue<User> userQueue) {
        //初始时间
        int uTime = 1477929720;
        int oriTime = 1477929720;

        //引入Methods
        Methods methods = new Methods();

        //网格数量显示
        methods.showBlockNumber(driverMap);

        //订单list
        ArrayList<Order> orderslist = new ArrayList<>();

        //订单数量计数器
        int successNum = 0;


        while (!userQueue.isEmpty()) {

            //检查车辆在线状态
            methods.checkDriverStatus(uTime, oriTime, driverOffList, driverMap);


            //user的目标driver
            List<Driver> userAimDriver = new ArrayList<>();


            ///User入场
            if (userQueue.peek().getStartT() == uTime) {

                System.out.println("----用户:" + userQueue.peek().getUserID());
                double ux = userQueue.peek().getUserLocation().get(0);
                double uy = userQueue.peek().getUserLocation().get(1);

                //转化user坐标为三位小数
                ux = methods.transTo3Dec(ux);
                uy = methods.transTo3Dec(uy);

                //存为List，作为key进行寻找driver
                List<Double> userFindLo = new ArrayList<>();
                userFindLo.add(ux);
                userFindLo.add(uy);

                //Todo 判断坐标范围
                if (driverMap.containsKey(userFindLo)) {
                    List<Driver> userAimDriverList = driverMap.get(userFindLo);

                    //若此方格中含有车辆
                    if (!userAimDriverList.isEmpty()) {

                        //找出方格中的车辆，并找出最近车辆
                        userAimDriver = methods.getAimDriverList(userAimDriverList, ux, uy);

                        Driver aimDriver = userAimDriver.get(0);
                        Order order = new Order();
                        order.setOrderID();

                        //创建订单
                        order.setDriverID(aimDriver.getDriverID());
                        order.setUserID(userQueue.peek().getUserID());
                        order.setOrderStartT(uTime);
                        order.setOrderStartL(userQueue.peek().getUserLocation());
                        double averageDistance = Math.abs(ux - aimDriver.getDriverLocation().get(0)) + Math.abs(uy - aimDriver.getDriverLocation().get(1));
                        order.setManhattanDistance(averageDistance);
                        orderslist.add(order);

                        //将已接单车辆剔除现有地图中，并加入Offline的list

                        //Todo 改变量
                        for (int dGetNum = 0; dGetNum < driverMap.get(userFindLo).size(); dGetNum++) {
                            if (driverMap.get(userFindLo).get(dGetNum).getDriverID() == aimDriver.getDriverID()) {
                                driverMap.get(userFindLo).get(dGetNum).setOnRoadT(userQueue.peek().getEndT() - userQueue.peek().getStartT());
                                driverMap.get(userFindLo).get(dGetNum).setDriverStatus("off");
                                driverMap.get(userFindLo).get(dGetNum).setDriverLocation(userQueue.peek().getUserAimLocation());
                                driverOffList.add(driverMap.get(userFindLo).get(dGetNum));
                                driverMap.get(userFindLo).remove(dGetNum);
                                dGetNum--;
                                System.out.println("====没扩大，订单成交，删除一辆车");
                                break;
                            }
                        }
                        successNum = successNum + 1;
                        //平均接单距离计算
                        double dis = 0;
                        for (int k = 0; k < orderslist.size(); k++) {
                            dis = dis + orderslist.get(k).getManhattanDistance();
                        }

                        System.out.println("平均接单距离为：" + dis / orderslist.size());
                    } else {

                        int blockNum = 1;

                        //初始化方格list

                        List<Driver> userAimDriverListForBlocks = new ArrayList<>();

                        Set<List<Double>> alreadySearchBlocks = new HashSet<>();

                        //如果目标车辆list为空
                        while (userAimDriverListForBlocks.isEmpty()) {
                            List<List<Double>> blocks = new ArrayList<>();
                            //搜集方格并存入list
                            userAimDriverListForBlocks=methods.searchInBlocks(alreadySearchBlocks,blockNum,userFindLo,blocks,driverMap,userAimDriverListForBlocks);

                            //找出blocks中最近车辆
                            userAimDriver = methods.getAimDriverList(userAimDriverListForBlocks, ux, uy);
                            System.out.println("====找到" + userAimDriver.size() + "辆车====");
                            System.out.println("扩大了" + blocks.size() + "格");
                            successNum = successNum + 1;
                            blockNum++;

                        }
                        //将订单成交车辆从driver地图中删除
//                        double dx = (double) Math.round(userAimDriver.get(0).getDriverLocation().get(0) * 1000) / 1000;
//                        double dy = (double) Math.round(userAimDriver.get(0).getDriverLocation().get(1) * 1000) / 1000;
//                        List<Double> aimDriverLo = new ArrayList<>();
//                        aimDriverLo.add(dx);
//                        aimDriverLo.add(dy);

                        for (Map.Entry<List<Double>, List<Driver>> driverL : driverMap.entrySet()) {
                            List<Driver> driverDelL = driverL.getValue();
                            if (driverDelL.size() > 0) {
                                for (int dN = 0; dN < driverDelL.size(); dN++) {
                                    if (driverDelL.get(dN).getDriverID() == userAimDriver.get(0).getDriverID()) {
                                        driverDelL.get(dN).setOnRoadT(userQueue.peek().getEndT() - userQueue.peek().getStartT());
                                        driverDelL.get(dN).setDriverStatus("off");
                                        driverDelL.get(dN).setDriverLocation(userQueue.peek().getUserAimLocation());
                                        driverOffList.add(driverDelL.get(dN));
                                        driverDelL.remove(dN);
                                        dN--;
                                        System.out.println("====车辆下线成功");
                                    }
                                }
                            }
                        }


                        //创建订单
                        methods.createOrder(uTime,userAimDriver,userQueue,ux,uy);

                        successNum = successNum + 1;
                        //平均接单距离计算
                        double dis = 0;
                        for (int k = 0; k < orderslist.size(); k++) {
                            dis = dis + orderslist.get(k).getManhattanDistance();
                        }

                        System.out.println("平均接单距离为：" + dis / orderslist.size());
                    }
                } else {
                    userQueue.peek().setStatus("no");
                    System.out.println("########用户不在区域范围内##########");
                }

                userQueue.poll();
                System.out.println("------已成交一单------");

                //车辆实时运动中
                driverMap = c.changeDriverLo(driverMap);
                System.out.println(
                        "车辆离线数量：" + driverOffList.size());

            } else {
                uTime++;
            }


        }

        //打印统计信息
        System.out.println(
                "成功叫车人数：" + successNum);
        System.out.println(
                "订单数：" + orderslist.size());
    }

}
