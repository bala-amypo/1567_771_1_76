package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conflict-flags")
public class ConflictFlagController {

    private final ConflictFlagService flagService;

    // ✅ Constructor injection (REQUIRED)
    public ConflictFlagController(ConflictFlagService flagService) {
        this.flagService = flagService;
    }

    @PostMapping
    public ResponseEntity<ConflictFlag> addFlag(@RequestBody ConflictFlag flag) {
        return ResponseEntity.ok(flagService.addFlag(flag));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictFlag> getById(@PathVariable Long id) {
        return ResponseEntity.ok(flagService.getFlagById(id));
    }

    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<ConflictFlag>> getByCase(@PathVariable Long caseId) {
        return ResponseEntity.ok(flagService.getFlagsByCase(caseId));
    }

    @GetMapping
    public ResponseEntity<List<ConflictFlag>> getAll() {
        return ResponseEntity.ok(flagService.getAllFlags());
    }
}
