package com.example.demo.controller;

import com.example.demo.model.VendorEngagement;
import com.example.demo.service.VendorEngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor-engagement")
public class VendorEngagementController {

    @Autowired
    private VendorEngagementService vendorService;

    @PostMapping
    public ResponseEntity<VendorEngagement> createVendor(@RequestBody VendorEngagement vendor) {
        return ResponseEntity.ok(vendorService.createVendor(vendor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorEngagement> updateVendor(@PathVariable Long id, @RequestBody VendorEngagement vendor) {
        return ResponseEntity.ok(vendorService.updateVendor(id, vendor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorEngagement> getVendorById(@PathVariable Long id) {
        return ResponseEntity.ok(vendorService.getVendorById(id));
    }

    @GetMapping
    public ResponseEntity<List<VendorEngagement>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }
}
