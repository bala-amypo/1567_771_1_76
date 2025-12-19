package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engagements")
public class VendorEngagementController {

    private final VendorEngagementService engagementService;

    public VendorEngagementController(VendorEngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @PostMapping
    public VendorEngagementRecord addEngagement(
            @RequestBody VendorEngagementRecord record) {
        return engagementService.addEngagement(record);
    }

    @GetMapping("/employee/{employeeId}")
    public List<VendorEngagementRecord> getByEmployee(
            @PathVariable Long employeeId) {
        return engagementService.getEngagementsByEmployee(employeeId);
    }

    @GetMapping("/vendor/{vendorId}")
    public List<VendorEngagementRecord> getByVendor(
            @PathVariable Long vendorId) {
        return engagementService.getEngagementsByVendor(vendorId);
    }

    @GetMapping
    public List<VendorEngagementRecord> getAllEngagements() {
        return engagementService.getAllEngagements();
    }
}
