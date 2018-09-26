package com.example.digital.repository;

import com.example.digital.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {

    Optional<Institution> findByInstitutionNameIgnoreCase(String instituteName);
}
