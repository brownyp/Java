/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author yupei
 */
public class UserDirectory {
    private ArrayList<User> userDirectory;
    
    public UserDirectory(){
        this.userDirectory = new ArrayList<User>();
    }

    public ArrayList<User> getUserDirectory() {
        return userDirectory;
    }

    public void setUserDirectory(ArrayList<User> userDirectory) {
        this.userDirectory = userDirectory;
    }
    
    public void delUser(User user){
        userDirectory.remove(user);
    }
    
    public  void addUser(User user){
        userDirectory.add(user);
    }
}
