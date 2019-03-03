package com.finance.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.finance.dao.PersonDAO;
import com.finance.dao.UserDAO;
import com.finance.domain.Person;
import com.finance.domain.Users;

@ManagedBean()
@ViewScoped
public class UsersBean implements Serializable {
	
	private Users user;
	
	private List<Person> persons;
	private List<Users> users;
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	@PostConstruct
	public void toList(){
		try{
			UserDAO userDAO = new UserDAO();
			users = userDAO.list("type");
		}catch(RuntimeException erro){
			Messages.addGlobalError("Could not list the user");
			erro.printStackTrace();
		}
	}
	
	public void New() {
		try {
			user = new Users();

			PersonDAO personDAO = new PersonDAO();
			persons = personDAO.list("name");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Could not create the user");
			erro.printStackTrace();
		}
	}

	public void Save() {
		try {
			UserDAO userDAO = new UserDAO();
			userDAO.Merge(user);
			
			user = new Users();
			users = userDAO.list("type");
			
			PersonDAO personDAO = new PersonDAO();
			persons = personDAO.list("name");
			
			Messages.addGlobalInfo("User saved!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Could not saved the user");
			erro.printStackTrace();
		}
	}

}
