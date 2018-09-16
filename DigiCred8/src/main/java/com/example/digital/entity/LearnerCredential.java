package com.example.digital.entity;

import java.io.Serializable;
import java.sql.*;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="learner_credential")
public class LearnerCredential implements Serializable {

	public LearnerCredential() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "learner_credential_id", nullable = false, updatable = false)
	private Long learnerCredentialId;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="learner_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Learner learner;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="credential_id")
	private Credential credential;

	@OneToOne(targetEntity = Grade.class, cascade = CascadeType.ALL)
	@JoinColumn(name="grade_id")
	private Grade grade;
	
	@Column(name="marks")
	private Float Marks;
	
	@Column(name="issued_date")
	private Date issuedDate;
	
	@JoinColumn(name="course_id")
	@OneToOne(targetEntity = Course.class, fetch = FetchType.EAGER)
	private Course course;


	public Long getLearnerCredentialId() {
		return learnerCredentialId;
	}

	public void setLearnerCredentialId(Long learnerCredentialId) {
		this.learnerCredentialId = learnerCredentialId;
	}

	public Learner getLearner() {
		return learner;
	}

	public void setLearner(Learner learner) {
		this.learner = learner;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Float getMarks() {
		return Marks;
	}

	public void setMarks(Float marks) {
		Marks = marks;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
