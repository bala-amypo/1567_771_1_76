package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conflict-case")
public class ConflictCaseController {

    @Autowired
    private ConflictCaseService conflictCaseService;

    @PostMapping
    public ResponseEntity<ConflictCase> createConflictCase(@RequestBody ConflictCase conflictCase) {
        ConflictCase created = conflictCaseService.createConflictCase(conflictCase);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConflictCase> updateConflictCase(@PathVariable Long id, @RequestBody ConflictCase conflictCase) {
        ConflictCase updated = conflictCaseService.updateConflictCase(id, conflictCase);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictCase> getConflictCaseById(@PathVariable Long id) {
        ConflictCase conflictCase = conflictCaseService.getConflictCaseById(id);
        return ResponseEntity.ok(conflictCase);
    }

    @GetMapping
    public ResponseEntity<List<ConflictCase>> getAllConflictCases() {
        List<ConflictCase> list = conflictCaseService.getAllConflictCases();
        return ResponseEntity.ok(list);
    }
}
