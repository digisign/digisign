package com.example.digital.repository;


import java.util.List;

import com.example.digital.entity.Course;
import com.example.digital.entity.Institution;


public interface ICourseDao {

	List<Course> getAllCourses();
	Course getCourseByid(long course_Id);
    void addCourse(Course course);
    void updateCourse(Course course);
    //void deleteCourse(Course course);
	
	boolean CourseExists(long course_Id, String course_Name, String short_Name, String description, long institution_Id,
			String course_Period);
	
}
