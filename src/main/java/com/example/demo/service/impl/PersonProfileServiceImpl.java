package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;

import java.util.List;
import java.util.Optional;

public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository personRepo;

    // ✅ Constructor injection (REQUIRED)
    public PersonProfileServiceImpl(PersonProfileRepository personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public PersonProfile createPerson(PersonProfile person) {

        // email validation
        if (person.getEmail() == null || person.getEmail().trim().isEmpty()) {
            throw new ApiException("email is required");
        }

        if (personRepo.findByEmail(person.getEmail()).isPresent()) {
            throw new ApiException("email already exists");
        }

        // referenceId validation
        if (person.getReferenceId() == null || person.getReferenceId().trim().isEmpty()) {
            throw new ApiException("reference is required");
        }

        if (personRepo.findByReferenceId(person.getReferenceId()).isPresent()) {
            throw new ApiException("reference already exists");
        }

        return personRepo.save(person);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return personRepo.findById(id)
                .orElseThrow(() -> new ApiException("person not found"));
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return personRepo.findAll();
    }

    @Override
    public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
        PersonProfile person = personRepo.findById(id)
                .orElseThrow(() -> new ApiException("person not found"));

        person.setRelationshipDeclared(declared);
        return personRepo.save(person);
    }

    @Override
    public Optional<PersonProfile> findByReferenceId(String referenceId) {
        return personRepo.findByReferenceId(referenceId);
    }
}
