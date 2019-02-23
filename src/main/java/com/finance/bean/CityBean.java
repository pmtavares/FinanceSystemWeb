package com.finance.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.finance.dao.CityDAO;
import com.finance.dao.StateDAO;
import com.finance.domain.City;
import com.finance.domain.State;

@ManagedBean()
@ViewScoped
public class CityBean {
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
	
}
