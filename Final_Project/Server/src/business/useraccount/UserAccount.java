/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.useraccount;

import business.person.Person;
import business.role.Role;
import business.usermessage.MessageDirectory;
import java.io.Serializable;
//import business.usermessage.SentMessageDirectory;

/**
 *
 * @author kkkevinxx
 */
public class UserAccount implements Serializable{

    private String username;
    private String password;
    private Person person;
    private Role role;
    private String Status;
    //private SentMessageDirectory sentMessageDirectory;
    private MessageDirectory messageDirectory;

    

    public UserAccount() {
        //sentMessageDirectory = new SentMessageDirectory();
        messageDirectory = new MessageDirectory();
    }

//    public SentMessageDirectory getSentMessageDirectory() {
//        return sentMessageDirectory;
//    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    public MessageDirectory getMessageDirectory() {
        return messageDirectory;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }



    

    @Override
    public String toString() {
        return username;
    }
}
