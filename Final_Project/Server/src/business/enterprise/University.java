/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.role.Role;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public class University extends Enterprise implements Serializable{
    public University(String name, String countryString, String stateString , String cityString) {
        super(name, Enterprise.EnterpriseType.University,countryString, stateString, cityString);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
