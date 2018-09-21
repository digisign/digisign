package com.example.digital.controller;


import com.example.digital.entity.*;
import com.example.digital.repository.GradeRepository;
import com.example.digital.repository.MarksTypeRepository;
import com.example.digital.repository.RoleRepository;
import com.example.digital.repository.StatusRepository;
import com.example.digital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class LoginController {


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;


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
