package com.example.digital.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="institution_user")
public class Institution_User implements Serializable {

	public Institution_User() {
		super();
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Institution_User_Id")
	private long institution_User_Id;
	
	@Column(name="Institution_Id")
	private long  institution_Id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	
	@JoinColumn(name="Contact_Id")
	@OneToOne(targetEntity = Contact.class, fetch = FetchType.EAGER)
	private Contact contact;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Institution_User)) return false;
        Institution_User that = (Institution_User) o;
        return Objects.equals(getInstitution_Id(), that.getInstitution_Id()) &&
                Objects.equals(getInstitution_User_Id(), that.getInstitution_User_Id());
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(getInstitution_Id(), getInstitution_User_Id());
    }
	
	public long getInstitution_User_Id() {
		return institution_User_Id;
	}
	public void setInstitution_User_Id(long institution_User_Id) {
		this.institution_User_Id = institution_User_Id;
	}
	public long getInstitution_Id() {
		return institution_Id;
	}
	public void setInstitution_Id(long institution_Id) {
		this.institution_Id = institution_Id;
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
		return "Institution_User [institution_User_Id=" + institution_User_Id + ", institution_Id=" + institution_Id
				+ ", user=" + user.getUserId() + ", contact=" + contact.getContact_Id() + "]";
	}
	
	
		
	
}