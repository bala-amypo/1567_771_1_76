package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository declarationRepo;
    private final PersonProfileRepository personRepo;

    public RelationshipDeclarationServiceImpl(
            RelationshipDeclarationRepository declarationRepo,
            PersonProfileRepository personRepo) {
        this.declarationRepo = declarationRepo;
        this.personRepo = personRepo;
    }

    @Override
    public RelationshipDeclaration declareRelationship(
            RelationshipDeclaration declaration) {

        personRepo.findById(declaration.getPersonId())
                .orElseThrow(() -> new ApiException("person not found"));

        return declarationRepo.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
        return declarationRepo.findAll().stream()
                .filter(d -> d.getPersonId().equals(personId))
                .collect(Collectors.toList());
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(
            Long declarationId, boolean verified) {

        RelationshipDeclaration declaration =
                declarationRepo.findById(declarationId)
                        .orElseThrow(() -> new ApiException("declaration not found"));

        declaration.setIsVerified(verified);
        return declarationRepo.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return declarationRepo.findAll();
    }
}
