package com.example.demo.repository;

import com.example.demo.model.ConflictFlag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConflictFlagRepository
        extends JpaRepository<ConflictFlag, Long> {
}
