package com.example.digital.repository;

import com.example.digital.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CredentialRepository extends JpaRepository<Credential,Long> {
}
