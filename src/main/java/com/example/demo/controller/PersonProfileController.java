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
        PersonProfile created = personProfileService.createProfile(profile);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonProfile> updateProfile(@PathVariable Long id, @RequestBody PersonProfile profile) {
        PersonProfile updated = personProfileService.updateProfile(id, profile);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonProfile> getProfileById(@PathVariable Long id) {
        PersonProfile profile = personProfileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    @GetMapping
    public ResponseEntity<List<PersonProfile>> getAllProfiles() {
        List<PersonProfile> profiles = personProfileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }
}
