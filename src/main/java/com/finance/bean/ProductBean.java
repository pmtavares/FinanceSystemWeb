package com.finance.bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.finance.dao.ProductDAO;
import com.finance.dao.SupplierDAO;
import com.finance.domain.Product;
import com.finance.domain.Supplier;

@ManagedBean()
@ViewScoped
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
			product.setPath("C:/Users/User/Documents/eclipse-workspace/"
					+ "finance/src/main/webapp/resources/uploads/" + product.getCode() + ".jpg");
			
			SupplierDAO SupplierDAO = new SupplierDAO();
			supplier = SupplierDAO.toList();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("There was an error to edit");
			erro.printStackTrace();
		}	
	}
	
	public void Save() {
		try {
			ProductDAO productDAO = new ProductDAO();
			Product productResult = productDAO.Merge(product);
			
			if(product.getPath() != null)
			{
				Path path = Paths.get(product.getPath());
				Path pathDestiny = Paths.get("C:/Users/User/Documents/eclipse-workspace/"
						+ "finance/src/main/webapp/resources/uploads/" + productResult.getCode() + ".jpg");
				Files.copy(path, pathDestiny, StandardCopyOption.REPLACE_EXISTING);
			}			
			
			product = new Product();

			SupplierDAO SupplierDAO = new SupplierDAO();
			supplier = SupplierDAO.toList();

			products = productDAO.toList();

			Messages.addGlobalInfo("Product Saved");
		} catch (RuntimeException | IOException erro) {
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
			
			//Remove picture from folder
			Path pathPhoto = Paths.get("C:/Users/User/Documents/eclipse-workspace/"
					+ "finance/src/main/webapp/resources/uploads/" + product.getCode() + ".jpg");			
			Files.deleteIfExists(pathPhoto);
			

			Messages.addGlobalInfo("Product removed");
		} catch (RuntimeException | IOException erro) {
			Messages.addFlashGlobalError("There was an error to remove");
			erro.printStackTrace();
		}
	}
	
	//Test
	public void handleFileUpload(FileUploadEvent event)
	{
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void upload(FileUploadEvent event)
	{
		UploadedFile fileUpload = event.getFile();
		try {
			Path fileTemp =  Files.createTempFile(null, null);
			Files.copy(fileUpload.getInputstream(), fileTemp, StandardCopyOption.REPLACE_EXISTING);
			product.setPath(fileTemp.toString());
			Messages.addGlobalInfo("Image Saved");
			System.out.println(product.getPath());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

}
