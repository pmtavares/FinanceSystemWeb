package com.finance.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Client extends GenericDomain {
	
	@Column(nullable=false)
	//@Temporal(TemporalType.DATE)
	private Date dateRegister;

	@Column(nullable=false)
	private Boolean active;
	
	@OneToOne
	@JoinColumn(nullable=false)
	private Person person;
	
	
	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
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
