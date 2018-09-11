package com.example.digital.service.Impl;

import com.example.digital.common.ErrorMessages;
import com.example.digital.entity.*;
import com.example.digital.exception.DigiSignException;
import com.example.digital.repository.*;
import com.example.digital.service.FileUploadService;
import com.example.digital.service.LearnerCredentialResourceService;
import com.example.digital.service.LearnerService;
import com.example.digital.service.UserService;
import com.example.digital.util.FileUploadUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.tools.JavaCompiler;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class LearnerCredentialResourceServiceImpl implements LearnerCredentialResourceService {

    @Autowired
    private UserService userService;

    @Autowired
    private LearnerRepository learnerRepository;

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


   public  LearnerCredentialResource save(LearnerCredentialResourceRequest learnerCredentialResourceRequest) throws Exception {

       LearnerCredentialResource learnerCredentialResource=new LearnerCredentialResource();
       LearnerCredential learnerCredential=new LearnerCredential();
       Credential credential =new Credential();

       Optional<Learner> learner=learnerRepository.findById(learnerCredentialResourceRequest.getLearnerId());
        if(!learner.isPresent()){
            throw new DigiSignException(ErrorMessages.LEARNER_NOT_AVAILABLE.getReasonPhrase(),ErrorMessages.LEARNER_NOT_AVAILABLE.getCode());
        }else{
            learnerCredential.setLearner(learner.get());
        }

       Optional<Course> course=courseRepository.findById(learnerCredentialResourceRequest.getCourseId());
       if(!course.isPresent()){
           throw new DigiSignException(ErrorMessages.COURSE_NOT_AVAILABLE.getReasonPhrase(),ErrorMessages.COURSE_NOT_AVAILABLE.getCode());
       }else{
           learnerCredential.setCourse(course.get());
           credential.setCourse(course.get());
           //credential.setCredentialYear(learnerCredentialResourceRequest.getIssuedYear());
           credential.setCredentialName(learnerCredentialResourceRequest.getDegree());
          //credential=credentialRepository.save(credential);
           learnerCredential.setCredential(credential);
           learnerCredential.setMarks(learnerCredentialResourceRequest.getMarks());
       }

       Optional<Grade> grade=gradeRepository.findById(learnerCredentialResourceRequest.getGradeId());
       if(!grade.isPresent()){
           throw new DigiSignException(ErrorMessages.GRADE_NOT_AVAILABLE.getReasonPhrase(),ErrorMessages.GRADE_NOT_AVAILABLE.getCode());
       }else{
           learnerCredential.setGrade(grade.get());
       }

       learnerCredentialResource.setLearnerCredential(learnerCredential);
       MultipartFile file= learnerCredentialResourceRequest.getFile();
       File uploadedFile=FileUploadUtil.frameFileData(file);
       learnerCredentialResource.setFilePath(fileUploadService.uploadFile(uploadedFile));
       learnerCredentialResource.setFileType(FilenameUtils.getExtension(file.getName()));
       learnerCredentialResource.setThumbNailPath(fileUploadService.getThumbNail(uploadedFile));
       FileUploadUtil.clearTempFiles(new File[]{uploadedFile});
       return learnerCredentialResourceRepository.save(learnerCredentialResource);
   }
}
