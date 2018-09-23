package com.example.digital.entity;

import java.io.Serializable;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
public class Subject_Marks implements Serializable {

		public Subject_Marks() {
		super();
	}
	@JoinColumn(name="Learner_Id")
	@ManyToOne(targetEntity = Learner.class, fetch = FetchType.EAGER)
	private Learner learner;
	
	@JoinColumn(name="Subject_Id")
	@ManyToOne(targetEntity = Subject.class, fetch = FetchType.EAGER)
	private Subject subject;
	
	@JoinColumn(name="Course_Id")
	@ManyToOne(targetEntity = Course.class, fetch = FetchType.EAGER)
	private Course course;
	
	@Column(name="Year")
	private Year Year;
	
	@JoinColumn(name="Grade_Id")
	@ManyToMany(targetEntity = Grade.class, fetch = FetchType.EAGER)
	private Grade grade;
	
	@Column(name="Marks")
	private String Marks;
	
	public Year getYear() {
		return Year;
	}
	public void setYear(Year year) {
		Year = year;
	}
	public String getMarks() {
		return Marks;
	}
	public void setMarks(String marks) {
		Marks = marks;
	}
	public Learner getLearner() {
		return learner;
	}
	public void setLearner(Learner learner) {
		this.learner = learner;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}


}
