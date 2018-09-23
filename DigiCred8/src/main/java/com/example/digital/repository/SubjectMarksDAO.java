package com.example.digital.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital.entity.Subject;

@Transactional
@Repository
public class SubjectMarksDAO implements ISubjectMarksDAO {

	@Override
	public List<Subject> getAllSubjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject getSubjectByid(long subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubject(Subject subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean subjectExists(String subjectName, long courseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveSubject(Subject subject) {
		// TODO Auto-generated method stub
		
	}


}
