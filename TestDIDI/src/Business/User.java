package Business;

import java.util.List;

public class User {
    private String userID;
    private int startT;
    private int endT;
    private List<Double> userLocation;
    private List<Double> userAimLocation;
    private double userBearing;

    public double getUserBearing() {
        return userBearing;
    }

    public void setUserBearing(double userBearing) {
        this.userBearing = userBearing;
    }

    private String status;

    public List<Double> getUserAimLocation() {
        return userAimLocation;
    }

    public void setUserAimLocation(List<Double> userAimLocation) {
        this.userAimLocation = userAimLocation;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getStartT() {
        return startT;
    }

    public void setStartT(int startT) {
        this.startT = startT;
    }

    public int getEndT() {
        return endT;
    }

    public void setEndT(int endT) {
        this.endT = endT;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Double> getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(List<Double> userLocation) {
        this.userLocation = userLocation;
    }

}
