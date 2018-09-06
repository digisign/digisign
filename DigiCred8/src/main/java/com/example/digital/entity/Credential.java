package com.example.digital.entity;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="credential")
public class Credential implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2119733742999745166L;

	public Credential() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Credential_Id")
	private long credential_Id;
	
	@Column(name="Credential_Name")
	private String credentialName;
	
	@Column(name="Credential_Year")
	private Date credentialYear;
	
	@JoinColumn(name="Course_Id")
	@ManyToOne( fetch = FetchType.EAGER)
	private Course course;
	
	@JoinColumn(name="Institution_Id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Institution institution;
	
	@Column(name="Issued_Date")
	 @Temporal(TemporalType.DATE)
	private Date issuedDate;
	
	public long getCredential_Id() {
		return credential_Id;
	}
	public void setCredential_Id(long credential_Id) {
		this.credential_Id = credential_Id;
	}
	public String getCredentialName() {
		return credentialName;
	}
	public void setCredentialName(String credentialName) {
		this.credentialName = credentialName;
	}
	public Date getCredentialYear() {
		return credentialYear;
	}
	public void setCredentialYear(Date credentialYear) {
		this.credentialYear = credentialYear;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	@Override
	public String toString() {
		return "Credential [Credential_Id=" + credential_Id + ", credentialName=" + credentialName + ", credentialYear="
				+ credentialYear + ", course=" + course.getCourse_Id() + ", institution=" + institution.getInstitution_Id() + ", issuedDate=" + issuedDate
				+ "]";
	}
	
	
}
