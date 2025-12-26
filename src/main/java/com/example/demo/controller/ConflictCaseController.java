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
        return ResponseEntity.ok(conflictCaseService.createConflictCase(conflictCase));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConflictCase> updateConflictCase(@PathVariable Long id, @RequestBody ConflictCase conflictCase) {
        return ResponseEntity.ok(conflictCaseService.updateConflictCase(id, conflictCase));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictCase> getConflictCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(conflictCaseService.getConflictCaseById(id));
    }

    @GetMapping
    public ResponseEntity<List<ConflictCase>> getAllConflictCases() {
        return ResponseEntity.ok(conflictCaseService.getAllConflictCases());
    }
}
