/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.order;

import business.product.Product;
import business.useraccount.UserAccount;
import java.io.Serializable;
import jdk.nashorn.internal.runtime.UserAccessorProperty;

/**
 *
 * @author kkkevinxx
 */
public class Order implements Serializable{

    
    private String recipientName;
    private String recipientPhone;
    private String recipientAddress;
    private String express;
    private UserAccount buyer;
    private UserAccount seller;
    private Product product;
    private String orderDate;
    private String orderStatus;
    private int rating;
 private String TrackingNum;
            
    public int getRating() {
        return rating;
    }

    public String getTrackingNum() {
        return TrackingNum;
    }

    public void setTrackingNum(String TrackingNum) {
        this.TrackingNum = TrackingNum;
    }
    

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UserAccount getBuyer() {
        return buyer;
    }

    public void setBuyer(UserAccount buyer) {
        this.buyer = buyer;
    }

    public UserAccount getSeller() {
        return seller;
    }

    public void setSeller(UserAccount seller) {
        this.seller = seller;
    }

    

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    @Override
    public String toString() {
        return this.recipientName;
    }
}
