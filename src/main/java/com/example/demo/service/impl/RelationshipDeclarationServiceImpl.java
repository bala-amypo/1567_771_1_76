package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;

import java.util.List;

public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository relationshipRepo;
    private final PersonProfileRepository personRepo;

    // ✅ Constructor injection (REQUIRED by tests)
    public RelationshipDeclarationServiceImpl(
            RelationshipDeclarationRepository relationshipRepo,
            PersonProfileRepository personRepo) {
        this.relationshipRepo = relationshipRepo;
        this.personRepo = personRepo;
    }

    @Override
    public RelationshipDeclaration declareRelationship(
            RelationshipDeclaration declaration) {

        Long personId = declaration.getPersonId();

        // Validate person existence
        personRepo.findById(personId)
                .orElseThrow(() -> new ApiException("person not found"));

        return relationshipRepo.save(declaration);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(
            Long declarationId,
            boolean verified) {

        RelationshipDeclaration rd = relationshipRepo.findById(declarationId)
                .orElseThrow(() -> new ApiException("declaration not found"));

        rd.setIsVerified(verified);
        return relationshipRepo.save(rd);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return relationshipRepo.findAll();
    }
}
