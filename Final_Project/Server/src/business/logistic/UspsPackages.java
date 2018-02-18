/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.logistic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UspsPackages implements Serializable{
    ArrayList<Package> uspsPackageDirectory;
    public UspsPackages(){
        uspsPackageDirectory=new ArrayList<>();
    }

    public ArrayList<Package> getUspsPackageDirectory() {
        return uspsPackageDirectory;
    }

    public void setUspsPackageDirectory(ArrayList<Package> uspsPackageDirectory) {
        this.uspsPackageDirectory = uspsPackageDirectory;
    }
     public Package addUspsPackage(){
        Package p=new Package();
        uspsPackageDirectory.add(p);
        return p;
    }
}
