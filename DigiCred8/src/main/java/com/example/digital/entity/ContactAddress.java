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
public class ContactAddress implements Serializable {

	public ContactAddress() {
		super();
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contact_address_id",insertable=false,updatable=false)
	private Long addressId;


	@JoinColumn(name="contact_id")
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Contact contact;
	
	@JoinColumn(name="address_type")
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private AddressType addressType;
	@Column(name="address_1")
	private String address1;
	@Column(name="address_2")
	private String address2;
	@Column(name="address_3")
	private String address3;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String State;
	@Column(name="country")
	private String Country;
	@Column(name="postal_code")
	private Long postalCode;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

/*	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}*/

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Long getPostalCode() {
		return postalCode;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setPostalCode(Long postalCode) {
		this.postalCode = postalCode;
	}
}
