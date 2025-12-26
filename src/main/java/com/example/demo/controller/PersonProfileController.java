package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person-profile")
public class PersonProfileController {

    @Autowired
    private PersonProfileService personProfileService;

    @PostMapping
    public ResponseEntity<PersonProfile> createProfile(@RequestBody PersonProfile profile) {
        return ResponseEntity.ok(personProfileService.createProfile(profile));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonProfile> updateProfile(@PathVariable Long id, @RequestBody PersonProfile profile) {
        return ResponseEntity.ok(personProfileService.updateProfile(id, profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonProfile> getProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(personProfileService.getProfileById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonProfile>> getAllProfiles() {
        return ResponseEntity.ok(personProfileService.getAllProfiles());
    }
}
