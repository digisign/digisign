package com.example.digital.repository;

import com.example.digital.entity.Learner;
import com.example.digital.entity.LearnerCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearnerCredentialRepository extends JpaRepository<LearnerCredential,Long> {

    List<LearnerCredential> findByLearner(Learner learner);
}
