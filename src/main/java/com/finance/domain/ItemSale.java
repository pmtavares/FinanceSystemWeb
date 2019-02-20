package com.finance.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemSale extends GenericDomain {
	
	@Column(nullable = false)
	private Short quantity;
	
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal partialPrice;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Sale sale;

	public Short getQuantity() {
		return quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPartialPrice() {
		return partialPrice;
	}

	public void setPartialPrice(BigDecimal partialPrice) {
		this.partialPrice = partialPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	

}
