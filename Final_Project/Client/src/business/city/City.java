/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.city;

import business.enterprise.EnterpriseDirectory;
import java.io.Serializable;

/**
 *
 * @author kkkevinxx
 */
public class City implements Serializable{
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    
    public City(){
        this.enterpriseDirectory = new EnterpriseDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    @Override
    public String toString(){
        return this.name;
    }
    
}
