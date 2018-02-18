/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usermessage;

import business.product.Product;
import business.useraccount.UserAccount;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public class MessageDirectory implements Serializable{
    private ArrayList<Message> messageList;
    
    public MessageDirectory(){
        this.messageList = new ArrayList<>();
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }
    
    public Message createMessage(String content, String status, String sentTime, UserAccount sender, UserAccount receiver, Product product, Message responseM){
        Message m = new Message();
        m.setContent(content);
        m.setProduct(product);
        m.setReceiver(receiver);
        m.setResponseM(responseM);
        m.setSender(sender);
        m.setSentTime(sentTime);
        m.setStatus(status);
        messageList.add(m);
        return m;
    }
}
