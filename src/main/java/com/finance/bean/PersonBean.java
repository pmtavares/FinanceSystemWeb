package com.finance.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import com.finance.dao.CityDAO;
import com.finance.dao.PersonDAO;
import com.finance.dao.StateDAO;
import com.finance.domain.City;
import com.finance.domain.Person;
import com.finance.domain.State;

@ManagedBean()
@ViewScoped
public class PersonBean {
	private Person person;
	private List<Person> people;

	private List<State> states;
	private List<City> cities;
	
	private State state;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Person> getPeople() {
		return people;
	}
	public void setPeople(List<Person> people) {
		this.people = people;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	@PostConstruct
	public void toList() {
		try {
			PersonDAO personDAO = new PersonDAO();
			people = personDAO.toList();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("An error occurred to list people");
			erro.printStackTrace();
		}
	}

	public void New() {
		try {
			person = new Person();

			StateDAO stateDAO = new StateDAO();
			states = stateDAO.list("name");

			cities = new ArrayList<City>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("There was an error to create a person");
			erro.printStackTrace();
		}
	}

	public void toEdit(ActionEvent event) {

	}

	public void Save() {
		try {
			PersonDAO personDAO = new PersonDAO();
			//person.setState(state);
			personDAO.Merge(person);
			
			people = personDAO.list("name");
			
			person = new Person();
			
			state = new State();

			StateDAO stateDAO = new StateDAO();
			states = stateDAO.list("name");

			cities = new ArrayList<>();
			Messages.addGlobalInfo("Person Saved");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("There was an error to save person");
			erro.printStackTrace();
		}
	}

	public void Remove(ActionEvent event) {

	}
	
	public void getCitiesByState()
	{
		try
		{
			if(person.getState() != null)
			{
				CityDAO cityDao = new CityDAO();
				cities = cityDao.searchByState(person.getState().getCode());
			}
			else
			{
				cities = new ArrayList<>();
			}
		}
		catch(RuntimeException error)
		{
			Messages.addGlobalError("Some error happened");
			error.printStackTrace();
		}
	}

}
