package com.example.digital.repository;

import com.example.digital.entity.LearnerCredential;
import com.example.digital.entity.LearnerCredentialResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearnerCredentialResourceRepository extends JpaRepository<LearnerCredentialResource,Long> {

    List<LearnerCredentialResource> findByLearnerCredentialIn(List<LearnerCredential> learnerCredentials);

}
