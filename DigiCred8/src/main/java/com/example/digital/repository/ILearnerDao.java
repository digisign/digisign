package com.example.digital.repository;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.digital.entity.Contact;
import com.example.digital.entity.Learner;
import com.example.digital.entity.User;


public interface ILearnerDao {
	@GetMapping
	List<Learner> getAllLearners();
	
	//@GetMapping(value="/{learner_id}")
	Learner getLearnerByid(long learner_id);
	
    void addLearner(Learner learner);
  /*  
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateLearner(@RequestBody Learner learner);
    
    @RequestMapping(value = "/{learner_id}",method = RequestMethod.DELETE)
    void deleteLearner(long learner_id);*/
    
    
	
	boolean learnerExists(long learner_id, User user, Contact contact);

	Learner getContactByid(Contact contact);

	Learner getUserByid(User user);


	
	
	
	
}
