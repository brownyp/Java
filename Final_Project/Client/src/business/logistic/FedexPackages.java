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
public class FedexPackages implements Serializable{
     ArrayList<Package> fedexPackageDirectory;
    public FedexPackages(){
        fedexPackageDirectory=new ArrayList<>();
    }

    public ArrayList<Package> getFedexPackageDirectory() {
        return fedexPackageDirectory;
    }

    public void setFedexPackageDirectory(ArrayList<Package> fedexPackageDirectory) {
        this.fedexPackageDirectory = fedexPackageDirectory;
    }
    public Package addFedexPackage(){
        Package p=new Package();
        fedexPackageDirectory.add(p);
        return p;
    }
            
}
