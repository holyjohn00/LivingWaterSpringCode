package com.LivingWater.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3235403538871466161L;

	@Id
	@Column(name="roleID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String roleID;

	@Column(name="name")
	private String name;

	public Role() {
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}