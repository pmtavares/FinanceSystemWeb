package com.finance.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.finance.dao.ClientDAO;
import com.finance.dao.PersonDAO;
import com.finance.domain.Client;
import com.finance.domain.Person;

@ManagedBean()
@ViewScoped
public class ClientBean {
	
	private Client client;

	private List<Client> clients;
	private List<Person> persons;

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@PostConstruct
	public void toList() {
		try {
			ClientDAO clientDAO = new ClientDAO();
			clients = clientDAO.list("dateRegister");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Could not save client");
			erro.printStackTrace();
		}
	}

	public void New() {
		try {
			client = new Client();

			PersonDAO personDAO = new PersonDAO();
			persons = personDAO.list("name");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Could not saved Client");
			erro.printStackTrace();
		}
	}

	public void Save() {
		try {
			ClientDAO clienteDAO = new ClientDAO();
			clienteDAO.Merge(client);

			client = new Client();
			
			clients = clienteDAO.list("dateRegister");

			PersonDAO pessoaDAO = new PersonDAO();
			persons = pessoaDAO.list("name");
			
			Messages.addGlobalInfo("Client saved");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Could not saved client");
			erro.printStackTrace();
		}
	}
}
