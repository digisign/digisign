package com.example.digital.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="learner")
public class Learner implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "learner_id", nullable = false, updatable = false)
	private Long learnerId;


	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	@JoinColumn(name="contact_id")
	@OneToOne(/*targetEntity = Contact.class, fetch = FetchType.EAGER,*/cascade=CascadeType.ALL)
	private Contact contact;
	
	@Column(name="aadhar_no")
	private String aadharNo	;

	/*@Column(name="created_date",nullable = false)
	private Date createdDate;

	@Column(name="updated_date",nullable = false)
	private Date updatedDate;*/
	
	public Learner(long learnerId, User user, Contact contact) {
		super();
		this.learnerId = learnerId;
		this.user = user;
		this.contact = contact;
	}
	
	public Learner() {
		super();
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}


	public Long getLearnerId() {
		return learnerId;
	}

	public void setLearnerId(Long learnerId) {
		this.learnerId = learnerId;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	/*public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}*/
}
