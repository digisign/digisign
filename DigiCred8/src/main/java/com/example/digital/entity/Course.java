package com.example.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	private static final long serialVersionUID = -3570925632613428400L;

	public Course() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="course_id")
	private Long courseId;
	@Column(name="course_name")
	private String courseName;
	@Column(name="short_name")
	private String shortName;
	@Column(name="description")
	private String description;

	@JsonIgnore
	@JoinColumn(name="institution_id")
	@ManyToOne(targetEntity = Institution.class,fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Institution institution;
	
	@ManyToMany(targetEntity = Grade.class, cascade = CascadeType.ALL )
	@JoinTable(name = "course_grade", joinColumns=@JoinColumn(name = "course_id"),
				inverseJoinColumns = @JoinColumn(name = "grade_id"))
	private Set<Grade> grades;
	
	@Column(name="course_period")
	private String coursePeriod;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	public String getCoursePeriod() {
		return coursePeriod;
	}

	public void setCoursePeriod(String coursePeriod) {
		this.coursePeriod = coursePeriod;
	}
}
