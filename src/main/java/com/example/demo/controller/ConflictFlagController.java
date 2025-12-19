package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conflict-flags")
public class ConflictFlagController {

    private final ConflictFlagService flagService;

    public ConflictFlagController(ConflictFlagService flagService) {
        this.flagService = flagService;
    }

    @PostMapping
    public ConflictFlag addFlag(@RequestBody ConflictFlag flag) {
        return flagService.addFlag(flag);
    }

    @GetMapping("/{id}")
    public ConflictFlag getFlagById(@PathVariable Long id) {
        return flagService.getFlagById(id);
    }

    @GetMapping("/case/{caseId}")
    public List<ConflictFlag> getFlagsByCase(
            @PathVariable Long caseId) {
        return flagService.getFlagsByCase(caseId);
    }

    @GetMapping
    public List<ConflictFlag> getAllFlags() {
        return flagService.getAllFlags();
    }
}
