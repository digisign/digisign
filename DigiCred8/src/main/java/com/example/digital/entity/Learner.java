package com.example.digital.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
//@XmlRootElement (name = "learner")
public class Learner implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Learner_id", nullable = false, updatable = false)
	private long learnerId;
	//@PrimaryKeyJoinColumn(name = "Learner_id",referencedColumnName="User_Id")
	@OneToOne(/*mappedBy="learner",*/cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	
	// @XmlElement(required = true)
	@JoinColumn(name="Contact_Id")
	@OneToOne(/*targetEntity = Contact.class, fetch = FetchType.EAGER,*/cascade=CascadeType.ALL)
	private Contact contact;
	
	public Learner(long learnerId, User user, Contact contact) {
		super();
		this.learnerId = learnerId;
		this.user = user;
		this.contact = contact;
	}
	
	public Learner() {
		super();
	}

	public long getLearnerId() {
		return learnerId;
	}

	public void setLearnerId(long learnerId) {
		this.learnerId = learnerId;
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

	@Override
	public String toString() {
		return "Learner [learnerId=" + learnerId + ", user=" + user.getUserId() + ", contact=" + contact.getContact_Id() + "]";
	}


	

		
	}
