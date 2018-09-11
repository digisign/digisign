package com.example.digital.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.digital.entity.*;
import com.example.digital.repository.CourseRepository;
import com.example.digital.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.digital.repository.IInstitutionDao;
import com.example.digital.service.IInstitutionService;
@RestController
@CrossOrigin(origins = {"*"},allowedHeaders={"Content-Type"},allowCredentials="false",maxAge=4800)
public class InstitutionController {

	@Autowired
	private IInstitutionService institutionService;

	@Autowired
	private InstitutionRepository institutionRepository;

	@Autowired
	private CourseRepository courseRepository;

	@RequestMapping(value="/institution",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Institution> getInstitutions() throws Exception {
		return institutionRepository.findAll();
	}


	@RequestMapping(value="/courses",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Course> getCourses() throws Exception {
		return courseRepository.findAll();
	}



/*	@RequestMapping(value="/institution/{id}",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Institution>> getInstitutionsById(@PathVariable("id") Long id) {
    	System.out.println("Fetching institution with id " + id);
    	List<Institution> list = new ArrayList<Institution>();
    	
    	if(id!=null) {
    		Institution institution = institutionService.getInstitutionById(id);
    	
    		list.add(institution);
    	}else {
    		list = institutionService.getAllInstitution();
    	}
    	
    	if (list.isEmpty()) {
            System.out.println("Learner with id " + id + " not found");
            return new ResponseEntity<List<Institution>>(HttpStatus.NOT_FOUND);
        }
    	
      return new ResponseEntity<List<Institution>>(list, HttpStatus.OK);
      
    } 
	
	@RequestMapping(value="/course/{id}",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> getCourseById(@PathVariable("id") Long id) {
    	System.out.println("Fetching learner with id " + id);
    	List<Course> list = new ArrayList<Course>();
    	
    	if(id!=null) {
    		Course course = institutionService.getCourseByCourseId(id);
    	
    		list.add(course);
    	}else {
    		list = institutionService.getAllCourse();
    	}
    	
    	if (list.isEmpty()) {
            System.out.println("Course with id " + id + " not found");
            return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);
        }
    	
      return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
      
    } 
	
	@RequestMapping(value="/credential/{id}",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Credential>> getCredentialsById(@PathVariable("id") Long id) {
    	System.out.println("Fetching Credential with id " + id);
    	List<Credential> list = new ArrayList<Credential>();
    	
    	if(id!=null) {
    		Credential credential = institutionService.getCredentialById(id);
    	
    		list.add(credential);
    	}else {
    		list = institutionService.getAllCredential();
    	}
    	
    	if (list.isEmpty()) {
            System.out.println("Credential with id " + id + " not found");
            return new ResponseEntity<List<Credential>>(HttpStatus.NOT_FOUND);
        }
    	
      return new ResponseEntity<List<Credential>>(list, HttpStatus.OK);
      
    } 
	
	@RequestMapping(value="/addinstitution",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveInstitution(@RequestBody Institution institution, UriComponentsBuilder builder) {
		List<Institution> list = new ArrayList<Institution>();
		list.add(institution);
		
		boolean flag = institutionService.addInstitution(institution);
		if (flag == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/institution?id={id}").buildAndExpand(institution.getInstitution_Id(),institution.getInstitution_Name(),institution.getContact().getContact_Id(),institution.getParent_Institution_Id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/addcourse",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveCourse(@RequestBody Course course, UriComponentsBuilder builder) {
		List<Course> list = new ArrayList<Course>();
		list.add(course);
		
		boolean flag = institutionService.addCourse(course);
		if (flag == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/course?id={id}").buildAndExpand(course.getCourse_Id(),course.getCourse_Name(),course.getShort_Name(),
				course.getDescription(),course.getInstitution().getInstitution_Id(),course.getCourse_Period()).toUri());

	        
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value="/addcredential",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveCredential(@RequestBody Credential credential, UriComponentsBuilder builder) {
		List<Credential> list = new ArrayList<Credential>();
		list.add(credential);
		
		boolean flag = institutionService.addCredential(credential);
		if (flag == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/credential?id={id}").buildAndExpand(credential.getCredential_Id(),credential.getCredentialName(),
				credential.getCredentialYear(),credential.getInstitution().getInstitution_Id(),credential.getCourse().getCourse_Id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	@RequestMapping(value="/editInstitution/{id}",method = RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateInstitution(@RequestBody Institution institution, @PathVariable long id) {

		Institution institutions = institutionService.getInstitutionById(id);

		if (!institutions.isPresent())
			return ResponseEntity.notFound().build();

		institution.setInstitution_Id(id);
		
		iInstitutionDao.addInstitution(institutions);

		return ResponseEntity.noContent().build();
	}*/
	
	
}


