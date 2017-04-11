package com.LivingWater.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="batchBottles")
public class BatchBottles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="batchID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String batchID;
	
	@Column(name="bottle")
	private Bottle bottle;

	public String getBatchID() {
		return batchID;
	}

	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}

	public Bottle getBottle() {
		return bottle;
	}

	public void setBottle(Bottle bottle) {
		this.bottle = bottle;
	}
}