package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService relationshipService;

    // ✅ Constructor injection (REQUIRED)
    public RelationshipDeclarationController(
            RelationshipDeclarationService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping
    public ResponseEntity<RelationshipDeclaration> declare(
            @RequestBody RelationshipDeclaration declaration) {

        return ResponseEntity.ok(
                relationshipService.declareRelationship(declaration)
        );
    }

    @PatchMapping("/{id}/verify")
    public ResponseEntity<RelationshipDeclaration> verify(
            @PathVariable Long id,
            @RequestParam boolean verified) {

        return ResponseEntity.ok(
                relationshipService.verifyDeclaration(id, verified)
        );
    }

    @GetMapping
    public ResponseEntity<List<RelationshipDeclaration>> getAll() {
        return ResponseEntity.ok(
                relationshipService.getAllDeclarations()
        );
    }
}
