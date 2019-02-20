package com.financial.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;


import com.finance.dao.StateDAO;
import com.finance.domain.State;

//@RunWith(SpringRunner.class)
//@SpringBootTest(properties = "spring.profiles.active=test")
public class StateDAOTest {
	
	@Test
	//@Ignore
	public void save()
	{
		State state = new State();
		state.setInitial("DU");
		state.setName("Dublin");
		
		
		StateDAO stateDAO = new StateDAO();
		stateDAO.Save(state);
	}
	@Test
	@Ignore
	public void toList()
	{
		StateDAO stateDao = new StateDAO();
		List<State> result = stateDao.toList();
		
		System.out.println("Total of records found: " + result.size());
		for(State state: result)
		{
			System.out.println("State is:  " + state.getName());
		}
		
	}
	
	
	@Test
	@Ignore
	public void searchById()
	{
		StateDAO stateDao = new StateDAO();
		State result = stateDao.searchById(1L);
		
		System.out.println("Result is:  " + result.getName());
		
	}
	@Test
	@Ignore
	public void delete()
	{
		StateDAO stateDao = new StateDAO();
		State result = stateDao.searchById(1L);
		
		if(result == null)
		{
			System.out.println("No records found");
		}
		else
		{
			stateDao.delete(result);
			System.out.println("Record " + result.getName() + " removed");
		}
		
	}
	@Test
	@Ignore
	public void edit(){
		Long code = 2L;
		StateDAO stateDao = new StateDAO();
		State state = stateDao.searchById(code);
		
		if(state == null){
			System.out.println("No record found");
		}else{
			System.out.println("Record edited: before");
			System.out.println(state.getCode() + " - " + state.getInitial()+ " - " + state.getName());
			
			state.setName("Wickow");
			state.setInitial("WI");
			stateDao.edit(state);
			
			System.out.println("Record edited after:");
			System.out.println(state.getCode() + " - " + state.getInitial()+ " - " + state.getName());
			
		}
	}
	

}
