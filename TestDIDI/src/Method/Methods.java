package Method;

import Business.Driver;
import Business.Order;
import Business.User;

import java.math.BigDecimal;
import java.util.*;

public class Methods {
    public Methods(){

    }

    //检查车辆是否离线车辆订单时间已结束，结束的重新回到线上
    public void checkDriverStatus(int uTime, int oriTime, List<Driver> driverOffList,HashMap<List<Double>, List<Driver>> driverMap){
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
                    putDriverLo.add(dx);putDriverLo.add(dy);

                    //Todo 时间Queue
                    if(driverMap.containsKey(putDriverLo)){
                        List driverList = driverMap.get(putDriverLo);
                        driverList.add(driverOffList.get(oN));
                        driverOffList.remove(oN);
                        System.out.println("====已回归一辆车");
                        oN--;
                    }

                }
            }
        }
    }

    public double transTo3Dec(double ux){
        BigDecimal b = new BigDecimal(ux);
        ux = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();

        return ux;
    }

    public int showBlockNumber(HashMap<List<Double>, List<Driver>> driverMap){
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

        return i+j;
    }

    public List<Driver> getAimDriverList(List<Driver> userAimDriverList,double ux, double uy) {
        List<Driver> userAimDriver = new ArrayList<>();
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

    public double getNewDegree(double odx, double ody, double onx, double ony) {
        double x = Math.abs(odx - onx);
        double y = Math.abs(ody - ony);
        double z = Math.sqrt(x * x + y * y);
        double degree = Math.round((float) (Math.asin(y / z) / Math.PI * 180));//最终角度

        return degree;
    }

    public List<Driver> searchInBlocks(Set<List<Double>> alreadySearchBlocks,int blockNum, List<Double> userFindLo,List<List<Double>> blocks,HashMap<List<Double>, List<Driver>> driverMap,List<Driver> userAimDriverListForBlocks){

        //Todo 改算法 (Done)
        for (int dxR = -blockNum; dxR < blockNum + 1; dxR++) {
            double dx = userFindLo.get(0) + 0.001 * dxR;
            for (int dyR = -blockNum; dyR < blockNum + 1; dyR++) {
                List<Double> lo = new ArrayList<>();
                double dy = userFindLo.get(1) + 0.001 * dyR;
                lo.add(dx);
                lo.add(dy);
                if(!alreadySearchBlocks.contains(lo)) {
                    blocks.add(lo);
                }
                alreadySearchBlocks.add(lo);
            }
        }

//        if(blockNum>1){
//            for (int dxR = -blockNum+1; dxR < blockNum ; dxR++) {
//                double dx = userFindLo.get(0) + 0.001 * dxR;
//                for (int dyR = -blockNum+1; dyR < blockNum ; dyR++) {
//                    List<Double> lo = new ArrayList<>();
//                    double dy = userFindLo.get(1) + 0.001 * dyR;
//                    lo.add(dx);
//                    lo.add(dy);
//                    blocks.remove(lo);
//                }
//            }
//        }

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

        return userAimDriverListForBlocks;
    }



    public Order createOrder(int uTime,List<Driver> userAimDriver,Queue<User> userQueue,double ux,double uy){
        Order order = new Order();
        order.setOrderID();
        //订单生成
        Driver aimDriver = userAimDriver.get(0);
        order.setDriverID(aimDriver.getDriverID());
        order.setUserID(userQueue.peek().getUserID());
        order.setOrderStartT(uTime);
        order.setOrderStartL(userQueue.peek().getUserLocation());
        double averageDistance = Math.abs(ux - aimDriver.getDriverLocation().get(0)) + Math.abs(uy - aimDriver.getDriverLocation().get(1));
        order.setManhattanDistance(averageDistance);
        return order;
        //Todo 打入log

    }
}
