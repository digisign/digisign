package com.example.digital.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.digital.service.DBInsertJob;

@RestController
public class DbInsertionController {
	
	private static final Logger logger = LoggerFactory.getLogger(DbInsertionController.class);
	
	 @Autowired
	 private DBInsertJob dbinsert;
	
	 @RequestMapping(value="/insertinst",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(value = HttpStatus.OK)
	 public void saveInst() throws IOException {
		 dbinsert.insertInstitutionsData();
	 }
	 
	 @RequestMapping(value="/insertcourse",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(value = HttpStatus.OK)
	 public void saveCourse() throws IOException {
		 dbinsert.insertCoursesData();
	 }

}
