/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usermessage;

import business.product.Product;
import business.useraccount.UserAccount;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kkkevinxx
 */
public class Message implements Serializable{

    private String content;
    private UserAccount sender;
    private UserAccount receiver;
    private Product product;
    private String sentTime;
    private String status;
    private Message responseM;

    public Message getResponseM() {
        return responseM;
    }

    public void setResponseM(Message responseM) {
        this.responseM = responseM;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
