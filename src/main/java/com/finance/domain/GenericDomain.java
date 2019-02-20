package com.finance.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass //Will not generate table
public class GenericDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	

}
