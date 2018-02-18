/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.logistic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.tools.DocumentationTool;

/**
 *
 * @author HP
 */
public class Package implements Serializable {
    String express;
    int TrackingNum;
    String RecipientName;
    String SenderName;
    String RecipientAddress;
    String SenderAddress;
    String Status;
    public static int counter=65879087;
    
    ArrayList<Location> locations;
    
    public Package(){
    locations=new ArrayList<>();
    TrackingNum=counter;
    counter++;
    }

   

   

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }
    
    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public int getTrackingNum() {
        return TrackingNum;
    }

    public void setTrackingNum(int TrackingNum) {
        this.TrackingNum = TrackingNum;
    }

    public String getRecipientName() {
        return RecipientName;
    }

    public void setRecipientName(String RecipientName) {
        this.RecipientName = RecipientName;
    }

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String SenderName) {
        this.SenderName = SenderName;
    }

    public String getRecipientAddress() {
        return RecipientAddress;
    }

    public void setRecipientAddress(String RecipientAddress) {
        this.RecipientAddress = RecipientAddress;
    }

    public String getSenderAddress() {
        return SenderAddress;
    }

    public void setSenderAddress(String SenderAddress) {
        this.SenderAddress = SenderAddress;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    public Location addLocation(String Date,String LocationString){
      Location location=new Location();
      location.setDate(Date);
      location.setLocation(LocationString);
      locations.add(location);
      return location;
    }

    
}
