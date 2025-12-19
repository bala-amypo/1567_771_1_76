package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {

    private final PersonProfileService personProfileService;

    public PersonProfileController(PersonProfileService personProfileService) {
        this.personProfileService = personProfileService;
    }

    @PostMapping
    public PersonProfile createPerson(@RequestBody PersonProfile person) {
        return personProfileService.createPerson(person);
    }

    @GetMapping("/{id}")
    public PersonProfile getPersonById(@PathVariable Long id) {
        return personProfileService.getPersonById(id);
    }

    @GetMapping
    public List<PersonProfile> getAllPersons() {
        return personProfileService.getAllPersons();
    }

    @GetMapping("/reference/{referenceId}")
    public PersonProfile getByReferenceId(@PathVariable String referenceId) {
        return personProfileService.findByReferenceId(referenceId);
    }

    @PutMapping("/{id}/relationship-declared")
    public PersonProfile updateRelationshipDeclared(
            @PathVariable Long id,
            @RequestParam boolean declared) {
        return personProfileService.updateRelationshipDeclared(id, declared);
    }
}
