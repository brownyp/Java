package Business;

import java.util.List;

public class Driver {
    private int driverID;
    private List<Double> driverLocation;
    private String driverStatus;
    private int onRoadT;
    private double aim;

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public List<Double> getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(List<Double> driverLocation) {
        this.driverLocation = driverLocation;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public int getOnRoadT() {
        return onRoadT;
    }

    public void setOnRoadT(int onRoadT) {
        this.onRoadT = onRoadT;
    }

    public double getAim() {
        return aim;
    }

    public void setAim(double aim) {
        this.aim = aim;
    }
}
