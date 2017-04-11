package com.LivingWater.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="Dispenser")
public class Dispenser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="serialNumber")
	private String serialNumber;
	
	@Column(name="status")
	private String status;

	@OneToOne
	@Column(name="user")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
		
	
	
}