/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.Role;
import business.role.UserRole;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public class UserOrganization extends Organization implements Serializable{
    public UserOrganization() {
        super(Type.User.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new UserRole());
        return roles;
    }
}
