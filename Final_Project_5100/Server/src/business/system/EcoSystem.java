
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.system;

import business.network.Network;
import business.network.NetworkDirectory;
import business.organization.Organization;
import business.role.Role;
import business.role.SystemAdminRole;
import java.io.Serializable;
import java.util.ArrayList;
import business.logistic.FedexPackages;
import business.logistic.UspsPackages;

/**
 *
 * @author kkkevinxx
 */
public class EcoSystem extends Organization implements Serializable{
    private NetworkDirectory networkDirectory;
    private static EcoSystem system;
    private FedexPackages fps;
    private UspsPackages ups;
    public static EcoSystem getInstance() {
        if (system == null) {
            system = new EcoSystem();
        }
        return system;
    }

    private EcoSystem() {
        super(null);
        this.networkDirectory = new NetworkDirectory();
        fps=new FedexPackages();
        ups=new UspsPackages();
                
    }

    public FedexPackages getFps() {
        return fps;
    }

    public void setFps(FedexPackages fps) {
        this.fps = fps;
    }

    public UspsPackages getUps() {
        return ups;
    }

    public void setUps(UspsPackages ups) {
        this.ups = ups;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }
        return true;
    }

    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }

    public void setNetworkDirectory(NetworkDirectory networkDirectory) {
        this.networkDirectory = networkDirectory;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
}
