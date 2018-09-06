package com.example.digital.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@SuppressWarnings("serial")
@Entity
@Table(name="contact")
public class Contact implements Serializable{

	public Contact() {
		super();
		
	}

	

	public Contact(long contact_Id, String fullName, String firstName, String lastName, Date dOB, String mobileNumber1,
			String mobileNumber2, String emailId1, String emailId2/*, Set<Contact_Address> contactAddress*/) {
		super();
		this.contact_Id = contact_Id;
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dOB = dOB;
		this.mobileNumber1 = mobileNumber1;
		this.mobileNumber2 = mobileNumber2;
		this.emailId1 = emailId1;
		this.emailId2 = emailId2;
		//this.contactAddress = contactAddress;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Contact_Id", nullable = false, updatable = false)
	private long contact_Id;
	
	@Column(name="Full_Name")
	private String fullName;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	@Column(name="DOB")
	private Date dOB;
	@Column(name="Mobile_Number_1")
	private String mobileNumber1;
	@Column(name="Mobile_Number_2")
	private String mobileNumber2;
	@Column(name="Email_Id_1")
	private String emailId1;
	@Column(name="Email_Id_2")
	private String emailId2;
	
	
	
	/*@OneToMany(mappedBy="contact",  cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Contact_Address> contactAddress;*/
   
	public long getContact_Id() {
		return contact_Id;
	}
	public void setContact_Id(long contact_Id) {
		this.contact_Id = contact_Id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getdOB() {
		return dOB;
	}
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
	public String getMobileNumber1() {
		return mobileNumber1;
	}
	public void setMobileNumber1(String mobileNumber1) {
		this.mobileNumber1 = mobileNumber1;
	}
	public String getMobileNumber2() {
		return mobileNumber2;
	}
	public void setMobileNumber2(String mobileNumber2) {
		this.mobileNumber2 = mobileNumber2;
	}
	public String getEmailId1() {
		return emailId1;
	}
	public void setEmailId1(String emailId1) {
		this.emailId1 = emailId1;
	}
	public String getEmailId2() {
		return emailId2;
	}
	public void setEmailId2(String emailId2) {
		this.emailId2 = emailId2;
	}
	
	

	/*public Set<Contact_Address> getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(Set<Contact_Address> contactAddress) {
		this.contactAddress = contactAddress;
	}*/

	@Override
	public String toString() {
		return "Contact [contact_Id=" + contact_Id + ", fullName=" + fullName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dOB=" + dOB + ", mobileNumber1=" + mobileNumber1 + ", mobileNumber2="
				+ mobileNumber2 + ", emailId1=" + emailId1 + ", emailId2=" + emailId2 + /*", contactAddress="
				+ contactAddress + */"]";
	}

	
	

	
}
