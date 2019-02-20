package com.financial.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import com.finance.dao.PersonDAO;
import com.finance.dao.UserDAO;
import com.finance.domain.Person;
import com.finance.domain.Users;

public class UserDAOTest {
	
	@Test
	@Ignore
	public void save()
	{
		PersonDAO personDao = new PersonDAO();
		Person person = personDao.searchById(5L);
		
		UserDAO userDAO = new UserDAO();
		Users user = new Users();
		user.setPerson(person);
		user.setActive(true);
		user.setType('B');
		user.setPassword("654321");
		
		
		
		userDAO.Save(user);
	}


}
