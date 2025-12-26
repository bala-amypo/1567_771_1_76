package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository caseRepo;
    private final ConflictFlagRepository flagRepo;

    public ConflictCaseServiceImpl(
            ConflictCaseRepository caseRepo,
            ConflictFlagRepository flagRepo) {
        this.caseRepo = caseRepo;
        this.flagRepo = flagRepo;
    }

    @Override
    public ConflictCase createCase(ConflictCase cc) {
        if (cc.getStatus() == null) {
            cc.setStatus("OPEN");
        }
        return caseRepo.save(cc);
    }

    @Override
    public ConflictCase updateCaseStatus(Long id, String status) {
        ConflictCase cc = caseRepo.findById(id)
                .orElseThrow(() ->
                        new ApiException("Conflict case not found", HttpStatus.NOT_FOUND));
        cc.setStatus(status);
        return caseRepo.save(cc);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return caseRepo.findAll();
    }

    @Override
    public Optional<ConflictCase> getCaseById(Long id) {
        return caseRepo.findById(id);
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return caseRepo.findByPrimaryPersonIdOrSecondaryPersonId(
                personId, personId);
    }
}
