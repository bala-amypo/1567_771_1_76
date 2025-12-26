package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conflict-flags")
public class ConflictFlagController {

    private final ConflictFlagService service;

    public ConflictFlagController(ConflictFlagService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ConflictFlag> addFlag(@RequestBody ConflictFlag flag) {
        return ResponseEntity.ok(service.addFlag(flag));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictFlag> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFlagById(id));
    }

    @GetMapping("/case/{id}")
    public ResponseEntity<List<ConflictFlag>> getByCase(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFlagsByCase(id));
    }

    @GetMapping
    public ResponseEntity<List<ConflictFlag>> getAll() {
        return ResponseEntity.ok(service.getAllFlags());
    }
}
