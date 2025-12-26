package com.example.demo.service.impl;

import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    @Autowired
    private PersonProfileRepository repository;
    @Override
public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
    PersonProfile p = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Person not found"));
    p.setRelationshipDeclared(declared);
    return repository.save(p);
}


    @Override
    public PersonProfile createPerson(PersonProfile person) {
        return repository.save(person);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repository.findAll();
    }

    @Override
    public PersonProfile findByReferenceId(String referenceId) {
        return repository.findByReferenceId(referenceId)
            .orElseThrow(() -> new RuntimeException("Person not found"));
    }
}
