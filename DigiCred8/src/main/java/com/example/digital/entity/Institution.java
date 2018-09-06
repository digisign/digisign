package com.example.digital.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="institution")
public class Institution implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7109682383546677670L;



	public Institution() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Institution_Id")
	private long Institution_Id;
	@JoinColumn(name="Contact_Id")
	@OneToOne(targetEntity = Contact.class, fetch = FetchType.EAGER)
	private Contact contact;
	@Column(name="Parent_Institution_Id")
	private Integer Parent_Institution_Id;
	@Column(name="Institution_Name")
	private String Institution_Name;
	
	
	
	public Institution(long institution_Id, Contact contact, Integer parent_Institution_Id, String institution_Name) {
		super();
		Institution_Id = institution_Id;
		this.contact = contact;
		Parent_Institution_Id = parent_Institution_Id;
		Institution_Name = institution_Name;
	}

	
	
	public String getInstitution_Name() {
		return Institution_Name;
	}

	public void setInstitution_Name(String institution_Name) {
		Institution_Name = institution_Name;
	}

	public long getInstitution_Id() {
		return Institution_Id;
	}
	
	public void setParent_Institution_Id(Integer parent_Institution_Id) {
		Parent_Institution_Id = parent_Institution_Id;
	}
	public void setInstitution_Id(long institution_Id) {
		Institution_Id = institution_Id;
	}
	
	public Integer getParent_Institution_Id() {
		return Parent_Institution_Id;
	}

	public Contact getContact() {
		return contact;
	}
	

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	

	@Override
	public String toString() {
		return "Institution [Institution_Id=" + Institution_Id + ", contact=" + contact.getContact_Id() + ", Parent_Institution_Id="
				+ Parent_Institution_Id + ", Institution_Name=" + Institution_Name + "]";
	}



	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}



	

	
}
