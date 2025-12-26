package com.example.demo.service;

import com.example.demo.model.ConflictCase;
import java.util.List;

public interface ConflictCaseService {
    ConflictCase createConflictCase(ConflictCase conflictCase);
    ConflictCase updateConflictCase(Long id, ConflictCase conflictCase);
    ConflictCase getConflictCaseById(Long id);
    List<ConflictCase> getAllConflictCases();
}
