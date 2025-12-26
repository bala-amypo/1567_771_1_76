package com.example.demo.service.impl;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl implements RelationshipDeclarationService {

    @Autowired
    private RelationshipDeclarationRepository repository;

    @Override
    public RelationshipDeclaration create(RelationshipDeclaration declaration) {
        return repository.save(declaration);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(Long id, boolean status) {
        RelationshipDeclaration rd = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Declaration not found"));
        rd.setVerified(status);
        return repository.save(rd);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return repository.findAll();
    }
}
