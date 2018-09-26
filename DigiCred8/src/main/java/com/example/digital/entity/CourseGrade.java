package com.example.digital.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Target;
@SuppressWarnings("serial")
//@Entity
//@Table(name="course_grade")
@Embeddable
public class CourseGrade implements Serializable {

	public CourseGrade() {
		super();
	}
	
	@Column(name="course_id")
	private Long courseId;
	@Column(name="grade_id")
	private Long gradeId;

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
}
