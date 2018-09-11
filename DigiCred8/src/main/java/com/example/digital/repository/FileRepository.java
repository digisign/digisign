package com.example.digital.repository;

import com.example.digital.entity.LearnerCredentialResource;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface FileRepository extends JpaRepository<LearnerCredentialResource, Long>{

	//public Learner_Credential_Resourse findByfileName(String filename);
}
