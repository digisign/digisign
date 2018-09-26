package com.example.digital.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital.entity.Subject;
@Transactional
@Repository
public class SubjectDAO implements ISubjectDAO {

	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<Subject> getAllSubjects() {
		// TODO Auto-generated method stub
		String hql = "FROM Subject as sb ORDER BY sb.Subject_Id DESC";
		return (List<Subject>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Subject getSubjectByid(long subjectId) {
		// TODO Auto-generated method stub
		return entityManager.find(Subject.class, subjectId);
	}
	
	@Override
	public void saveSubject(Subject subject) {
		// TODO Auto-generated method stub
		entityManager.persist(subject);
	}
	

	@Override
	public void updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		Subject sb = getSubjectByid(subject.getSubjectId());
		sb.setSubjectName(subject.getSubjectName());
		sb.setCourse(subject.getCourse());
		entityManager.flush();
	}

	@Override
	public void deleteSubject(Subject subject) {
		// TODO Auto-generated method stub
		String hql="update Subject sb set sb.Subject_Name="+subject.getSubjectName()+"sb.Course_Id"+subject.getCourse()+
				
				"where sb.Subject_Id="+subject.getSubjectId();
		
		System.out.println("HQL->"+hql);
		entityManager.createQuery(hql).executeUpdate();
	}

	@Override
	public boolean subjectExists(long subjectId ,String subjectName, long courseId) {
		// TODO Auto-generated method stub
		String hql = "FROM Subject as sb WHERE sb.Subject_Id=? and sb.Subject_Name = ? and sb.Course_Id = ? ";
		
		int count = entityManager.createQuery(hql).setParameter(1, subjectId).setParameter(2, subjectName).setParameter(3, courseId).getResultList().size();
		return count > 0 ? true : false;
	}

	

}
