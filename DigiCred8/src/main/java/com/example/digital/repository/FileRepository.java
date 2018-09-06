package com.example.digital.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digital.entity.Learner_Credential_Resourse;

@Transactional
public interface FileRepository extends JpaRepository<Learner_Credential_Resourse, Long>{	

	//public Learner_Credential_Resourse findByfileName(String filename);
}
