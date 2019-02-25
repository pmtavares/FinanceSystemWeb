package com.finance.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.finance.dao.CityDAO;
import com.finance.dao.StateDAO;
import com.finance.domain.City;
import com.finance.domain.State;

@ManagedBean()
@ViewScoped
public class CityBean implements Serializable  {
	private City city;
	private List<City> cities;
	private List<State> states;
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}

	@PostConstruct
	public void toList() {
		try {
			CityDAO cityDAO = new CityDAO();
			cities = cityDAO.toList();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error on cities");
			erro.printStackTrace();
		}
	}

	public void New() {
		try {
			city = new City();

			StateDAO stateDAO = new StateDAO();
			states = stateDAO.toList();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error on new city");
			erro.printStackTrace();
		}
	}
	
	public void save() {
		try {
			CityDAO cityDAO = new CityDAO();
			cityDAO.Merge(city);
			
			city = new City();
			StateDAO stateDAO = new StateDAO();
			states = stateDAO.toList();
			
			cities = cityDAO.toList();
			Messages.addGlobalInfo("City Saved!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("There was an error when trying to save");
			erro.printStackTrace();
		}
	}
	
	
	public void remove(ActionEvent event) {
		try {
			city = (City) event.getComponent().getAttributes().get("selectedCity");

			CityDAO cityDAO = new CityDAO();
			cityDAO.delete(city);
			
			cities = cityDAO.toList();

			Messages.addGlobalInfo("Register removed");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error to remove");
			erro.printStackTrace();
		}
	}
	
	public void toEdit(ActionEvent event){
		try {
			city = (City) event.getComponent().getAttributes().get("selectedCity");
			StateDAO stateDAO = new StateDAO();
			states = stateDAO.toList();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error to edit");
			erro.printStackTrace();
		}
		
	}
	
}
