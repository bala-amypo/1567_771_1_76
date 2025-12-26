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
        return ResponseEntity.ok(conflictFlagService.createConflictFlag(conflictFlag));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConflictFlag> updateConflictFlag(@PathVariable Long id, @RequestBody ConflictFlag conflictFlag) {
        return ResponseEntity.ok(conflictFlagService.updateConflictFlag(id, conflictFlag));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictFlag> getConflictFlagById(@PathVariable Long id) {
        return ResponseEntity.ok(conflictFlagService.getConflictFlagById(id));
    }

    @GetMapping
    public ResponseEntity<List<ConflictFlag>> getAllConflictFlags() {
        return ResponseEntity.ok(conflictFlagService.getAllConflictFlags());
    }
}
