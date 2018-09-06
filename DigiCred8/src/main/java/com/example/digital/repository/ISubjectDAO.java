package com.example.digital.repository;

import java.util.List;

import com.example.digital.entity.Subject;

public interface ISubjectDAO {
	List<Subject> getAllSubjects();
	Subject getSubjectByid(long subjectId);
    void updateSubject(Subject subject);
    void deleteSubject(Subject subject);
	void saveSubject(Subject subject);
	boolean subjectExists(long subjectId, String subjectName, long courseId);
}
