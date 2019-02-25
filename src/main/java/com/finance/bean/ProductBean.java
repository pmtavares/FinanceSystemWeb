package com.finance.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.finance.dao.ProductDAO;
import com.finance.dao.SupplierDAO;
import com.finance.domain.Product;
import com.finance.domain.Supplier;

public class ProductBean {
	
	private Product  product;
	private List<Product> products;
	private List<Supplier> supplier;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Supplier> getSupplier() {
		return supplier;
	}
	public void setSupplier(List<Supplier> supplier) {
		this.supplier = supplier;
	}
	
	
	@PostConstruct
	public void toList() {
		try {
			ProductDAO ProductDAO = new ProductDAO();
			products = ProductDAO.toList();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("There was an error to retrieve");
			erro.printStackTrace();
		}
	}
	
	public void New() {
		try {
			product = new Product();

			SupplierDAO supplierDAO = new SupplierDAO();
			supplier = supplierDAO.toList();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error to add");
			erro.printStackTrace();
		}
	}
	
	public void toEdit(ActionEvent event){
		try {
			product = (Product) event.getComponent().getAttributes().get("selectedProduct");

			SupplierDAO SupplierDAO = new SupplierDAO();
			supplier = SupplierDAO.toList();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error to edit");
			erro.printStackTrace();
		}	
	}
	
	public void Save() {
		try {
			ProductDAO ProductDAO = new ProductDAO();
			ProductDAO.Merge(product);

			product = new Product();

			SupplierDAO SupplierDAO = new SupplierDAO();
			supplier = SupplierDAO.toList();

			products = ProductDAO.toList();

			Messages.addGlobalInfo("Product Saved");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error to save");
			erro.printStackTrace();
		}
	}

	public void Remove(ActionEvent event) {
		try {
			product = (Product) event.getComponent().getAttributes().get("selectedProduct");

			ProductDAO ProductDAO = new ProductDAO();
			ProductDAO.delete(product);

			products = ProductDAO.toList();

			Messages.addGlobalInfo("Product removed");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error to remove");
			erro.printStackTrace();
		}
	}
	
	

}
