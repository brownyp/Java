/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.logistic;

import com.sun.org.apache.xml.internal.serializer.ToStream;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Location implements Serializable {
    String Date;
    String Location;

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
    public String toString(){
        return Date;
    }
}
