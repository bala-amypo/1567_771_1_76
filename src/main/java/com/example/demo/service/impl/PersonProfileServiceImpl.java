package com.example.demo.service.impl;

import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonProfileServiceImpl
        implements PersonProfileService {

    private final PersonProfileRepository repository;

    public PersonProfileServiceImpl(
            PersonProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonProfile save(PersonProfile personProfile) {
        return repository.save(personProfile);
    }

    @Override
    public List<PersonProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public PersonProfile getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void updateRelationshipDeclared(
            Long id, boolean declared) {

        PersonProfile profile =
                repository.findById(id).orElse(null);

        if (profile != null) {
            profile.setRelationshipDeclared(declared);
            repository.save(profile);
        }
    }
}
