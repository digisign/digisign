package com.example.digital.service;

import com.example.digital.entity.LearnerCredentialResource;
import com.example.digital.entity.LearnerCredentialResourceRequest;
import com.example.digital.entity.LearnerCredentialResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LearnerCredentialResourceService {

    LearnerCredentialResourceResponse save(LearnerCredentialResourceRequest learnerCredentialResourceRequest) throws Exception;
    List<LearnerCredentialResourceResponse> getLeranerCredentialResourceByUserId(Long userId);
    List<LearnerCredentialResourceResponse> save(MultipartFile[] multipartFiles,Long userId) throws Exception;
}
