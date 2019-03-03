package com.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.finance.domain.ItemSale;
import com.finance.domain.Sale;
import com.finance.util.HibernateUtil;

public class SaleDAO extends GenericDAO<Sale>{
	
	public void Save(Sale sale, List<ItemSale> itensSale){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
		
			session.save(sale);
			
			for(int position = 0; position < itensSale.size(); position++){
				ItemSale itemSale = itensSale.get(position);
				itemSale.setSale(sale);
				
				session.save(itemSale);
			}
			
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			session.close();
		}
	}

}
