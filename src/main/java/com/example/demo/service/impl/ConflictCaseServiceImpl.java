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
    public List<ConflictCase> getAllConflictCases() {
        return repository.findAll();
    }

    @Override
    public ConflictCase createConflictCase(ConflictCase cc) {
        return repository.save(cc);
    }

    @Override
    public ConflictCase updateConflictCase(Long id, ConflictCase cc) {
        return repository.findById(id).map(existing -> {
            existing.setStatus(cc.getStatus());
            return repository.save(existing);
        }).orElse(null);
    }

    @Override
    public void deleteConflictCase(Long id) {
        repository.deleteById(id);
    }
}
