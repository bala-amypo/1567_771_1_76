package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {

    private final PersonProfileService personService;

    // ✅ Constructor injection (REQUIRED)
    public PersonProfileController(PersonProfileService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonProfile> create(@RequestBody PersonProfile person) {
        return ResponseEntity.ok(personService.createPerson(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonProfile>> getAll() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PatchMapping("/{id}/relationship-declared")
    public ResponseEntity<PersonProfile> updateRelationshipDeclared(
            @PathVariable Long id,
            @RequestParam boolean declared) {

        return ResponseEntity.ok(
                personService.updateRelationshipDeclared(id, declared)
        );
    }

    @GetMapping("/lookup/{referenceId}")
    public ResponseEntity<PersonProfile> lookup(
            @PathVariable String referenceId) {

        Optional<PersonProfile> opt =
                personService.findByReferenceId(referenceId);

        return opt.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }
}
