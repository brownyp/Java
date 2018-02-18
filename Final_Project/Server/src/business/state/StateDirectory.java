/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.state;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kkkevinxx
 */
public class StateDirectory implements Serializable{
    private ArrayList<State> stateList;

    
    public StateDirectory(){
        this.stateList = new ArrayList<>();
    }

    public ArrayList<State> getStateList() {
        return stateList;
    }
    
    public State createAndAddState(String name) {
        State state = new State();
        state.setName(name);
        this.stateList.add(state);
        return state;
    }
}
