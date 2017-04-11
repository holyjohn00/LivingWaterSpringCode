package com.LivingWater.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="bottle")
public class Bottle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="serialNumber")
	private String serialNumber;

	@Column(name="bottleType")
	private String bottleType;

	@Column(name="status")
	private String status;
	
	@Column(name="dateLastDelivered")
	private Date dateLastDelivered;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBottleType() {
		return bottleType;
	}

	public void setBottleType(String bottleType) {
		this.bottleType = bottleType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateLastDelivered() {
		return dateLastDelivered;
	}

	public void setDateLastDelivered(Date dateLastDelivered) {
		this.dateLastDelivered = dateLastDelivered;
	}
	
	
}