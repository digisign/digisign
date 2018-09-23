package com.example.digital.repository;

import com.example.digital.entity.Learner;
import com.example.digital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LearnerRepository extends JpaRepository<Learner,Long> {
    Optional<Learner> findByUser(User user);
}
