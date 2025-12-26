package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictCaseService;

import java.util.List;
import java.util.Optional;

public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository caseRepo;
    private final ConflictFlagRepository flagRepo;

    // ✅ Constructor injection (REQUIRED for tests)
    public ConflictCaseServiceImpl(ConflictCaseRepository caseRepo,
                                   ConflictFlagRepository flagRepo) {
        this.caseRepo = caseRepo;
        this.flagRepo = flagRepo;
    }

    @Override
    public ConflictCase createCase(ConflictCase conflictCase) {
        return caseRepo.save(conflictCase);
    }

    @Override
    public ConflictCase updateCaseStatus(Long caseId, String status) {
        ConflictCase cc = caseRepo.findById(caseId)
                .orElseThrow(() -> new ApiException("case not found"));
        cc.setStatus(status);
        return caseRepo.save(cc);
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return caseRepo.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    @Override
    public Optional<ConflictCase> getCaseById(Long id) {
        return caseRepo.findById(id);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return caseRepo.findAll();
    }
}
