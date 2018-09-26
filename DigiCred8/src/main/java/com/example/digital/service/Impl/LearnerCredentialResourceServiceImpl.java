package com.example.digital.service.Impl;

import com.example.digital.common.ErrorMessages;
import com.example.digital.entity.*;
import com.example.digital.exception.DigiSignException;
import com.example.digital.repository.*;
import com.example.digital.service.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class LearnerCredentialResourceServiceImpl implements LearnerCredentialResourceService {

    @Autowired
    private UserService userService;

    @Autowired
    private LearnerService learnerService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private LearnerCredentialResourceRepository learnerCredentialResourceRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private InstitutionRepository institutionRepository;


    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private LearnerCredentialService learnerCredentialService;


    @Transactional
    public LearnerCredentialResourceResponse save(LearnerCredentialResourceRequest learnerCredentialResourceRequest) throws Exception {


        LearnerCredentialResource learnerCredentialResource=getLeranerCredentialResource(learnerCredentialResourceRequest);

        LearnerCredential learnerCredential = getLearnerCredential(learnerCredentialResource);
        User user=userService.getUserById(learnerCredentialResourceRequest.getUserId());
        learnerCredential.setLearner(learnerService.getLearnerByUser(user));
        Institution institution = getInstitution(learnerCredentialResourceRequest);
        Course course = getCourse(learnerCredentialResourceRequest, institution);
        Grade grade=getGrade(learnerCredentialResourceRequest);
        Set<Grade> grades=new HashSet<>();
        grades.add(grade);
        course.setGrades(grades);
        Credential credential = getCredential(learnerCredential);
        credential.setCourse(course);
        credential.setCredentialName(learnerCredentialResourceRequest.getDegree());
        credential.setInstitution(institution);
        credential.setCredentialYear(learnerCredentialResourceRequest.getIssuedYear());
        learnerCredential.setGrade(grade);
        learnerCredential.setCourse(course);
        learnerCredential.setCredential(credential);
        learnerCredential.setMarks(learnerCredentialResourceRequest.getMarks());
        learnerCredential.setStartYear(learnerCredentialResourceRequest.getStartYear());
        learnerCredential.setEndYear(learnerCredentialResourceRequest.getEndYear());
        learnerCredentialResource.setUpdatedDate(new Date());
        Status status=getStatus(learnerCredentialResourceRequest);
        learnerCredentialResource.setLearnerCredential(learnerCredential);
        if(learnerCredentialResourceRequest.getResourceId()==null) {
            learnerCredentialResource.setFilePath(learnerCredentialResourceRequest.getFilePath());
            learnerCredentialResource.setFileType(FilenameUtils.getExtension(learnerCredentialResourceRequest.getFilePath()));
            learnerCredentialResource.setThumbNailPath(learnerCredentialResourceRequest.getThumbNailPath());
            learnerCredentialResource.setCreatedDate(new Date());
        }
        learnerCredentialResource.setStatus(status);
        return getLearnerCredentialResourceResponse(learnerCredentialResource);
    }


    private Institution getInstitution(LearnerCredentialResourceRequest learnerCredentialResourceRequest) {
        Long instituteId = learnerCredentialResourceRequest.getInstitutionId();
        if (instituteId != null) {
            Optional<Institution> institution = institutionRepository.findById(instituteId);
            if (!institution.isPresent()) {
                throw new DigiSignException(ErrorMessages.INSTITUION_NOT_AVAILABLE.getReasonPhrase(), ErrorMessages.INSTITUION_NOT_AVAILABLE.getCode());
            } else {
                return institution.get();
            }
        } else {
            Institution institution = new Institution();
            institution.setInstitutionName(learnerCredentialResourceRequest.getInstitutionName());
            return institutionRepository.save(institution);
        }

    }



    private Credential getCredential(LearnerCredential learnerCredential){

        if(learnerCredential.getCredential()==null){
            return new Credential();
        }else{
            return learnerCredential.getCredential();
        }

    }


    private LearnerCredentialResource getLeranerCredentialResource(LearnerCredentialResourceRequest learnerCredentialResourceRequest){

        if(learnerCredentialResourceRequest.getResourceId()==null){
            return new LearnerCredentialResource();
        }else{
           Optional<LearnerCredentialResource> resource= learnerCredentialResourceRepository.findById(learnerCredentialResourceRequest.getResourceId());
           if(resource.isPresent()){
               return resource.get();
           }else{
               throw new DigiSignException(ErrorMessages.RESOURCE_NOT_AVAILABLE.getReasonPhrase(), ErrorMessages.RESOURCE_NOT_AVAILABLE.getCode());
           }
        }
    }


    private LearnerCredential getLearnerCredential(LearnerCredentialResource learnerCredentialResource){

        if(learnerCredentialResource.getLearnerCredential()==null){
            return new LearnerCredential();
        }
        else{
            return learnerCredentialResource.getLearnerCredential();
        }
    }



    private Status getStatus(LearnerCredentialResourceRequest learnerCredentialResourceRequest){
       Optional<Status> status= statusRepository.findById(learnerCredentialResourceRequest.getStatusId());
        if(!status.isPresent()){
            throw new DigiSignException(ErrorMessages.STATUS_NOT_AVAILABLE.getReasonPhrase(), ErrorMessages.STATUS_NOT_AVAILABLE.getCode());
        }else{
            return status.get();
        }
    }

    private Course getCourse(LearnerCredentialResourceRequest learnerCredentialResourceRequest, Institution institution) {

        Long courseId = learnerCredentialResourceRequest.getCourseId();
        if (courseId != null) {
            Optional<Course> course = courseRepository.findById(courseId);
            if (!course.isPresent()) {
                throw new DigiSignException(ErrorMessages.COURSE_NOT_AVAILABLE.getReasonPhrase(), ErrorMessages.COURSE_NOT_AVAILABLE.getCode());
            } else {
                return course.get();
            }
        } else {
            Course course = new Course();
            course.setCourseName(learnerCredentialResourceRequest.getCourseName());
            course.setInstitution(institution);
            return courseRepository.save(course);
        }
    }


    private Grade getGrade(LearnerCredentialResourceRequest learnerCredentialResourceRequest) {

        Long gradeId = learnerCredentialResourceRequest.getGradeId();
        if (gradeId != null) {
            Optional<Grade> grade = gradeRepository.findById(learnerCredentialResourceRequest.getGradeId());
            if (!grade.isPresent()) {
                throw new DigiSignException(ErrorMessages.GRADE_NOT_AVAILABLE.getReasonPhrase(), ErrorMessages.GRADE_NOT_AVAILABLE.getCode());
            } else {
                return grade.get();
            }
        } else {
            Grade grade = new Grade();
            grade.setGradeName(learnerCredentialResourceRequest.getGradeName());
            return gradeRepository.save(grade);
        }

    }


    public List<LearnerCredentialResourceResponse> getLeranerCredentialResourceByUserId(Long userId){
        User user=userService.getUserById(userId);
        Learner learner=learnerService.getLearnerByUser(user);
        List<LearnerCredential> learnerCredentials=learnerCredentialService.getLearnerCredentialsByLearner(learner);
        List<LearnerCredentialResource> learnerCredentialResources=learnerCredentialResourceRepository.findByLearnerCredentialIn(learnerCredentials);
        sortLearnerCredentialResources(learnerCredentialResources);
        return  getLearnerCredentialResourceResponses(learnerCredentialResources);

    }



    private List<LearnerCredentialResourceResponse> getLearnerCredentialResourceResponses(List<LearnerCredentialResource> learnerCredentialResources){

        List<LearnerCredentialResourceResponse> learnerCredentialResourceResponses=new ArrayList();

        for(LearnerCredentialResource learnerCredentialResource:learnerCredentialResources){
            learnerCredentialResourceResponses.add(getLearnerCredentialResourceResponse(learnerCredentialResource));
        }
        return learnerCredentialResourceResponses;
    }


    private LearnerCredentialResourceResponse getLearnerCredentialResourceResponse(LearnerCredentialResource learnerCredentialResource){

        LearnerCredentialResourceResponse learnerCredentialResourceResponse=new LearnerCredentialResourceResponse();
        LearnerCredential learnerCredential = learnerCredentialResource.getLearnerCredential();
        learnerCredentialResourceResponse.setLearnerCredentialResource(learnerCredentialResource);
        if(learnerCredential!=null){
            learnerCredentialResourceResponse.setCourse(learnerCredential.getCourse());
            learnerCredentialResourceResponse.setGrade(learnerCredential.getGrade());
            if(learnerCredential.getCredential()!=null) {
                learnerCredentialResourceResponse.setInstitution(learnerCredential.getCredential().getInstitution());
                learnerCredentialResourceResponse.setCredentialName(learnerCredential.getCredential().getCredentialName());
                learnerCredentialResourceResponse.setCredentialYear(learnerCredential.getCredential().getCredentialYear());
            }
            learnerCredentialResourceResponse.setEndYear(learnerCredential.getEndYear());
            learnerCredentialResourceResponse.setStartYear(learnerCredential.getStartYear());
            learnerCredentialResourceResponse.setIssuedDate(learnerCredential.getIssuedDate());
            learnerCredentialResourceResponse.setMarks(learnerCredential.getMarks());
        }


        return learnerCredentialResourceResponse;
    }


    public List<LearnerCredentialResourceResponse> save(MultipartFile[] multipartFiles,Long userId) throws Exception{
        List<FilePath> filePaths =fileUploadService.uploadFiles(multipartFiles);
        Status status=statusRepository.getOne(Long.valueOf(1));
        List<LearnerCredentialResource> learnerCredentialResources=new ArrayList();

        for(FilePath filePath:filePaths){
            LearnerCredentialResource learnerCredentialResource = new LearnerCredentialResource();
            LearnerCredential learnerCredential = getLearnerCredential(learnerCredentialResource);
            User user=userService.getUserById(userId);
            learnerCredential.setLearner(learnerService.getLearnerByUser(user));
            learnerCredentialResource.setFilePath(filePath.getFilePath());
            learnerCredentialResource.setFileType(FilenameUtils.getExtension(filePath.getFilePath()));
            learnerCredentialResource.setThumbNailPath(filePath.getThumbNailPath());
            learnerCredentialResource.setStatus(status);
            learnerCredentialResources.add(learnerCredentialResource);
            learnerCredentialResource.setLearnerCredential(learnerCredential);
            learnerCredentialResource.setCreatedDate(new Date());
            learnerCredentialResource.setUpdatedDate(new Date());
        }
        learnerCredentialResources=learnerCredentialResourceRepository.saveAll(learnerCredentialResources);
        sortLearnerCredentialResources(learnerCredentialResources);
        return  getLearnerCredentialResourceResponses(learnerCredentialResources);
    }



   private  void sortLearnerCredentialResources(List<LearnerCredentialResource> learnerCredentialResources){
       PropertyComparator<LearnerCredentialResource> comparator = new PropertyComparator<>("updatedDate", true, true);
       learnerCredentialResources.sort(comparator);
    }


}