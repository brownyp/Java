/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;


import business.city.City;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.state.State;
import business.system.EcoSystem;
import business.useraccount.UserAccount;
import java.io.Serializable;
import javax.swing.JPanel;
import userinterface.enterpriseAdmin.EnterpriseAdminJPanel;

/**
 *
 * @author HP
 */
public class EnterpriseAdminRole extends Role implements Serializable{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, City city, State state, EcoSystem business) {
        return  new EnterpriseAdminJPanel(business,userProcessContainer);
    
    }
}