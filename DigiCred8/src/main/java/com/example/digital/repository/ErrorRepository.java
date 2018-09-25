package com.example.digital.repository;

import com.example.digital.entity.ErrorTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository  extends JpaRepository<ErrorTable,Long> {
}
