package com.example.digital.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@SuppressWarnings("serial")
@Entity
@Table(name="contact_address")
public class Contact_Address implements Serializable {

	public Contact_Address() {
		super();
	}

	public Contact_Address(long address_Id, Contact contact, Address_Type address_Type,
			String address_1, String address_2, String address_3, String city, String state, String country,
			long postal_Code) {
		super();
		Address_Id = address_Id;
		this.contact = contact;
		Address_Type = address_Type;
		Address_1 = address_1;
		Address_2 = address_2;
		Address_3 = address_3;
		City = city;
		State = state;
		Country = country;
		Postal_Code = postal_Code;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Address_Id",insertable=false,updatable=false)
	private long Address_Id;
		
	@JoinColumn(name="Contact_Id")
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Contact contact;
	
	@JoinColumn(name="Address_Type")
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Address_Type Address_Type;
	@Column(name="Address_1")
	private String Address_1;
	@Column(name="Address_2")
	private String Address_2;
	@Column(name="Address_3")
	private String Address_3;
	@Column(name="City")
	private String City;
	@Column(name="State")
	private String State;
	@Column(name="Country")	
	private String Country;
	@Column(name="Postal_Code")
	private long Postal_Code;
	public long getAddress_Id() {
		return Address_Id;
	}
	public void setAddress_Id(long address_Id) {
		Address_Id = address_Id;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Address_Type getAddress_Type() {
		return Address_Type;
	}
	public void setAddress_Type(Address_Type address_Type) {
		Address_Type = address_Type;
	}
	public String getAddress_1() {
		return Address_1;
	}
	public void setAddress_1(String address_1) {
		Address_1 = address_1;
	}
	public String getAddress_2() {
		return Address_2;
	}
	public void setAddress_2(String address_2) {
		Address_2 = address_2;
	}
	public String getAddress_3() {
		return Address_3;
	}
	public void setAddress_3(String address_3) {
		Address_3 = address_3;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public long getPostal_Code() {
		return Postal_Code;
	}
	public void setPostal_Code(long postal_Code) {
		Postal_Code = postal_Code;
	}
	@Override
	public String toString() {
		return "Contact_Address [Address_Id=" + Address_Id + ", contact=" + contact + ", Address_Type=" + Address_Type
				+ ", Address_1=" + Address_1 + ", Address_2=" + Address_2 + ", Address_3=" + Address_3 + ", City="
				+ City + ", State=" + State + ", Country=" + Country + ", Postal_Code=" + Postal_Code + "]";
	}
	
		
}
