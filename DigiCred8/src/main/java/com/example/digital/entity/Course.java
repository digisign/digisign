package com.example.digital.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3570925632613428400L;

	public Course() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Course_Id")
	private long course_Id;
	@Column(name="Course_Name")
	private String course_Name;
	@Column(name="Short_Name")
	private String short_Name;
	@Column(name="Description")
	private String description;
	
	@JoinColumn(name="Institution_Id")
	@ManyToOne(targetEntity = Institution.class,fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Institution institution;
	
	@OneToMany(targetEntity = Grade.class, cascade = CascadeType.ALL ) 
	@JoinTable(name = "course_grade", joinColumns=@JoinColumn(name = "Course_Id"),
				inverseJoinColumns = @JoinColumn(name = "Grade_Id"))
	private Set<Grade> grades;
	
	@Column(name="Course_Period")
	private String course_Period;
	
	public Course(long course_Id, String course_Name, String short_Name, String description, Institution institution,
			Set<Grade> grades, String course_Period) {
		super();
		this.course_Id = course_Id;
		this.course_Name = course_Name;
		this.short_Name = short_Name;
		this.description = description;
		this.institution = institution;
		this.grades = grades;
		this.course_Period = course_Period;
	}
	
		public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	public long getCourse_Id() {
		return course_Id;
	}
	public void setCourse_Id(long course_Id) {
		this.course_Id = course_Id;
	}
	public String getCourse_Name() {
		return course_Name;
	}
	public void setCourse_Name(String course_Name) {
		this.course_Name = course_Name;
	}
	public String getShort_Name() {
		return short_Name;
	}
	public void setShort_Name(String short_Name) {
		this.short_Name = short_Name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Grade> getGrades() {
		return grades;
	}
	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
	public String getCourse_Period() {
		return course_Period;
	}
	public void setCourse_Period(String course_Period) {
		this.course_Period = course_Period;
	}
	@Override
	public String toString() {
		return "Course [course_Id=" + course_Id + ", course_Name=" + course_Name + ", short_Name=" + short_Name
				+ ", description=" + description + ", institution=" + institution.getInstitution_Id() + ", grades=" + grades
				+ ", course_Period=" + course_Period + "]";
	}
	
	
}
