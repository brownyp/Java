/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.product;

import business.useraccount.UserAccount;
import java.io.Serializable;

/**
 *
 * @author kkkevinxx
 */
public class ProductMessage implements Serializable{
    private String head;
    private String content;
    private UserAccount senter;
    private String sentDate;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserAccount getSenter() {
        return senter;
    }

    public void setSenter(UserAccount senter) {
        this.senter = senter;
    }

    

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }
    
    @Override
    public String toString(){
        return this.head;
    }
}
