package com.example.digital.service;

import com.example.digital.entity.*;
import com.example.digital.repository.CourseRepository;
import com.example.digital.repository.ErrorRepository;
import com.example.digital.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class DBInsertJob {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ErrorRepository errorRepository;

    @Autowired
    private CourseRepository courseRepository;

    //@Scheduled(cron = "0 2 13 * * ?")
    //@Transactional
    public void insertInstitutionsData() throws IOException {
        InputStream is = new ClassPathResource("tempdata.xlsx").getInputStream();
        ExcelReader er = new ExcelReader();
        List<Map<String, Object>> list = er.excelToMap(is);
        List<Institution> institutions = new ArrayList();
        for (Map<String, Object> map : list) {
            Institution institution = new Institution();
            Contact contact = new Contact();
            institution.setInstitutionName((String) map.get("Institution_Name"));
            contact.setMobileNumber1((String) map.get("Mobile_Number_1"));
            contact.setMobileNumber2((String) map.get("Mobile_Number_2"));
            contact.setEmailId1((String) map.get("Email_Id_1"));
            contact.setEmailId2((String) map.get("Email_Id_2"));
            contact.setFullName((String) map.get("Institution_Name"));
            ContactAddress contactAddress = new ContactAddress();
            contactAddress.setAddress1((String) map.get("Address_1"));
            contactAddress.setAddress2((String) map.get("Address_2"));
            contactAddress.setAddress3((String) map.get("Address_3"));
            contactAddress.setCity((String) map.get("City"));
            contactAddress.setState((String) map.get("State"));
            contactAddress.setContact(contact);
            Long code = null;
            try {
                code = Long.valueOf((String) map.get("Postal_Code"));
            } catch (Exception ex) {
            }
            contactAddress.setPostalCode(code);
            contactAddress.setCountry((String) map.get("Country"));
            contact.setContactAddress(Arrays.asList(contactAddress));

            if(contact.getMobileNumber1()==null && contact.getMobileNumber2()==null
                	&& contact.getEmailId1()==null && contact.getEmailId2()==null
                	&& contactAddress.getAddress1()==null){

                continue;
                }


            institution.setContact(contact);
            institutions.add(institution);
            try {
                institutionRepository.save(institution);
            } catch (Exception ex) {
                ErrorTable error = new ErrorTable();
                error.setErrorMessage(ex.getMessage());
                error.setStackTrace(org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(ex));
                error.setInstituteName(institution.getInstitutionName());
                error.setMobileNumber1(contact.getMobileNumber1());
                error.setMobileNumber2(contact.getMobileNumber2());
                error.setEmailId1(contact.getEmailId1());
                error.setEmailId2(contact.getEmailId2());
                error.setJobType("institutions");
                errorRepository.save(error);
            }
        }
    }


    //@Scheduled(cron = "0  46 15 * * ?")
    //@Transactional

       // File file = new File("C:\\Users\\Hp\\Documents\\GitHub\\TestCredential\\data\\Subject.xlsx");
        //InputStream is = new FileInputStream(file);



   
    public void insertCoursesData() throws Exception {


        InputStream is = new ClassPathResource("Subject.xlsx").getInputStream();
        ExcelReader er = new ExcelReader();
        List<Map<String, Object>> list = er.excelToMap(is);
        List<CourseConverter> courseConverters = new ArrayList();
        Map<CourseConverter, List<CourseConverter>> courseConverterListMap = new HashMap();
        for (Map<String, Object> map : list) {
            CourseConverter courseConverter = new CourseConverter();
            courseConverter.setInstitute((String) map.get("Institution_Name"));
            courseConverter.setCourse((String) map.get("CourseName"));
            courseConverter.setCourseDuration((String) map.get("Course_Period"));
            courseConverter.setSubjectName((String) map.get("SubjectName"));
            if (!courseConverterListMap.containsKey(courseConverter)) {
                List<CourseConverter> courseConverters1 = new ArrayList();
                courseConverters1.add(courseConverter);
                courseConverterListMap.put(courseConverter, courseConverters1);
            } else {
                courseConverterListMap.get(courseConverter).add(courseConverter);
            }
        }
        transactionService.saveCourses(courseConverterListMap);
        System.out.println("done with the job");
    }

}
