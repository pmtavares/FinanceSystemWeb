package com.finance.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Staff extends GenericDomain{
	
	@Column(length = 15, nullable = false)
	private String workingDocument;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date adminitionDate;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Person person;

	public String getWorkingDocument() {
		return workingDocument;
	}

	public void setWorkingDocument(String workingDocument) {
		this.workingDocument = workingDocument;
	}

	public Date getAdminitionDate() {
		return adminitionDate;
	}

	public void setAdminitionDate(Date adminitionDate) {
		this.adminitionDate = adminitionDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	

}
