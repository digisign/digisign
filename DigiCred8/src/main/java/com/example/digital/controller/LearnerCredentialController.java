package com.example.digital.controller;

import com.example.digital.entity.LearnerCredentialResource;
import com.example.digital.entity.LearnerCredentialResourceRequest;
import com.example.digital.service.LearnerCredentialResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController

public class LearnerCredentialController {

    @Autowired
    private LearnerCredentialResourceService learnerCredentialResourceService;

    @RequestMapping(value="/credentialResource",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public LearnerCredentialResource save(@RequestBody LearnerCredentialResourceRequest learnerCredentialResourceRequest) throws Exception {
        return learnerCredentialResourceService.save(learnerCredentialResourceRequest);
    }

}
