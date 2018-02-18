/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.state;

import business.city.CityDirectory;
import java.io.Serializable;

/**
 *
 * @author kkkevinxx
 */
public class State implements Serializable{

    private String name;
    private CityDirectory cityDirectory;
    
    public State(){
        this.cityDirectory = new CityDirectory();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public CityDirectory getCityDirectory() {
        return cityDirectory;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
