package com.finance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Users extends GenericDomain{
	
	@Column(length = 32, nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Character type;
	
	@Column(nullable = false)
	private Boolean active;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Person person;
	
	
	@Transient
	public String getTypeFormatted(){
		String typeFormatted = "";
		
		if(type == 'A'){
			typeFormatted = "Administrator";
			
		} else if(type == 'C'){
			typeFormatted = "Cashier";
			
		}else if(type == 'M'){
			typeFormatted = "Manager";
			
		}
		return typeFormatted;
	}
	
	@Transient
	public String getActiveFormatted(){
		String activeFormatted = "No";
		if(active){
			activeFormatted = "Yes";
		}
		return activeFormatted;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
