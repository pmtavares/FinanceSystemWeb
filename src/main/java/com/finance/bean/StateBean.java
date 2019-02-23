package com.finance.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.finance.dao.StateDAO;
import com.finance.domain.State;


@ManagedBean()
@ViewScoped
public class StateBean implements Serializable {
	
	public void save1()
	{
		Messages.addGlobalInfo("Programming web");
	}
	
	private State state;
	private List<State> states;
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public void New() {
		this.state = new State();
	}
	
	public void save() {
		try {
			StateDAO stateDAO = new StateDAO();
			stateDAO.Merge(state);

			New();
			states = stateDAO.toList();

			Messages.addGlobalInfo("State Saved!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("There was an error when trying to save");
			erro.printStackTrace();
		}
	}
	@PostConstruct
	public void toList(){
		try{
			StateDAO stateDAO = new StateDAO();
			this.states = stateDAO.toList();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Could not retrieve states");
			erro.printStackTrace();
		}
	}
	
	public void remove(ActionEvent event) {
		try {
			state = (State) event.getComponent().getAttributes().get("selectedState");

			StateDAO stateDAO = new StateDAO();
			stateDAO.delete(state);
			
			states = stateDAO.toList();

			Messages.addGlobalInfo("Register removed");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error to remove");
			erro.printStackTrace();
		}
	}
	
	public void toEdit(ActionEvent event){
		try {
			state = (State) event.getComponent().getAttributes().get("selectedState");

			//StateDAO stateDAO = new StateDAO();
			//stateDAO.delete(state);
			
			//states = stateDAO.toList();

			//Messages.addGlobalInfo("Register removed");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error to edit");
			erro.printStackTrace();
		}
		
	}
	

}
