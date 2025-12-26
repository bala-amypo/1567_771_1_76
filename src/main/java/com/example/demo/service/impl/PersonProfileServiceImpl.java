package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repository;

    public PersonProfileServiceImpl(PersonProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonProfile createPerson(PersonProfile person) {

        if (person.getEmail() == null) {
            throw new ApiException("Email is required",
                    HttpStatus.BAD_REQUEST);
        }

        repository.findByEmail(person.getEmail())
                .ifPresent(p -> {
                    throw new ApiException("Duplicate email",
                            HttpStatus.BAD_REQUEST);
                });

        if (person.getReferenceId() != null) {
            repository.findByReferenceId(person.getReferenceId())
                    .ifPresent(p -> {
                        throw new ApiException("Duplicate referenceId",
                                HttpStatus.BAD_REQUEST);
                    });
        }

        if (person.getRelationshipDeclared() == null) {
            person.setRelationshipDeclared(false);
        }

        return repository.save(person);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ApiException("Person not found",
                                HttpStatus.NOT_FOUND));
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repository.findAll();
    }

    @Override
    public Optional<PersonProfile> findByReferenceId(String referenceId) {
        return repository.findByReferenceId(referenceId);
    }

    @Override
    public PersonProfile updateRelationshipDeclared(
            Long id, boolean declared) {

        PersonProfile p = repository.findById(id)
                .orElseThrow(() ->
                        new ApiException("Person not found",
                                HttpStatus.NOT_FOUND));

        p.setRelationshipDeclared(declared);
        return repository.save(p);
    }
}
