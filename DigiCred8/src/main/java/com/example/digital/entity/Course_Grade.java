package com.example.digital.entity;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Target;
@SuppressWarnings("serial")
//@Entity
//@Table(name="course_grade")
@Embeddable
public class Course_Grade implements Serializable {

	public Course_Grade() {
		super();
	}
	
	
	private long Course_Id;
	private int Grade_Id;
	public long getCourse_Id() {
		return Course_Id;
	}
	public int getGrade_Id() {
		return Grade_Id;
	}
	
	@Override
	public String toString() {
		return "Course_Grade [ Course_Id "+Course_Id+ "Grade_Id"+ Grade_Id+ "]";
	}

}
