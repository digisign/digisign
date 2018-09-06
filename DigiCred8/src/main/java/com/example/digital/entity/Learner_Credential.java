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
public class Learner_Credential implements Serializable {

	public Learner_Credential() {
		super();
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Learner_Credential_Id", nullable = false, updatable = false)
	private long Learner_Credential_Id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Learner_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Learner learner;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Credential_Id")
	private Credential credential;
	
	@OneToOne(targetEntity = Grade.class, fetch = FetchType.EAGER)
	private Grade grade;
	
	@Column(name="Marks")
	private String Marks;
	
	@Column(name="Issued_date")
	private Date Issued_date;
	
	@JoinColumn(name="Course_Id")
	@OneToOne(targetEntity = Course.class, fetch = FetchType.EAGER)
	private Course course;
	
	public long getLearner_Credential_Id() {
		return Learner_Credential_Id;
	}

	public void setLearner_Credential_Id(long learner_Credential_Id) {
		Learner_Credential_Id = learner_Credential_Id;
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

	public String getMarks() {
		return Marks;
	}

	public void setMarks(String marks) {
		Marks = marks;
	}

	public Date getIssued_date() {
		return Issued_date;
	}

	public void setIssued_date(Date issued_date) {
		Issued_date = issued_date;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Learner_Credential [Learner_Credential_Id=" + Learner_Credential_Id + ", learner=" + learner.getLearnerId()
				+ ", credential=" + credential.getCredential_Id() + ", grade=" + grade.getGrade_Id() + ", Marks=" + Marks + ", Issued_date="
				+ Issued_date + ", course=" + course.getCourse_Id() + "]";
	}

	
}
