package com.example.digital.controller;

import com.example.digital.entity.LearnerCredentialResource;
import com.example.digital.entity.LearnerCredentialResourceRequest;
import com.example.digital.entity.LearnerCredentialResourceResponse;
import com.example.digital.service.LearnerCredentialResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController

public class LearnerCredentialController {

    @Autowired
    private LearnerCredentialResourceService learnerCredentialResourceService;

    @RequestMapping(value="/credentialResource",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public LearnerCredentialResource save(@RequestBody LearnerCredentialResourceRequest learnerCredentialResourceRequest) throws Exception {
        return learnerCredentialResourceService.save(learnerCredentialResourceRequest);
    }


    @RequestMapping(value="users/{userId}/credentialResource",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<LearnerCredentialResourceResponse> save(@PathVariable("userId") Long userId) throws Exception {
        return learnerCredentialResourceService.getLeranerCredentialResourceByUserId(userId);
    }

}
