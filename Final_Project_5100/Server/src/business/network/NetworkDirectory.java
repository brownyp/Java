/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public class NetworkDirectory implements Serializable{
    private ArrayList<Network> networkList;
    
    public NetworkDirectory(){
        this.networkList = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public Network createAndAddNetwork(String name) {
        Network network = new Network();
        network.setName(name);
        this.networkList.add(network);
        return network;
    } 
}
