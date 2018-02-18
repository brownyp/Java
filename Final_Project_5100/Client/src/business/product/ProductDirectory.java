/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.product;

import business.useraccount.UserAccount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kkkevinxx
 */
public class ProductDirectory implements Serializable{

    private ArrayList<Product> productList;
    
    public ProductDirectory(){
        this.productList = new ArrayList<>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    public Product createProduct(String productName,String description,String publishDate,String soldDate,String Status,int productPrice,int productOriginPrice,String Catagory, UserAccount userAccount, String imagePath){
        Product p = new Product();
        p.setProductName(productName);
        p.setDescription(description);
        p.setPublishDate(publishDate);
        p.setSoldDate(soldDate);
        p.setStatus(Status);
        p.setProductPrice(productPrice);
        p.setProductOriginPrice(productOriginPrice);
        p.setCatagory(Catagory);
        p.setUserAccount(userAccount);
        p.setImagePath(imagePath);
        productList.add(p);
        return p;
    }
    
}
