package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationship-declarations")
public class RelationshipDeclarationController {

    @Autowired
    private RelationshipDeclarationService service;

    @PostMapping
    public ResponseEntity<RelationshipDeclaration> declareRelationship(@RequestBody RelationshipDeclaration rd) {
        return ResponseEntity.ok(service.create(rd));
    }

    @PutMapping("/{id}/verify")
    public ResponseEntity<RelationshipDeclaration> verifyDeclaration(@PathVariable Long id,
                                                                     @RequestParam boolean status) {
        return ResponseEntity.ok(service.verifyDeclaration(id, status));
    }
}
