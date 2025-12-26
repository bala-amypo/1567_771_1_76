package com.example.demo.service;

import com.example.demo.model.PersonProfile;

import java.util.List;

public interface PersonProfileService {

    PersonProfile save(PersonProfile personProfile);

    List<PersonProfile> getAll();

    PersonProfile getById(Long id);

    void updateRelationshipDeclared(Long id, boolean declared);
}
