package Business;

import java.util.List;

public class Order {
    private int orderID=1;
    private int orderStartT;
    private int orderEndT;
    private List<Double> orderStartL;
    private List<Double> orderEndL;
    private int driverID;
    private String userID;
    private double manhattanDistance;

    public double getManhattanDistance() {
        return manhattanDistance;
    }

    public void setManhattanDistance(double manhattanDistance) {
        this.manhattanDistance = manhattanDistance;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID() {
        this.orderID = orderID+1;
    }

    public int getOrderStartT() {
        return orderStartT;
    }

    public void setOrderStartT(int orderStartT) {
        this.orderStartT = orderStartT;
    }

    public int getOrderEndT() {
        return orderEndT;
    }

    public void setOrderEndT(int orderEndT) {
        this.orderEndT = orderEndT;
    }

    public List<Double> getOrderStartL() {
        return orderStartL;
    }

    public void setOrderStartL(List<Double> orderStartL) {
        this.orderStartL = orderStartL;
    }

    public List<Double> getOrderEndL() {
        return orderEndL;
    }

    public void setOrderEndL(List<Double> orderEndL) {
        this.orderEndL = orderEndL;
    }

}
