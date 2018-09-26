package com.example.digital.service.Impl;

import com.example.digital.entity.*;
import com.example.digital.repository.CourseRepository;
import com.example.digital.repository.ErrorRepository;
import com.example.digital.repository.InstitutionRepository;
import com.example.digital.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.*;


@Service
public class TransactionServiceImpl implements TransactionService {


    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private ErrorRepository errorRepository;


    @Transactional
    public void saveCourses(Map<CourseConverter, List<CourseConverter>> courseConverterListMap) {
        //TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();

        TransactionSynchronizationManager.isActualTransactionActive();
        for (Map.Entry<CourseConverter, List<CourseConverter>> entry : courseConverterListMap.entrySet()) {
            CourseConverter courseConverter = entry.getKey();
            Course course = new Course();
            Institution institution=getInstituion(courseConverter);
            if(institution==null){
                continue;
            }else{
                course.setInstitution(institution);
                course.setCoursePeriod(courseConverter.getCourseDuration());
                course.setCourseName(courseConverter.getCourse());
            }
            List<CourseConverter> converterList = entry.getValue();
            Set<Subject> subjects = new HashSet<>();
            for (CourseConverter courseConverter1 : converterList) {
                Subject subject = new Subject();
                subject.setSubjectName(courseConverter1.getSubjectName());
                subjects.add(subject);
                subject.setCourse(course);
            }
            course.setSubjects(subjects);

            try {
                courseRepository.save(course);
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorTable error = new ErrorTable();
                error.setErrorMessage(ex.getMessage());
                error.setStackTrace(org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(ex));
                error.setInstituteName(courseConverter.getInstitute());
                error.setJobType("courses");
                errorRepository.save(error);
            }
        }


    }


    Institution getInstituion(CourseConverter courseConverter) {
        if (courseConverter.getInstitute() != null) {
            try {
                Optional<Institution> institution = institutionRepository.findByInstitutionNameIgnoreCase(courseConverter.getInstitute());
                return institution.get();
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}
