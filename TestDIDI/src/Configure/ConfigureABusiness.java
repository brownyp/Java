package Configure;

import Business.Driver;
import Method.Methods;

import java.math.BigDecimal;
import java.util.*;

public class ConfigureABusiness {

    //Todo 命名待改
    private double m = 104.00;
    private double n = 104.11;
    private double e = 30.1;
    private double q = 31.0;
    private int i = 1;
    private ArrayList<Driver> driverlist;
    private HashMap<List<Double>, List<Driver>> driverMap;

    public ConfigureABusiness(int driverNum) {
        //随机司机坐标
        int i = 1;
        this.driverlist = new ArrayList<>();
        this.driverMap = new HashMap<>();

        //车辆生成
        for (this.i = i; i < driverNum; i++) {//Todo 车辆数量变量

            Driver d = new Driver();
            List<Double> lo = new ArrayList<>();
            d.setDriverStatus("on");
            d.setDriverID(i);
            double loX = Math.random() * (n - m) + m;
            double loY = Math.random() * (e - q) + q;
            lo.add(loX);
            lo.add(loY);
            d.setDriverLocation(lo);
            //以 当前角度/360，为角度系数
            double bearingDegree = Math.random();
            d.setBearing(bearingDegree);
            driverlist.add(d);
        }

        //车辆地图生成
        for (int f = 1; f < 111; f++) {//Todo 刻度变量
            double k = 104.001 + f * 0.001;
            BigDecimal b = new BigDecimal(k);
            k = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
            for (int j = 1; j < 901; j++) {
                double n = 30.10 + j * 0.001;
                BigDecimal d = new BigDecimal(n);
                n = d.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();

                List<Driver> driverList = new ArrayList<>();
                List<Double> lo = new ArrayList<>();
                for (Driver driver : driverlist) {
                    double dx = (double) Math.round(driver.getDriverLocation().get(0) * 1000) / 1000;
                    double dy = (double) Math.round(driver.getDriverLocation().get(1) * 1000) / 1000;
                    if (dx == k && dy == n) {
                        driverList.add(driver);
                    }
                }
                lo.add(k);
                lo.add(n);
                driverMap.put(lo, driverList);
            }
        }

    }


    //车辆随机运动
    public HashMap<List<Double>, List<Driver>> changeDriverLo(HashMap<List<Double>, List<Driver>> driverMapChange) {
        Methods m = new Methods();
        for (Map.Entry<List<Double>, List<Driver>> location : driverMapChange.entrySet()) {
            if (!location.getValue().isEmpty()) {
                List<Driver> driverList = location.getValue();
                for (int i = 0; i < driverList.size(); i++) {
                    Driver driver = driverList.get(i);
                    Random random = new Random();
                    int leftORright = random.nextInt(2);
                    double moveR = Math.random() * 0.0001;

                    double dx = driver.getDriverLocation().get(0);
                    double dy = driver.getDriverLocation().get(1);

//                    double degreeLeft = driver.getBearing() - 0.5;
//                    double degreeRight = driver.getBearing() + 0.5;
//
//                    double newBearing = Math.random() * (degreeRight - degreeLeft) + degreeLeft;
                    //以90度为正北
                    double degreeOld = driver.getBearing() * 360;

                    double newDx = 0;
                    double newDy = 0;
                    double degreeNew = 0;

                    if (0 < degreeOld && degreeOld < 45 && 315 < degreeOld && degreeOld < 360) {
//                        System.out.println("车辆向西");
                        newDx = dx - moveR;
                        if (leftORright == 0) {
                            newDy = dy + moveR;
                            degreeNew = m.getNewDegree(dx, dy, newDx, newDy);
                        } else {
                            newDy = dy - moveR;
                            degreeNew = 360 - m.getNewDegree(dx, dy, newDx, newDy);
                        }
                    } else if (45 < degreeOld && degreeOld < 135) {
//                        System.out.println("车辆向北");
                        newDy = dy + moveR;
                        if (leftORright == 0) {
                            newDx = dx + moveR;
                            degreeNew = m.getNewDegree(dx, dy, newDx, newDy) + 90;
                        } else {
                            newDx = dx - moveR;
                            degreeNew = m.getNewDegree(dx, dy, newDx, newDy);
                        }
                    } else if (135 < degreeOld && degreeOld < 225) {
//                        System.out.println("车辆向东");
                        newDx = dx + moveR;
                        if (leftORright == 0) {
                            newDy = dy + moveR;
                            degreeNew = m.getNewDegree(dx, dy, newDx, newDy)+90;
                        } else {
                            newDy = dy - moveR;
                            degreeNew = m.getNewDegree(dx, dy, newDx, newDy) + 180;
                        }
                    } else if (225 < degreeOld && degreeOld < 315) {
//                        System.out.println("车辆向南");
                        newDy = dy - moveR;
                        if (leftORright == 0) {
                            newDx = dx + moveR;
                            degreeNew = m.getNewDegree(dx, dy, newDx, newDy) + 180;
                        } else {
                            newDx = dx - moveR;
                            degreeNew = m.getNewDegree(dx, dy, newDx, newDy) + 270;
                        }
                    }


                    List<Double> driveUpdateLo = new ArrayList<>();
                    driveUpdateLo.add(newDx);
                    driveUpdateLo.add(newDy);
                    driver.setDriverLocation(driveUpdateLo);
                    driver.setBearing(degreeNew);
//                    System.out.println("车辆运动");
                }
            }
        }
        System.out.println("==========车辆移动一次===========");
        return driverMapChange;
    }

    public Driver getNewDriver() {
        i = i + 1;
        Driver d = new Driver();
        List<Double> lo = new ArrayList<>();
        d.setDriverStatus("on");
        d.setDriverID(i);
        double loX = Math.random() * (n - m) + m;
        double loY = Math.random() * (e - q) + q;
        lo.add(loX);
        lo.add(loY);
        d.setDriverLocation(lo);
        return d;
    }


    public ArrayList<Driver> getDriverlist() {
        return driverlist;
    }

    public HashMap<List<Double>, List<Driver>> getDriverMap() {
        return driverMap;
    }

}
