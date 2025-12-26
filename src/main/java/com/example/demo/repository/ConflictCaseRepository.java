package com.example.demo.repository;

import com.example.demo.model.ConflictCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConflictCaseRepository
        extends JpaRepository<ConflictCase, Long> {
}
