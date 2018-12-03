package com.example.digital.repository;

import com.example.digital.entity.ErrorRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRecordRepository extends JpaRepository<ErrorRecord, Long> {
}
