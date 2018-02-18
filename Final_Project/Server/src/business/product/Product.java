/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.product;

import business.useraccount.UserAccount;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kkkevinxx
 */
public class Product implements Serializable {

    private String productName;
    private String description;
    private String publishDate;
    private String soldDate;
    private UserAccount userAccount;
    private String Status;
    private int productPrice;
    private int productOriginPrice;
    private String Catagory;
    private String imagePath;
    private ProductMessageDirectory productMessageDirectory;
    private double longitude;
    private double latitude;
    private String verify;
    //static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Product() {
        this.productMessageDirectory = new ProductMessageDirectory();
    }

    public enum Category {
        All("All"), Electronics("Electronics"), Furniture("Furniture"), DailyUse("Daily Use"),
        Food("Food"), Clothing("Clothing"), Traffic("Traffic");
        private String value;

        private Category(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public ProductMessageDirectory getProductMessageDirectory() {
        return productMessageDirectory;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCatagory() {
        return Catagory;
    }

    public void setCatagory(String Catagory) {
        this.Catagory = Catagory;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductOriginPrice() {
        return productOriginPrice;
    }

    public void setProductOriginPrice(int productOriginPrice) {
        this.productOriginPrice = productOriginPrice;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getPublishDate() {
//        return sdf.format(publishDate);
//    }
//
//    public void setPublishDate(String publishDate) {
//        try{
//           this.publishDate =sdf.parse(publishDate) ;
//        }
//        catch (Exception e){
//            System.out.println("Wrong date format!");
//            
//        }
//    }
//    public String getSoldDate() {
//        return sdf.format(soldDate);
//    }
//
//    public void setSoldDate(String soldDate) {
//        this.soldDate=null;
//        try{
//           this.soldDate =sdf.parse(soldDate) ;
//        }
//        catch (Exception e){
//            System.out.println("Wrong date format!");
//        }
//    }
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return this.productName;
    }
}
