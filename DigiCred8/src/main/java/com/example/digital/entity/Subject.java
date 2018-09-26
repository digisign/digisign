package com.example.digital.entity;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@Table(name="subject")
public class Subject implements Serializable {

	public Subject() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="subject_id")
	private Long subjectId;
	@Column(name="subject_name")
	private String subjectName;
	@JoinColumn(name="course_id")
	@OneToOne(targetEntity = Course.class, fetch = FetchType.EAGER)
	private Course course;
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
}
