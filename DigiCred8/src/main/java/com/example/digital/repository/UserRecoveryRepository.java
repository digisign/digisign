package com.example.digital.repository;

import com.example.digital.entity.UserRecovery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRecoveryRepository extends JpaRepository<UserRecovery,Long> {
    Optional<UserRecovery> findByToken(String token);
}
