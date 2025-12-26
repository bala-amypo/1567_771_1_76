package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conflict-case")
public class ConflictCaseController {

    private final ConflictCaseService conflictCaseService;

    public ConflictCaseController(
            ConflictCaseService conflictCaseService) {
        this.conflictCaseService = conflictCaseService;
    }

    // endpoints...
}
