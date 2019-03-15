package com.finance.dao;



import org.hibernate.criterion.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.finance.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public class GenericDAO<Entity> {
	
	
	private Class<Entity> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void Save(Entity entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction  transaction = null;  

		try {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (RuntimeException erro) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw erro;
		} finally {
			session.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Entity> toList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria query = session.createCriteria(classe);
			List<Entity> result  = query.list();
			return result;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			session.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Entity> list(String orderField) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria query = session.createCriteria(classe);
			query.addOrder(Order.asc(orderField));
			List<Entity> resultado = query.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entity searchById(Long code) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			//Get Criteria Builder
			Criteria builder = session.createCriteria(classe);

			builder.add(Restrictions.idEq(code));
			Entity result = (Entity) builder.uniqueResult();
			return result;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			session.close();
		}
	}
	
	public void delete(Entity entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
		} catch (RuntimeException erro) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw erro;
		} finally {
			session.close();
		}
	}
	
	
	public void edit(Entity entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
		} catch (RuntimeException erro) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw erro;
		} finally {
			session.close();
		}
	}
	
	public Entity Merge(Entity entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction  transaction = null;  

		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			Entity result = (Entity) session.merge(entity);
			transaction.commit();
			return result;
		} catch (RuntimeException erro) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw erro;
		} finally {
			session.close();
		}
		
	}


	@Override
	public String toString() {
		return "GenericDAO [classe=" + classe + ", toList()=" + toList() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericDAO other = (GenericDAO) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		return true;
	}
	
	

	
}
