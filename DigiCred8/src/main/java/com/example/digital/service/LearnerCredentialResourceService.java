package com.example.digital.service;

import com.example.digital.entity.LearnerCredentialResource;
import com.example.digital.entity.LearnerCredentialResourceRequest;
import com.example.digital.entity.LearnerCredentialResourceResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface LearnerCredentialResourceService {

    LearnerCredentialResourceResponse save(LearnerCredentialResourceRequest learnerCredentialResourceRequest) throws Exception;
    Map<String,Object> getLeranerCredentialResourceByUserId(Long userId, PageRequest pageRequest);
    List<LearnerCredentialResourceResponse> save(MultipartFile[] multipartFiles,Long userId) throws Exception;
}
