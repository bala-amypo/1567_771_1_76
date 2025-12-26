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
        RelationshipDeclaration created = relationshipService.createRelationship(rel);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelationshipDeclaration> updateRelationship(@PathVariable Long id, @RequestBody RelationshipDeclaration rel) {
        RelationshipDeclaration updated = relationshipService.updateRelationship(id, rel);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelationshipDeclaration> getRelationshipById(@PathVariable Long id) {
        RelationshipDeclaration rel = relationshipService.getRelationshipById(id);
        return ResponseEntity.ok(rel);
    }

    @GetMapping
    public ResponseEntity<List<RelationshipDeclaration>> getAllRelationships() {
        List<RelationshipDeclaration> list = relationshipService.getAllRelationships();
        return ResponseEntity.ok(list);
    }
}
