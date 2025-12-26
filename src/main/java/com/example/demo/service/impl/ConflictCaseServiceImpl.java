package com.example.demo.service.impl;

import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {

    @Autowired
    private ConflictCaseRepository repository;

    @Override
    public List<ConflictCase> getAllConflictCases() {
        return repository.findAll();
    }

    @Override
    public ConflictCase getConflictCaseById(Long id) {
        Optional<ConflictCase> cc = repository.findById(id);
        return cc.orElse(null);
    }

    @Override
    public ConflictCase createConflictCase(ConflictCase cc) {
        return repository.save(cc);
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
