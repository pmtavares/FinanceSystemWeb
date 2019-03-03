package com.finance.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.finance.domain.Staff;
import com.finance.util.HibernateUtil;


public class StaffDAO extends GenericDAO<Staff>{
	public List<Staff> orderedList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria query = session.createCriteria(Staff.class);
			query.createAlias("person", "p");
			query.addOrder(Order.asc("p.name"));
			List<Staff> resultado = query.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			session.close();
		}
	}
}
