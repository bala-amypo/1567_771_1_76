package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor-engagements")
public class VendorEngagementController {

    @Autowired
    private VendorEngagementService service;

    @PostMapping
    public ResponseEntity<VendorEngagementRecord> addEngagement(@RequestBody VendorEngagementRecord record) {
        return ResponseEntity.ok(service.create(record));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<VendorEngagementRecord>> getEngagementsByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getEngagementsByEmployee(employeeId));
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<VendorEngagementRecord>> getEngagementsByVendor(@PathVariable Long vendorId) {
        return ResponseEntity.ok(service.getEngagementsByVendor(vendorId));
    }

    @GetMapping
    public ResponseEntity<List<VendorEngagementRecord>> getAllEngagements() {
        return ResponseEntity.ok(service.getAllEngagements());
    }
}
