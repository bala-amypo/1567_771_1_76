package com.example.demo.controller;

import com.example.demo.model.VendorEngagement;
import com.example.demo.service.VendorEngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorEngagementController {

    @Autowired
    private VendorEngagementService vendorService;

    @GetMapping
    public List<VendorEngagement> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public VendorEngagement getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }

    @PostMapping
    public VendorEngagement createVendor(@RequestBody VendorEngagement vendor) {
        return vendorService.createVendor(vendor);
    }

    @PutMapping("/{id}")
    public VendorEngagement updateVendor(@PathVariable Long id, @RequestBody VendorEngagement vendor) {
        return vendorService.updateVendor(id, vendor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
    }
}
