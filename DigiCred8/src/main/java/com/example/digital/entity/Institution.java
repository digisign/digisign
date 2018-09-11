package com.example.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="institution")
public class Institution implements Serializable {

	private static final long serialVersionUID = 7109682383546677670L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="institution_id")
	private Long institutionId;

	@JsonIgnore
	@JoinColumn(name="contact_id")
	@OneToOne(targetEntity = Contact.class, fetch = FetchType.EAGER)
	private Contact contact;
	@Column(name="parent_institution_id")
	private Long parentInstitutionId;
	@Column(name="institution_name")
	private String institutionName;


	@OneToMany(mappedBy = "institution")
	private Set<Course> courses;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Long getParentInstitutionId() {
		return parentInstitutionId;
	}

	public void setParentInstitutionId(Long parentInstitutionId) {
		this.parentInstitutionId = parentInstitutionId;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
