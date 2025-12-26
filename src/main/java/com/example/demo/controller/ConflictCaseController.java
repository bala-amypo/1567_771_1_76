package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conflict-cases")
public class ConflictCaseController {

    private final ConflictCaseService caseService;

    // ✅ Constructor injection (REQUIRED)
    public ConflictCaseController(ConflictCaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping
    public ResponseEntity<ConflictCase> create(@RequestBody ConflictCase conflictCase) {
        return ResponseEntity.ok(caseService.createCase(conflictCase));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ConflictCase> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(caseService.updateCaseStatus(id, status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictCase> getById(@PathVariable Long id) {
        return caseService.getCaseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<ConflictCase>> getByPerson(
            @PathVariable Long personId) {

        return ResponseEntity.ok(caseService.getCasesByPerson(personId));
    }

    @GetMapping
    public ResponseEntity<List<ConflictCase>> getAll() {
        return ResponseEntity.ok(caseService.getAllCases());
    }
}
