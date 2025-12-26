package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictCaseService;

import java.util.List;
import java.util.Optional;

public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository repository;

    public ConflictCaseServiceImpl(ConflictCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConflictCase createCase(ConflictCase conflictCase) {
        if (conflictCase.getStatus() == null)
            conflictCase.setStatus("OPEN");

        return repository.save(conflictCase);
    }

    @Override
    public ConflictCase updateCaseStatus(Long id, String status) {
        ConflictCase conflictCase = repository.findById(id)
                .orElseThrow(() -> new ApiException("case not found"));

        conflictCase.setStatus(status);
        return repository.save(conflictCase);
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return repository
                .findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    @Override
    public Optional<ConflictCase> getCaseById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return repository.findAll();
    }
}
