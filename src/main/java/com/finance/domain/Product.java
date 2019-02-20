package com.finance.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product extends GenericDomain{
	
	@Column(length = 80, nullable=false)
	private String description;
	
	@Column(nullable=false)
	private Short quantity;
	
	@Column(precision = 6, scale=2, nullable=false)
	private BigDecimal value;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Supplier supplier;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getQuantity() {
		return quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
	

}
