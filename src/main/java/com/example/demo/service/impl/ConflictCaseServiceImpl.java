package com.example.demo.service.impl;

import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository repository;

    public ConflictCaseServiceImpl(ConflictCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConflictCase createConflictCase(ConflictCase cc) {
        return repository.save(cc);
    }

    @Override
    public ConflictCase getConflictCaseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ConflictCase> getAllConflictCases() {
        return repository.findAll();
    }

    @Override
    public ConflictCase updateConflictCase(Long id, ConflictCase cc) {
        cc.setId(id);
        return repository.save(cc);
    }

    @Override
    public void deleteConflictCase(Long id) {
        repository.deleteById(id);
    }
}
