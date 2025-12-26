package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository relationshipRepo;
    private final PersonProfileRepository personRepo;

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

        PersonProfile person = personRepo.findById(personId)
                .orElseThrow(() ->
                        new ApiException("Person not found",
                                HttpStatus.NOT_FOUND));

        person.setRelationshipDeclared(true);
        personRepo.save(person);

        return relationshipRepo.save(declaration);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(
            Long id, boolean status) {

        RelationshipDeclaration rd = relationshipRepo.findById(id)
                .orElseThrow(() ->
                        new ApiException("Declaration not found",
                                HttpStatus.NOT_FOUND));

        rd.setIsVerified(status);
        return relationshipRepo.save(rd);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return relationshipRepo.findAll();
    }
}
