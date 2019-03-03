package com.finance.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.finance.dao.ClientDAO;
import com.finance.dao.ProductDAO;
import com.finance.dao.SaleDAO;
import com.finance.dao.StaffDAO;
import com.finance.domain.Client;
import com.finance.domain.ItemSale;
import com.finance.domain.Product;
import com.finance.domain.Sale;
import com.finance.domain.Staff;


@ManagedBean()
@ViewScoped
public class SalesBean {
	private Sale sale;
	private List<Product> products;	
	private List<ItemSale> itensSale;
	private List<Client> clients;
	private List<Staff> staffs;


	
	
	public Sale getSale() {
		if(sale == null)
		{
			sale = new Sale();
			
		}
		return sale;
	}


	public void setSale(Sale saleRegister) {
		this.sale = saleRegister;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}



	public List<ItemSale> getItensSale() {
		return itensSale;
	}


	public void setItensSale(ArrayList<ItemSale> itensSale) {
		this.itensSale = itensSale;
	}


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


	public List<Staff> getStaffs() {
		return staffs;
	}


	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}


	@PostConstruct
	public void New() {
		try
		{
			sale = new Sale();
			sale.setTotalValue(new BigDecimal("0.00"));
			
			ProductDAO productDAO = new ProductDAO();
			products = productDAO.list("description");
			
			itensSale = new ArrayList<>();
			
		}
		catch(RuntimeException error)
		{
			Messages.addGlobalError("An error ocurred whe  trying to save sale");
			error.printStackTrace();
		}

	}
	
	public void loadRecord() {

		//try {
			//if (code != null) {
				//SupplierDAO sdao = new SupplierDAO();
				//supplier = sdao.searchByCode(code);
			//}			 

		//} catch (RuntimeException e) {
		//	JSFUtil.addErrorMessage(e.getMessage());
		//	e.printStackTrace();
		//}

	}
	
	public void addProduct(ActionEvent event)
	{
		Product product = (Product) event.getComponent().getAttributes().get("selectedProduct");
		
		int found = -1;
		
		for(int position = 0; position <itensSale.size(); position++)
		{
			if(itensSale.get(position).getProduct().equals(product))
			{
				found = position;
			}
		}
		
		if(found < 0)
		{
			ItemSale itemSale = new ItemSale();
			itemSale.setPartialPrice(product.getValue());
			itemSale.setProduct(product);
			itemSale.setQuantity(new Short("1"));
			
			itensSale.add(itemSale);
		}
		else
		{
			ItemSale itemSale = itensSale.get(found);
			itemSale.setQuantity(new Short((itemSale.getQuantity() + 1 + "")));
			itemSale.setPartialPrice(product.getValue().multiply(new BigDecimal(itemSale.getQuantity())));
		}
		
		calculate();
		
		
	}
	
	
	
	public void Remove(ActionEvent event)
	{
		ItemSale itemSale = (ItemSale) event.getComponent().getAttributes().get("selectedItem");

		int found = -1;
		for (int position = 0; position < itensSale.size(); position++) {
			if (itensSale.get(position).getProduct().equals(itemSale.getProduct())) {
				found = position;
			}
		}

		if (found > -1) {
			itensSale.remove(found);
		}

		calculate();

	}
	
	public void calculate()
	{
		sale.setTotalValue(new BigDecimal("0.00"));

		for (int position = 0; position < itensSale.size(); position++) {
			ItemSale itemSale = itensSale.get(position);
			sale.setTotalValue(sale.getTotalValue().add(itemSale.getPartialPrice()));
		}
	}
	
	public void finalize() {
		try {
			sale.setTimeSale(new Date());
			sale.setClient(null);
			sale.setStaff(null);
			
			StaffDAO staffDAO = new StaffDAO();
			staffs = staffDAO.toList();

			ClientDAO clientDAO = new ClientDAO();
			clients = clientDAO.toList();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Error trying to finish the sale");
			erro.printStackTrace();
		}
	}
	
	public void Save() {
		try {
			if(sale.getTotalValue().signum() == 0){
				Messages.addGlobalError("Inform at least one item");
				return;
			}
			
			SaleDAO saleDAO = new SaleDAO();
			saleDAO.Save(sale, itensSale);
			
			sale = new Sale();
			sale.setTotalValue(new BigDecimal("0.00"));

			ProductDAO produtoDAO = new ProductDAO();
			products = produtoDAO.list("description");

			itensSale = new ArrayList<>();
			
			Messages.addGlobalInfo("Sale success");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("An error ocurred trying to save sale");
			erro.printStackTrace();
		}
	}
	
	

}
