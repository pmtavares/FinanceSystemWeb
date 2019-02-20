package com.financial.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import com.finance.dao.SupplierDAO;
import com.finance.domain.Product;
import com.finance.domain.Supplier;

public class SupplierDAOTest {
	@Test
//	/@Ignore
	public void save()
	{
		SupplierDAO supplierDAO = new SupplierDAO();
		Supplier supplier = new Supplier();
		supplier.setDescription("Coca-Cola");
		
		
		supplierDAO.Save(supplier);
	}

}
