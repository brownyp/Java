/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.product;

import business.useraccount.UserAccount;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public class ProductMessageDirectory implements Serializable{
    private ArrayList<ProductMessage> productMessagesList;

    public ProductMessageDirectory(){
        this.productMessagesList = new ArrayList<>();
    }
    
    public ArrayList<ProductMessage> getProductMessagesList() {
        return productMessagesList;
    }
    
    public ProductMessage createProductMessage(String head, String content, UserAccount senter, String sentDate){
        ProductMessage pm = new ProductMessage();
        pm.setHead(head);
        pm.setContent(content);
        pm.setSentDate(sentDate);
        pm.setSenter(senter);
        this.productMessagesList.add(pm);
        return pm;
    }
    
}
