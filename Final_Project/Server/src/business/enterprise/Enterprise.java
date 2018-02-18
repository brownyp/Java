/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.Organization;
import business.organization.OrganizationDirectory;
import java.io.Serializable;

/**
 *
 * @author kkkevinxx
 */
public abstract class Enterprise extends Organization implements Serializable{
    private String name;
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private String countryString;
    private String stateString;
    private String cityString;
    
    
    public Enterprise(String name, EnterpriseType type, String countryString, String stateString , String cityString) {
        super(name);
        this.name=name;
        this.enterpriseType = type;
        this.countryString = countryString;
        this.stateString = stateString;
        this.cityString = cityString;
        organizationDirectory = new OrganizationDirectory();
    }
    
    public enum EnterpriseType{
        University("University");
        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public String getNetwork() {
        return countryString;
    }

    public void setNetwork(String network) {
        this.countryString = network;
    }

    public String getStateString() {
        return stateString;
    }

    public void setStateString(String stateString) {
        this.stateString = stateString;
    }

    public String getCityString() {
        return cityString;
    }

    public void setCityString(String cityString) {
        this.cityString = cityString;
    }
    
   
    @Override
    public String toString(){
        return this.name;
    }
}
