package com.financial.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.junit.Ignore;
import org.junit.Test;

import com.finance.dao.ClientDAO;
import com.finance.dao.PersonDAO;
import com.finance.domain.Client;
import com.finance.domain.Person;
import com.finance.domain.Product;
import com.finance.domain.Supplier;

public class ClientDAOTest {
	@Test
	//@Ignore
	public void save() throws ParseException
	{
		PersonDAO personDAO = new PersonDAO();
		Person person = personDAO.searchById(4L);
		
		ClientDAO clientDAO = new ClientDAO();
		Client client = new Client();//clientDAO.searchById(2L);
		
		LocalDateTime ldt = LocalDateTime.now();
		//System.out.println(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt));
		client.setDateRegister(new SimpleDateFormat("dd/MM/yyyy").parse("15/02/2019"));
		client.setActive(true);
		client.setPerson(person);

		
		clientDAO.Save(client);
	}


}
