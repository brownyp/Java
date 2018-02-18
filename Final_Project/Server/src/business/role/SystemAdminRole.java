/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.system.EcoSystem;
import business.city.City;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.state.State;
import business.useraccount.UserAccount;
import java.io.Serializable;
import javax.swing.JPanel;
import userinterface.sysadmin.SystemAdminWorkAreaJPanel;

/**
 *
 * @author kkkevinxx
 */
public class SystemAdminRole extends Role implements Serializable{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, City city, State state, EcoSystem system) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }
    
}
