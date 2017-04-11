package com.LivingWater.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="userID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userID;

	@Column(name="name")
	private String name;

	@ManyToOne
	@Column(name="role")
	private Role role;

	public User() {
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userid) {
		this.userID = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}