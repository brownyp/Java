/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public class EnterpriseDirectory implements Serializable{
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        this.enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type, String countryString, String stateString , String cityString) {
        Enterprise enterprise = null;
//        if (type == Enterprise.EnterpriseType.CityAdmin) {
//            enterprise = new CityAdmin(name);
//            enterpriseList.add(enterprise);
//        }
        if (type == Enterprise.EnterpriseType.University) {
            enterprise = new University(name,countryString, stateString, cityString);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}
