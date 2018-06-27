package Method;

import Business.Driver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void showBlockNumber(HashMap<List<Double>, List<Driver>> driverMap){
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
