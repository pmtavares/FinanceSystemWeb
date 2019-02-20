package com.financial.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.finance.dao.CityDAO;
import com.finance.dao.StateDAO;
import com.finance.domain.City;
import com.finance.domain.State;

public class CityDAOTest {

	@Test
	//@Ignore
	public void save()
	{
		StateDAO stateDAO = new StateDAO();
		State state = stateDAO.searchById(1L);
		
		CityDAO cityDao = new CityDAO();
		City city = new City();
		city.setName("Dublin city");
		city.setState(state);
		
		cityDao.Save(city);
	}
	@Test
	@Ignore
	public void toList()
	{
		CityDAO cityDao = new CityDAO();
		List<City> result = cityDao.toList();
		
		System.out.println("Total of records found: " + result.size());
		for(City city: result)
		{
			System.out.println("State is:  " + city.getName());
		}
		
	}
	
	
	@Test
	@Ignore
	public void searchById()
	{
		CityDAO cityDao = new CityDAO();
		City result = cityDao.searchById(5L);
		
		System.out.println("Result is:  " + result.getName());
		
	}
	@Test
	@Ignore
	public void delete()
	{
		CityDAO cityDao = new CityDAO();
		City result = cityDao.searchById(7L);
		
		if(result == null)
		{
			System.out.println("No records found");
		}
		else
		{
			cityDao.delete(result);
			System.out.println("Record " + result.getName() + " removed");
		}
		
	}
	@Test
	@Ignore
	public void edit(){
		Long code = 6L;
		CityDAO cityDao = new CityDAO();
		City city = cityDao.searchById(code);
		StateDAO stateDao = new StateDAO();
		State state = stateDao.searchById(3L);
		
		if(city == null){
			System.out.println("No record found");
		}else{
			System.out.println("Record edited: before");
			System.out.println(city.getCode() + " - " + city.getState()+ " - " + city.getName());
			
			
			city.setName("Bray City");
			city.setState(state);
			cityDao.edit(city);
			
			System.out.println("Record edited after:");
			System.out.println(city.getCode() + " - " + city.getName()+ " - " + city.getState());
			
		}
	}
	
}
