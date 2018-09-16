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

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@Column(name = "credential_id")
	private long credentialId;
	
	@Column(name="credential_name")
	private String credentialName;
	
	@Column(name="credential_year")
	private Date credentialYear;

	@JsonIgnore
	@JoinColumn(name="course_id")
	@ManyToOne( fetch = FetchType.EAGER)
	private Course course;
	
	@JoinColumn(name="institution_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Institution institution;
	

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(long credentialId) {
		this.credentialId = credentialId;
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


}
