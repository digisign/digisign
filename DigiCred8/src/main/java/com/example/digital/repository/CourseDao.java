package com.example.digital.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital.entity.Course;
import com.example.digital.entity.Institution;


@Transactional
@Repository
public class CourseDao implements ICourseDao {

	/*@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Course getCourseByid(long course_Id) {
		return entityManager.find(Course.class, course_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCourses() {
		String hql = "FROM Course as ce ORDER BY ce.course_Id DESC";
		return (List<Course>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addCourse(Course course) {
		entityManager.persist(course);
	}
	*//*@Override
	public void updateCourse(Course course) {
		Course ce = getCourseByid(course.getCourse_Id());
		ce.setCourse_Name(course.getCourse_Name());
		ce.setShort_Name(course.getShort_Name());
		ce.setDescription(course.getDescription());
		ce.setCourse_Period(course.getCourse_Period());
		entityManager.flush();
	}*//*
	
	@Override
	public void updateCourse(Course course) {
		
		if(course!=null) {
		String hql="update Course co set co.Course_Name="+course.getCourse_Name()+"co.Short_Name"+course.getShort_Name()+
				"co.Description"+course.getDescription()+"co.Course_Period"+course.getCourse_Period()+
				"where co.Course_Id="+course.getCourse_Id();
		
		System.out.println("HQL->"+hql);
		entityManager.createQuery(hql).executeUpdate();
		}
		else {
			entityManager.remove(course);
		}
		//entityManager.remove(getCourseByid(course_Id));
	}
	@Override
	public boolean CourseExists(long course_Id,String course_Name, String short_Name,String description,long institution_Id,String course_Period) {
		String hql = "FROM Course as ce inner join ce.institution as ins WHERE ce.course_Id=? and ce.course_Name = ? and ce.short_Name = ? and ce.description = ? and ins.Institution_Id=? and ce.course_Period = ?";
		int count = entityManager.createQuery(hql).setParameter(1, course_Id).setParameter(2, course_Name)
		              .setParameter(3, short_Name).setParameter(4, description).setParameter(5, institution_Id).setParameter(6, course_Period).getResultList().size();
		return count > 0 ? true : false;
	}
	
*/
}
	