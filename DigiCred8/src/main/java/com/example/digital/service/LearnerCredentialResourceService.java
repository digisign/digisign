package com.example.digital.service;

import com.example.digital.entity.LearnerCredentialResource;
import com.example.digital.entity.LearnerCredentialResourceRequest;
import com.example.digital.entity.LearnerCredentialResourceResponse;

import java.util.List;

public interface LearnerCredentialResourceService {

    LearnerCredentialResource save(LearnerCredentialResourceRequest learnerCredentialResourceRequest) throws Exception;
    List<LearnerCredentialResourceResponse> getLeranerCredentialResourceByUserId(Long userId);
}
