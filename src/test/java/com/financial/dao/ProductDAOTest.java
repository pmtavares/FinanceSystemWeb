package com.financial.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import com.finance.dao.ProductDAO;
import com.finance.dao.SupplierDAO;
import com.finance.domain.Product;
import com.finance.domain.Supplier;

public class ProductDAOTest {
	
	@Test
	@Ignore
	public void save()
	{
		SupplierDAO supplierDAO = new SupplierDAO();
		Supplier supplier = supplierDAO.searchById(2L);
		
		
		ProductDAO productDao = new ProductDAO();
		Product product = new Product();
		product.setDescription("Condensed Milk");
		product.setQuantity((short)10);
		product.setValue(new BigDecimal("9.81"));
		product.setSupplier(supplier);
		
		productDao.Save(product);
	}

}
