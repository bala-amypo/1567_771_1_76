package com.example.demo.service;

import com.example.demo.model.ConflictCase;
import java.util.List;

public interface ConflictCaseService {
    List<ConflictCase> getAllConflictCases();
    ConflictCase createConflictCase(ConflictCase cc);
    ConflictCase updateConflictCase(Long id, ConflictCase cc);
    void deleteConflictCase(Long id);
}
