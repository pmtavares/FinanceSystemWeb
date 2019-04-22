package com.finance.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import org.primefaces.model.StreamedContent;

@ManagedBean()
@RequestScoped
public class ImageBean {
	
	@ManagedProperty("#{param.path}")
	private String path;
	
	private StreamedContent photo;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public StreamedContent getPhoto() {
		return photo;
	}
	public void setPhoto(StreamedContent photo) {
		this.photo = photo;
	} 
	
	

}
