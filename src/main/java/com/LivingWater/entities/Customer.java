package com.LivingWater.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customerID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String customerID;

	@Column(name="name")
	private String name;

	@Column(name="address")
	private String address;
	
	@Column(name="contact_number")
	private Integer contactNumber;
	
	@Column(name="pricing")
	private Double pricing;
	
	@Column(name="typeOfCustomer")
	private String typeOfCustomer;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Double getPricing() {
		return pricing;
	}

	public void setPricing(Double pricing) {
		this.pricing = pricing;
	}

	public String getTypeOfCustomer() {
		return typeOfCustomer;
	}

	public void setTypeOfCustomer(String typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}
	
	
	
	
	
}