package com.example.digital.entity;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")

//@Entity
//@Table(name = "user_role")
@Embeddable
public class UserRole implements Serializable {

	public UserRole() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	private long User_Id;
	private int Role_Id;
	public long getUser_Id() {
		return User_Id;
	}
	public int getRole_Id() {
		return Role_Id;
	}
	
	@Override
	public String toString() {
		return "User_Role [ User_Id"+ User_Id + "Role_Id"+ Role_Id + "]";
	}
	 
}
