package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conflict-flag")
public class ConflictFlagController {

    @Autowired
    private ConflictFlagService conflictFlagService;

    @PostMapping
    public ResponseEntity<ConflictFlag> createConflictFlag(@RequestBody ConflictFlag conflictFlag) {
        ConflictFlag created = conflictFlagService.createConflictFlag(conflictFlag);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConflictFlag> updateConflictFlag(@PathVariable Long id, @RequestBody ConflictFlag conflictFlag) {
        ConflictFlag updated = conflictFlagService.updateConflictFlag(id, conflictFlag);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictFlag> getConflictFlagById(@PathVariable Long id) {
        ConflictFlag conflictFlag = conflictFlagService.getConflictFlagById(id);
        return ResponseEntity.ok(conflictFlag);
    }

    @GetMapping
    public ResponseEntity<List<ConflictFlag>> getAllConflictFlags() {
        List<ConflictFlag> conflictFlags = conflictFlagService.getAllConflictFlags();
        return ResponseEntity.ok(conflictFlags);
    }
}
