package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationship")
public class RelationshipDeclarationController {

    @Autowired
    private RelationshipDeclarationService relationshipService;

    @PostMapping
    public ResponseEntity<RelationshipDeclaration> createRelationship(@RequestBody RelationshipDeclaration rel) {
        return ResponseEntity.ok(relationshipService.createRelationship(rel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelationshipDeclaration> updateRelationship(@PathVariable Long id, @RequestBody RelationshipDeclaration rel) {
        return ResponseEntity.ok(relationshipService.updateRelationship(id, rel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelationshipDeclaration> getRelationshipById(@PathVariable Long id) {
        return ResponseEntity.ok(relationshipService.getRelationshipById(id));
    }

    @GetMapping
    public ResponseEntity<List<RelationshipDeclaration>> getAllRelationships() {
        return ResponseEntity.ok(relationshipService.getAllRelationships());
    }
}
