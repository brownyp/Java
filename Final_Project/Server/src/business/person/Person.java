/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person;

import business.order.OrderDirectory;
import java.io.Serializable;
//import business.order.SoldOrderDirectory;

/**
 *
 * @author kkkevinxx
 */
public class Person implements Serializable{
    private String name;
    private int id;
    private String country;
    private String state;
    private String city;
    private String university;
    private String phoneNumber;
    private String zipCode;
    private String email;
    private OrderDirectory orderDirectory;
    private String picturePath;

    //private SoldOrderDirectory soldOrderDirectory;
    private static int count = 1;

    public Person() {
        this.orderDirectory = new OrderDirectory();
        //this.soldOrderDirectory = new SoldOrderDirectory();
        id = count;
        count++;
    }

    public String getPicturePath() {
        return picturePath;
    }

//    public SoldOrderDirectory getSoldOrderDirectory() {
//        return soldOrderDirectory;
//    }
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderDirectory orderDirectory) {
        this.orderDirectory = orderDirectory;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
