package com.example.digital.repository;

import java.util.List;

import com.example.digital.entity.Subject;

public interface ISubjectMarksDAO {

	List<Subject> getAllSubjects();
	Subject getSubjectByid(long subjectId);
    void updateSubject(Subject subject);
    void deleteSubject(Subject subject);
    boolean subjectExists(String subjectName, long courseId);
	void saveSubject(Subject subject);
}
