package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonProfileController {

    @Autowired
    private PersonProfileService service;

    @PostMapping
    public ResponseEntity<PersonProfile> createPerson(@RequestBody PersonProfile person) {
        return ResponseEntity.ok(service.createPerson(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonProfile> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPersonById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonProfile>> getAllPersons() {
        return ResponseEntity.ok(service.getAllPersons());
    }

    @GetMapping("/reference/{refId}")
    public ResponseEntity<PersonProfile> findByReferenceId(@PathVariable String refId) {
        return ResponseEntity.ok(service.findByReferenceId(refId));
    }

    @PutMapping("/{id}/relationship-declared")
    public ResponseEntity<PersonProfile> updateRelationshipDeclared(@PathVariable Long id,
                                                                    @RequestParam boolean declared) {
        return ResponseEntity.ok(service.updateRelationshipDeclared(id, declared));
    }
}
