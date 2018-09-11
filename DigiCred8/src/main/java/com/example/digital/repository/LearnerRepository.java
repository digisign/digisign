package com.example.digital.repository;

import com.example.digital.entity.Learner;
import com.example.digital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner,Long> {

}
