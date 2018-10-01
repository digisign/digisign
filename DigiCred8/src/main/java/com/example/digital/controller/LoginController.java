package com.example.digital.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.digital.entity.Grade;
import com.example.digital.entity.MarksType;
import com.example.digital.entity.Role;
import com.example.digital.entity.Status;
import com.example.digital.entity.User;
import com.example.digital.repository.GradeRepository;
import com.example.digital.repository.MarksTypeRepository;
import com.example.digital.repository.RoleRepository;
import com.example.digital.repository.StatusRepository;
import com.example.digital.service.UserService;

@RestController
@RequestMapping("/")
public class LoginController {


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;
    
    @Autowired
    private MessageSource messages;


    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private MarksTypeRepository marksTypeRepository;


    @RequestMapping(value="/roles",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user, HttpServletRequest request) {
        userService.validateUser(user);
        return new ResponseEntity<String>("Logged in successfully",HttpStatus.OK);
    }


    @RequestMapping(value="/statuses",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Status> getStatuses() {
        return statusRepository.findAll();
    }


    @RequestMapping(value="/grades",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Grade> getGrades() {
        return gradeRepository.findAll();
    }


    @RequestMapping(value="/markTypes",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<MarksType> getMarkTypes() {
        return marksTypeRepository.findAll();
    }
    
   

}
