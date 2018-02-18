/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.order;

import business.product.Product;
import business.useraccount.UserAccount;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public class OrderDirectory implements Serializable{

    private ArrayList<Order> orderList;

    public OrderDirectory() {
        this.orderList = new ArrayList<>();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public Order CreateOrders(Product product, String orderDate, String recipientName, String recipientPhone, String recipientAddress, String express, UserAccount buyer, UserAccount seller, String status, int rating) {
        Order o = new Order();
        o.setProduct(product);
        o.setOrderDate(orderDate);
        o.setExpress(express);
        o.setRecipientAddress(recipientAddress);
        o.setRecipientName(recipientName);
        o.setRecipientPhone(recipientPhone);
        o.setBuyer(buyer);
        o.setSeller(seller);
        o.setOrderStatus(status);
        o.setRating(rating);
        o.setTrackingNum("not created");
        orderList.add(o);
        return o;

    }
}
