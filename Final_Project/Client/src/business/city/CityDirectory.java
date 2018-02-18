/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.city;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public class CityDirectory implements Serializable{
    private ArrayList<City> cityList;
    public CityDirectory(){
        this.cityList = new ArrayList<>();
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }
    
    public City createAndAddCity(String name) {
        City city = new City();
        city.setName(name);
        this.cityList.add(city);
        return city;
    } 
}
