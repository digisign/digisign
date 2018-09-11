package com.example.digital.repository;

import com.example.digital.entity.LearnerCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerCredentialRepository extends JpaRepository<LearnerCredential,Long> {
}
