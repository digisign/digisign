package com.example.digital.repository;

import com.example.digital.entity.LearnerCredential;
import com.example.digital.entity.LearnerCredentialResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LearnerCredentialResourceRepository extends JpaRepository<LearnerCredentialResource,Long> {

   // List<LearnerCredentialResource> findByLearnerCredentialIn(List<LearnerCredential> learnerCredentials);
    Page<LearnerCredentialResource> findByLearnerCredentialIn(List<LearnerCredential> learnerCredentials, Pageable pageRequest);

}
