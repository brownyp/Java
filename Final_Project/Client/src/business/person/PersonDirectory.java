/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public class PersonDirectory implements Serializable{
    private ArrayList<Person> personList;
    
    public PersonDirectory(){
        this.personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    
    public Person createAndAddPerson(String name, String country, String state, String city, String university, String zipCode, String phoneNumber, String email, String picturePath){
        Person person = new Person();
        person.setName(name);
        person.setCountry(country);
        person.setState(state);
        person.setCity(city);
        person.setUniversity(university);
        person.setEmail(email);
        person.setPhoneNumber(phoneNumber);
        person.setZipCode(zipCode);
        person.setPicturePath(picturePath);
        personList.add(person);
        return person;
    }
    
    
}
