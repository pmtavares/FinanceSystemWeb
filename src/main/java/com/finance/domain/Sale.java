package com.finance.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sale extends GenericDomain {
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeSale;
	
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal totalValue;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Staff staff;

	public Date getTimeSale() {
		return timeSale;
	}

	public void setTimeSale(Date timeSale) {
		this.timeSale = timeSale;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	} 
	
	

}
