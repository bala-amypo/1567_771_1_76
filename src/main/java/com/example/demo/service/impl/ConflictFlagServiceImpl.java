package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;

import java.util.List;

public class ConflictFlagServiceImpl implements ConflictFlagService {

    private final ConflictFlagRepository repository;
    private final ConflictCaseRepository caseRepository;

    public ConflictFlagServiceImpl(
            ConflictFlagRepository repository,
            ConflictCaseRepository caseRepository) {
        this.repository = repository;
        this.caseRepository = caseRepository;
    }

    @Override
    public ConflictFlag addFlag(ConflictFlag flag) {

        ConflictCase conflictCase = caseRepository.findById(flag.getCaseId())
                .orElseThrow(() -> new ApiException("case not found"));

        if ("HIGH".equalsIgnoreCase(flag.getSeverity()))
            conflictCase.setRiskLevel("HIGH");

        caseRepository.save(conflictCase);
        return repository.save(flag);
    }

    @Override
    public ConflictFlag getFlagById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiException("flag not found"));
    }

    @Override
    public List<ConflictFlag> getFlagsByCase(Long caseId) {
        return repository.findByCaseId(caseId);
    }

    @Override
    public List<ConflictFlag> getAllFlags() {
        return repository.findAll();
    }
}
