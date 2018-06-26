import Business.Driver;
import Business.Order;
import Business.User;
import Configure.ConfigureABusiness;
import Configure.CsvReader;

import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ConfigureABusiness c = new ConfigureABusiness();//车辆信息初始化
        HashMap<List<Double>, List<Driver>> driverMap = c.getDriverMap();//车辆地图
        ArrayList<Driver> driverOffList = new ArrayList<>();//离线车辆
        CsvReader csv = new CsvReader();//读取order信息并生成user
        Queue<User> userQueue = csv.getUserQueue();//得到user队列
        int uTime = 1477929720;//初始时间
        int oriTime = 1477929720;

        //网格数量显示
        int i = 0;
        int j = 0;
        for (Map.Entry<List<Double>, List<Driver>> driverLo : driverMap.entrySet()) {
            if (driverLo.getValue().isEmpty()) {
                i = i + 1;
            } else {
                j = j + 1;
            }
        }
        System.out.println("无车网格数量：" + i);
        System.out.println("有车网格数量：" + j);

        //订单list
        ArrayList<Order> orderslist = new ArrayList<>();

        //订单数量计数器
        int successNum = 0;

        //司机数量计数器
        int driverNumber;

        while (!userQueue.isEmpty()) {

            //检查车辆在线状态
            int aimTime = uTime - oriTime;
            if(driverOffList.size()>0){
                for(int oN=0;oN<driverOffList.size();oN++){
                    if(driverOffList.get(oN).getOnRoadT()==aimTime){
                        double dx;
                        double dy;
                        driverOffList.get(oN).setOnRoadT(0);
                        driverOffList.get(oN).setDriverStatus("on");
                        dx= driverOffList.get(oN).getDriverLocation().get(0);
                        dy= driverOffList.get(oN).getDriverLocation().get(0);

                        BigDecimal b = new BigDecimal(dx);
                        dx = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
                        BigDecimal b1 = new BigDecimal(dy);
                        dy = b1.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();

                        List<Double> putDriverLo = new ArrayList<>();
                        if(driverMap.containsKey(putDriverLo)){
                            List driverList = driverMap.get(putDriverLo);
                            driverList.add(driverOffList.get(oN));
                            driverOffList.remove(oN);
                            oN--;
                        }

                    }
                }
            }


            //user的目标driver
            List<Driver> userAimDriver = new ArrayList<>();

            ///User入场
            if (userQueue.peek().getStartT() == uTime) {
                System.out.println("----用户:" + userQueue.peek().getUserID());
                double ux = userQueue.peek().getUserLocation().get(0);
                double uy = userQueue.peek().getUserLocation().get(1);

                //转化user坐标为三位小数
                BigDecimal b = new BigDecimal(ux);
                ux = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
                BigDecimal b1 = new BigDecimal(uy);
                uy = b1.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();

                //存为List，作为key进行寻找driver
                List<Double> userFindLo = new ArrayList<>();
                userFindLo.add(ux);
                userFindLo.add(uy);
                if (driverMap.containsKey(userFindLo)) {
                    List<Driver> userAimDriverList = driverMap.get(userFindLo);

                    //若此方格中含有车辆
                    if (!userAimDriverList.isEmpty()) {

                        //找出方格中的车辆，并找出最近车辆
                        userAimDriver = getAimDriverList(userAimDriverList, userAimDriver, ux, uy);

                        Driver aimDriver = userAimDriver.get(0);
                        Order order = new Order();
                        order.setOrderID();

                        //创建订单
                        order.setDriverID(aimDriver.getDriverID());
                        order.setUserID(userQueue.peek().getUserID());
                        order.setOrderStartT(uTime);
                        order.setOrderStartL(userQueue.peek().getUserLocation());
                        double averageDistance = Math.abs(ux - aimDriver.getDriverLocation().get(0)) + Math.abs(uy - aimDriver.getDriverLocation().get(1));
                        order.setAvergeDistance(averageDistance);
                        orderslist.add(order);

                        //将已接单车辆剔除现有地图中，并加入Offline的list
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
                            dis = dis + orderslist.get(k).getAvergeDistance();
                        }

                        System.out.println("平均接单距离为：" + dis / orderslist.size());
                        driverNumber = 0;
                        for (Map.Entry<List<Double>, List<Driver>> entry : driverMap.entrySet()) {
                            List<Driver> value = entry.getValue();
                            driverNumber = driverNumber + value.size();
                        }
                        System.out.println("----所有司机的数量是：" + driverNumber);
                    } else {

                        int blockNum = 1;

                        //初始化方格list

                        List<Driver> userAimDriverListForBlocks = new ArrayList<>();

                        //如果目标车辆list为空
                        while (userAimDriverListForBlocks.isEmpty()) {
                            List<List<Double>> blocks = new ArrayList<>();
                            //搜集方格并存入list
                            for (int dxR = -blockNum; dxR < blockNum + 1; dxR++) {
                                double dx = userFindLo.get(0) + 0.001 * dxR;
                                for (int dyR = -blockNum; dyR < blockNum + 1; dyR++) {
                                    List<Double> lo = new ArrayList<>();
                                    double dy = userFindLo.get(1) + 0.001 * dyR;
                                    lo.add(dx);
                                    lo.add(dy);
                                    blocks.add(lo);
                                }
                            }

                            for (int k = 0; k < blocks.size(); k++) {
                                if (driverMap.containsKey(blocks.get(k))) {
                                    List<Driver> userAimDriverListForBlock = driverMap.get(blocks.get(k));
                                    if (!userAimDriverListForBlock.isEmpty()) {
                                        for (int dNum = 0; dNum < userAimDriverListForBlock.size(); dNum++) {
                                            userAimDriverListForBlocks.add(userAimDriverListForBlock.get(dNum));
                                        }
                                        break;
                                    }
                                }
                            }


                            //找出blocks中最近车辆
                            userAimDriver = getAimDriverList(userAimDriverListForBlocks, userAimDriver, ux, uy);
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
                        Order order = new Order();
                        order.setOrderID();
                        //订单生成
                        Driver aimDriver = userAimDriver.get(0);
                        order.setDriverID(aimDriver.getDriverID());
                        order.setUserID(userQueue.peek().getUserID());
                        order.setOrderStartT(uTime);
                        order.setOrderStartL(userQueue.peek().getUserLocation());
                        double averageDistance = Math.abs(ux - aimDriver.getDriverLocation().get(0)) + Math.abs(uy - aimDriver.getDriverLocation().get(1));
                        order.setAvergeDistance(averageDistance);
                        orderslist.add(order);

                        successNum = successNum + 1;
                        //平均接单距离计算
                        double dis = 0;
                        for (int k = 0; k < orderslist.size(); k++) {
                            dis = dis + orderslist.get(k).getAvergeDistance();
                        }

                        System.out.println("平均接单距离为：" + dis / orderslist.size());
                        driverNumber = 0;
                        for (Map.Entry<List<Double>, List<Driver>> entry : driverMap.entrySet()) {
                            List<Driver> value = entry.getValue();
                            driverNumber = driverNumber + value.size();
                        }
                        System.out.println("----所有司机的数量是：" + driverNumber);
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

    public static List<Driver> getAimDriverList(List<Driver> userAimDriverList, List<Driver> userAimDriver, double ux, double uy) {
        for (Driver d : userAimDriverList) {
            double dx = d.getDriverLocation().get(0);
            double dy = d.getDriverLocation().get(1);
            double rx = Math.abs(dx - ux);
            double ry = Math.abs(dy - uy);
            double aim = Math.sqrt(rx * rx + ry * ry);
            d.setAim(aim);

            //判断坐标格子中最近车辆
            if (userAimDriver.isEmpty()) {
                userAimDriver.add(d);

            } else {
                if (userAimDriver.get(0).getAim() > d.getAim()) {
                    userAimDriver.remove(0);
                    userAimDriver.add(d);
                }
            }
        }
        return userAimDriver;
    }
}