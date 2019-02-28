package com.finance.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.finance.domain.City;
import com.finance.util.HibernateUtil;

public class CityDAO extends GenericDAO<City> {
	
	public List<City> searchByState(Long codeState)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try
		{
			Criteria query = session.createCriteria(City.class);
			query.add(Restrictions.eq("state.code", codeState));
			query.addOrder(Order.asc("name"));
			List<City> result = query.list();
			return result;
		}
		catch(RuntimeException error)
		{
			throw error;
		}
		finally {
			session.close();
		}
	}

}
