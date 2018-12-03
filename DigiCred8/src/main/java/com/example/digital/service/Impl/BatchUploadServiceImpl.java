package com.example.digital.service.Impl;


import com.example.digital.common.ErrorMessages;
import com.example.digital.common.ExcelColumns;
import com.example.digital.entity.*;
import com.example.digital.exception.DigiSignException;
import com.example.digital.repository.*;
import com.example.digital.service.BatchUploadService;
import com.example.digital.util.DateUtils;
import com.example.digital.util.FileToObjectConverter;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BatchUploadServiceImpl implements BatchUploadService {

    @Autowired
    private FileToObjectConverter fileToObjectConverter;

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private ErrorRecordRepository errorRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    private LearnerRepository learnerRepository;

    @Transactional
    public Batch saveBatches(MultipartFile file, String batchName, String startDate, String endDate, String courseName, String description) throws Exception {

        Map<String, Object> map = fileToObjectConverter.fileToJava(file.getInputStream(), FilenameUtils.getExtension(file.getOriginalFilename()));
        List<String> headers = fileToObjectConverter.getFileHeaders(file.getInputStream(), FilenameUtils.getExtension(file.getOriginalFilename()));
        ExcelColumns[] columns = ExcelColumns.values();

        Batch batch=new Batch();
        batch.setStartDate(DateUtils.parseToDate(startDate));
        if(endDate!=null) {
            batch.setEndDate(DateUtils.parseToDate(endDate));
        }
        batch.setDescription(description);
        batch.setName(batchName);
        Course course=getCourse(courseName);
        batch.setCourse(course);
        for (ExcelColumns column : columns) {
            if (!headers.contains(column.getColName())) {
                throw new DigiSignException(ErrorMessages.COLUMNS_MISSING.getReasonPhrase(), ErrorMessages.COLUMNS_MISSING.getCode());
            }
        }
     /*   List<Batch> batches = new ArrayList((Collection) map.get("batches"));
        Map<String, Batch> batchMap = new HashMap();
        for (Batch batch : batches) {
            String key = batch.getName().trim().toLowerCase().replaceAll("[-_ ]+", "");
            if (!batchMap.containsKey(key)) {
                batchMap.put(key, batch);
            } else {
                batchMap.get(key).getLearners().addAll(batch.getLearners());
            }
        }*/

        List<Learner>  learners= new ArrayList<>((Collection) map.get("learners"));
        learners = validateUsers(learners);
        batch.setLearners(new HashSet<>(learners));
        errorRecordRepository.saveAll((Collection) map.get("errorRecords"));
        return batchRepository.save(batch);
    }

    private Course getCourse(String courseName) {
         Optional<Course> courseOptional=courseRepository.findByCourseName(courseName);
         if(courseOptional.isPresent()){
             return courseOptional.get();
         }else{
             Course course=new Course();
             course.setCourseName(courseName);
             return courseRepository.save(course);
        }
    }

    public List<Batch> getAllBatches()  {
      return batchRepository.findAll();
    }


    public Batch getBatch(Long batchId){
        Optional<Batch> optionalBatch= batchRepository.findById(batchId);
        if(optionalBatch.isPresent()){
            return optionalBatch.get();
        }else{
            throw new DigiSignException(ErrorMessages.BATCH_NOT_AVAILABLE.getReasonPhrase(),ErrorMessages.BATCH_NOT_AVAILABLE.getCode());
        }
    }

    public List<Learner> validateUsers(List<Learner> learners){

        List<ErrorRecord> errorRecords=new ArrayList();

        for(Learner learner:learners){
            User user=learner.getUser();
            if(((user.getLinkedinUrl()==null && user.getEmail()==null)|| !isPatternMatching(user.getLinkedinUrl()))){
                ErrorRecord record=new ErrorRecord();
                record.setEmail(user.getEmail());
                record.setPhoneNumber(user.getPhoneNumber());
                record.setLinkedInUrl(user.getLinkedinUrl());
                if(learner.getUser()!=null){
                    record.setFirstName(learner.getUser().getFirstName());
                    record.setLastName(learner.getUser().getLastName());
                }
                errorRecords.add(record);
            }
        }
        errorRecordRepository.saveAll(errorRecords);
        learners=learners.stream().filter(learner -> !(learner.getUser().getLinkedinUrl()==null && learner.getUser().getEmail()==null)).collect(Collectors.toList());
        List<String> emails=learners.stream().map(learner -> learner.getUser().getEmail()).filter(s ->s!=null && !s.isEmpty()).collect(Collectors.toList());
        List<String> linkedinUrls=learners.stream().map(learner -> learner.getUser().getLinkedinUrl()).filter(s ->s!=null && !s.isEmpty()).collect(Collectors.toList());
        Map<String,Learner> emailMap=new HashMap();
        Map<String,Learner> linkedInMap=new HashMap();
        List<User> existingEmailUsers=getUsersByEmails(emails);
        List<User> existingLinkedinUsers=getUsersByLinkedInUrls(linkedinUrls);
        List<Learner> existingEmailLearners=getLearnersByUsers(existingEmailUsers);
        List<Learner> existingLinkedinLearners=getLearnersByUsers(existingLinkedinUsers);
        if(!CollectionUtils.isEmpty(existingEmailLearners)) {
            existingEmailLearners.forEach(learner ->emailMap.put(learner.getUser().getEmail(),learner));
        }
        if(!CollectionUtils.isEmpty(existingLinkedinLearners)) {
            existingLinkedinLearners.forEach(learner ->linkedInMap.put(learner.getUser().getLinkedinUrl(),learner));
        }

        List<Learner> learners2=new ArrayList();
         for(Learner learner:learners){
            if(emailMap.containsKey(learner.getUser().getEmail())){
                learners2.add(emailMap.get(learner.getUser().getEmail()));
            }else if(linkedInMap.containsKey(learner.getUser().getLinkedinUrl())) {
                learners2.add(linkedInMap.get(learner.getUser().getLinkedinUrl()));
            }else{
                learners2.add(learner);
            }
         }
         return learners2;
    }

    private boolean isPatternMatching(String linkedinUrl) {
        if(linkedinUrl==null){
            return true;
        }
        Pattern p = Pattern.compile("^https:\\/\\/[a-z]{2,3}\\.linkedin\\.com\\/.*$");
        Matcher m = p.matcher(linkedinUrl);
        return m.find();
    }

    List<User> getUsersByEmails(List<String> email){
        return userRepository.findByEmailIn(email);
    }

    List<User> getUsersByLinkedInUrls(List<String> linkedInUrls){
        return userRepository.findByLinkedinUrlIn(linkedInUrls);
    }

    List<Learner> getLearnersByUsers(List<User> user){
        return learnerRepository.findByUserIn(user);
    }

}
