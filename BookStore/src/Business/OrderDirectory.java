/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author yupei
 */
public class OrderDirectory {
    private ArrayList<Order> orderDirectory;
    
    public OrderDirectory(){
        this.orderDirectory = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(ArrayList<Order> orderDirectory) {
        this.orderDirectory = orderDirectory;
    }
    
    public void addOrder(Order order){
        orderDirectory.add(order);
    }
    
    public void delOrder(Order order){
        orderDirectory.remove(order);
    }
    
}
