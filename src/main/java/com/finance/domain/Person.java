package com.finance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Person extends GenericDomain{


	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 14, nullable = false)
	private String pps;
	
	
	@Column(length = 100, nullable = false)
	private String street;
	
	@Column(nullable = false)
	private Short number;
	
	@Column(length = 30, nullable = false)
	private String region;
	
	@Column(length = 10, nullable = false)
	private String postcode;
	
	@Column(length = 10, nullable = false)
	private String complement;
	
	
	@Column(length = 13, nullable = false)
	private String phone;

	
	@Column(length = 100, nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(nullable = false)
	private City city;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private State state;
	
	
	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPps() {
		return pps;
	}


	public void setPps(String pps) {
		this.pps = pps;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public Short getNumber() {
		return number;
	}


	public void setNumber(Short number) {
		this.number = number;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
