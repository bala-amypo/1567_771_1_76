package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

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
    public ResponseEntity<PersonProfile> getByReferenceId(@PathVariable String refId) {
        return service.findByReferenceId(refId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
