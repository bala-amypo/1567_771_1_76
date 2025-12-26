package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor-engagements")
public class VendorEngagementController {

    private final VendorEngagementService service;

    public VendorEngagementController(VendorEngagementService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VendorEngagementRecord> addEngagement(
            @RequestBody VendorEngagementRecord record) {
        return ResponseEntity.ok(service.addEngagement(record));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<VendorEngagementRecord>> byEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEngagementsByEmployee(id));
    }

    @GetMapping("/vendor/{id}")
    public ResponseEntity<List<VendorEngagementRecord>> byVendor(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEngagementsByVendor(id));
    }

    @GetMapping
    public ResponseEntity<List<VendorEngagementRecord>> getAll() {
        return ResponseEntity.ok(service.getAllEngagements());
    }
}
