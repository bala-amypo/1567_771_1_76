package com.example.demo.service.impl;

import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {

    @Autowired
    private ConflictCaseRepository repository;

    @Override
    public ConflictCase createCase(ConflictCase conflictCase) {
        return repository.save(conflictCase);
    }

    @Override
    public ConflictCase updateCaseStatus(Long caseId, String status) {
        ConflictCase cc = repository.findById(caseId)
            .orElseThrow(() -> new RuntimeException("Case not found"));
        cc.setStatus(status);
        return repository.save(cc);
    }

    @Override
    public ConflictCase getCaseById(Long caseId) {
        return repository.findById(caseId)
            .orElseThrow(() -> new RuntimeException("Case not found"));
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return repository.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return repository.findAll();
    }
}
