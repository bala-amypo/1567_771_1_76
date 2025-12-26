package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;

import java.util.List;

public class ConflictFlagServiceImpl implements ConflictFlagService {

    private final ConflictFlagRepository flagRepo;
    private final ConflictCaseRepository caseRepo;

    // ✅ Constructor injection (REQUIRED by tests)
    public ConflictFlagServiceImpl(ConflictFlagRepository flagRepo,
                                   ConflictCaseRepository caseRepo) {
        this.flagRepo = flagRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public ConflictFlag addFlag(ConflictFlag flag) {
        Long caseId = flag.getCaseId();

        ConflictCase conflictCase = caseRepo.findById(caseId)
                .orElseThrow(() -> new ApiException("case not found"));

        // Escalate risk based on severity
        if ("HIGH".equalsIgnoreCase(flag.getSeverity())) {
            conflictCase.setRiskLevel("HIGH");
        } else if ("MEDIUM".equalsIgnoreCase(flag.getSeverity())
                && !"HIGH".equalsIgnoreCase(conflictCase.getRiskLevel())) {
            conflictCase.setRiskLevel("MEDIUM");
        }

        caseRepo.save(conflictCase);
        return flagRepo.save(flag);
    }

    @Override
    public List<ConflictFlag> getFlagsByCase(Long caseId) {
        return flagRepo.findByCaseId(caseId);
    }

    @Override
    public ConflictFlag getFlagById(Long id) {
        return flagRepo.findById(id)
                .orElseThrow(() -> new ApiException("flag not found"));
    }

    @Override
    public List<ConflictFlag> getAllFlags() {
        return flagRepo.findAll();
    }
}
