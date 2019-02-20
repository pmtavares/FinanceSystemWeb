package com.financial.dao;

import org.junit.Ignore;
import org.junit.Test;

import com.finance.dao.CityDAO;
import com.finance.dao.PersonDAO;
import com.finance.domain.City;
import com.finance.domain.Person;
import com.finance.domain.Users;

public class PersonDAOTest {
	@Test
	@Ignore
	public void save()
	{
		CityDAO cityDao = new CityDAO();
		City city = cityDao.searchById(3L);
		PersonDAO personDao = new PersonDAO();
		Person person = new Person();
		
		person.setName("Genifer ");
		person.setEmail("gen@gen.com");
		person.setStreet("Mak Road");
		person.setNumber((short) 05);
		person.setPostcode("C12");
		person.setComplement("Clare 12");
		person.setRegion("South");
		person.setPps("987456");
		person.setPhone("012345");
		person.setCity(city);
		
		
		
		personDao.Save(person);
	}


}
