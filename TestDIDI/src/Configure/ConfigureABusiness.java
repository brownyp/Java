package Configure;

import Business.Driver;

import java.math.BigDecimal;
import java.util.*;

public class ConfigureABusiness {

    private double m = 104.00;
    private double n = 104.11;
    private double e = 30.1;
    private double q = 31.0;
    private int i = 1;
    private ArrayList<Driver> driverlist;
    private HashMap<List<Double>, List<Driver>> driverMap;

    public ConfigureABusiness() {
        //随机司机坐标
        int i = 1;
        this.driverlist = new ArrayList<>();
        this.driverMap = new HashMap<>();
        for (this.i = i; i < 20001; i++) {

            Driver d = new Driver();
            List<Double> lo = new ArrayList<>();
            d.setDriverStatus("on");
            d.setDriverID(i);
            double loX = Math.random() * (n - m) + m;
            double loY = Math.random() * (e - q) + q;
            lo.add(loX);
            lo.add(loY);
            d.setDriverLocation(lo);
            //以 当前角度/180，为角度系数
            double bearingDegree = Math.random();
            //随机朝北或朝南
            Random random = new Random();
            int northOrSouth = random.nextInt(2);

            if(northOrSouth==0){
                d.setBearing(bearingDegree);
            }else{
                d.setBearing(bearingDegree*-1);
            }
            driverlist.add(d);
        }

        for (int f = 1; f < 111; f++) {
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

    public HashMap<List<Double>, List<Driver>> changeDriverLo(HashMap<List<Double>, List<Driver>> driverMapChange) {
        for (Map.Entry<List<Double>, List<Driver>> location : driverMapChange.entrySet()) {
            if (!location.getValue().isEmpty()) {
                List<Driver> driverList = location.getValue();
                for (int i = 0; i < driverList.size(); i++) {
                    Driver driver = driverList.get(i);
                    Random random = new Random();
                    int wayNavi = random.nextInt(4);
                    int leftORright = random.nextInt(2);
                    double moveR = Math.random() * 0.0001;

                    double dx = driver.getDriverLocation().get(0);
                    double dy = driver.getDriverLocation().get(1);
                    if (wayNavi == 0) {
//                        System.out.println("车辆向西");
                        dx = dx - moveR;
                        if (leftORright == 0) {
                            dy = dy + moveR;
                        } else {
                            dy = dy - moveR;
                        }
                    } else if (wayNavi == 1) {
//                        System.out.println("车辆向北");
                        dy = dy + moveR;
                        if (leftORright == 0) {
                            dx = dx + moveR;
                        } else {
                            dx = dx - moveR;
                        }
                    } else if (wayNavi == 2) {
//                        System.out.println("车辆向东");
                        dx = dx + moveR;
                        if (leftORright == 0) {
                            dy = dy + moveR;
                        } else {
                            dy = dy - moveR;
                        }

                    } else if (wayNavi == 3) {
//                        System.out.println("车辆向南");
                        dy = dy - moveR;
                        if (leftORright == 0) {
                            dx = dx + moveR;
                        } else {
                            dx = dx - moveR;
                        }
                    }

                    List<Double> driveUpdateLo = new ArrayList<>();
                    driveUpdateLo.add(dx);
                    driveUpdateLo.add(dy);
                    driver.setDriverLocation(driveUpdateLo);
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
