/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.person.PersonDirectory;
import business.product.ProductDirectory;
import business.role.Role;
import business.useraccount.UserAccountDirectory;
import java.io.Serializable;
//import business.usermessage.SentMessageDirectory;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public abstract class Organization implements Serializable{
    private String name;
    //private SentMessageDirectory workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private ProductDirectory productDirectory;
    private int organizationID;
    private static int counter;
    
    public enum Type{
        Admin("Admin Organization"), User("User Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name) {
        this.name = name;
        //workQueue = new SentMessageDirectory();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        productDirectory = new ProductDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public ProductDirectory getProductDirectory() {
        return productDirectory;
    }
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    
    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
