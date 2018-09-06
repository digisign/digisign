package com.example.digital.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "Address_Type")
public class Address_Type implements Serializable {

	public Address_Type() {
		super();
		
	}

	@Id
	@Column(name="Address_Type",insertable=false,updatable=false)
	private String Address_Type;
	@Column(name="Address_Type_Desc")
	private String Address_Type_Desc;
	
	public String getAddress_Type() {
		return Address_Type;
	}
	public String getAddress_Type_Desc() {
		return Address_Type_Desc;
	}
	/*@ManyToMany(mappedBy = "Address_Type")
    private Set<Contact> contacts = new HashSet<>();*/
	
	
	@Override
	public String toString() {
		return "Address_Type [ Address_Type"+ Address_Type + "Address_Type_Desc"+ Address_Type_Desc + "]";
	}
	

}
