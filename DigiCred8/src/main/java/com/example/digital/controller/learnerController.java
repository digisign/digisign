package com.example.digital.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.example.digital.entity.Contact;
import com.example.digital.entity.Contact_Address;
import com.example.digital.entity.Learner;
import com.example.digital.entity.Learner_Credential;
import com.example.digital.repository.ILearner_Credential_ResourseDao;
import com.example.digital.service.ILearnerService;


@RestController
@CrossOrigin(origins = {"*"},allowedHeaders={"Content-Type"},allowCredentials="false",maxAge=4800)
@RequestMapping("/user")
public class learnerController {
	
	private static final Logger logger = LoggerFactory.getLogger(learnerController.class);
	
	@Autowired
	private ILearnerService learnerService;
	
	private ILearner_Credential_ResourseDao resouseDao;
	
	
	
	//---------------------------Getting particular learner or all learner data---------------------------
	
	@RequestMapping(value="/learner/{id}",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Learner>> getLearnersById(@PathVariable("id") Long id) {
    	System.out.println("Fetching learner with id " + id);
    	List<Learner> list = new ArrayList<Learner>();
    	
    	if(id!=null) {
    		Learner learner = learnerService.getLearnerById(id);
    	
    		list.add(learner);
    	}else {
    		list = learnerService.getAllLearners();
    	}
    	
    	if (list.isEmpty()) {
            System.out.println("Learner with id " + id + " not found");
            return new ResponseEntity<List<Learner>>(HttpStatus.NOT_FOUND);
        }
    	
      return new ResponseEntity<List<Learner>>(list, HttpStatus.OK);
      
    } 
	
	//---------------------------------Saving Learner Data and fetching particular learner through its learnerId--------------------------------------------
	
	@RequestMapping(value="/addlearner",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveLearner(@RequestBody Learner learner, UriComponentsBuilder builder) {
		
		
		
		List<Learner> list = new ArrayList<Learner>();
		list.add(learner);
		
		boolean flag = learnerService.addLearner(learner);
		if (flag == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/learner?id={id}").buildAndExpand(learner.getLearnerId(),learner.getUser(),learner.getContact()).toUri());

	        
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	
	//-----------------------------------Modifying Learner Details------------------------------------------------
	@RequestMapping(value="/modifylearner",method = RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Learner> modifyLearner(@RequestBody Learner learner, UriComponentsBuilder builder) {
		
		Contact contact=new Contact();
		Contact_Address contact_address=new Contact_Address();
		Learner_Credential learner_credential=new Learner_Credential();
		//Learner_Credential_Resourse learner_credential_resource =new Learner_Credential_Resourse();
		
		learnerService.updateContact(contact);
		learnerService.updateContact_Address(contact_address);
		learnerService.updateLearner_Credential(learner_credential);
		//learnerservice.uploadLearner_Credential_Resource(learner_credential_resource.getResourse_Id());
		
		
	        
		return new ResponseEntity<Learner>(learner, HttpStatus.CREATED);
	}
	
	//-----------------------------------Deleting Learner Details------------------------------------------------
	@RequestMapping(value="/deleteLearner",method = RequestMethod.DELETE)
    public ResponseEntity<Learner> deleteLearners(long Learner_id) {
    	System.out.println("Fetching & Deleting Learner with id " + Learner_id);
    	
    	 Learner learner = learnerService.getLearnerById(Learner_id);
         if (learner == null) {
             System.out.println("Unable to delete. Learner with id " + Learner_id + " not found");
             return new ResponseEntity<Learner>(HttpStatus.NOT_FOUND);
         }
    	//learnerservice.deleteLearner(Learner_id);
    	return new ResponseEntity<Learner>(HttpStatus.NO_CONTENT);
    } 
	
	
}

