package com.example.digital.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="grade")
public class Grade implements Serializable {

	public Grade() {
		super();
	}

	@Id
	@Column(name="Grade_Id",insertable=false,updatable=false)
	private int Grade_Id;
	@Column(name="Grade_Name")
	private String Grade_Name;
	@Column(name="Description")
	private String Description;
	
	@JsonIgnore
	@OneToMany(mappedBy="grades")
	private Set<Course> courses;
	
	
	public int getGrade_Id() {
		return Grade_Id;
	}
	public String getGrade_Name() {
		return Grade_Name;
	}
	public void setGrade_Id(int grade_Id) {
		Grade_Id = grade_Id;
	}
	public void setGrade_Name(String grade_Name) {
		Grade_Name = grade_Name;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDescription() {
		return Description;
	}
	@Override
	public String toString() {
		return "Grade [Grade_Id=" + Grade_Id + ", Grade_Name=" + Grade_Name + ", Description=" + Description + "]";
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
}
