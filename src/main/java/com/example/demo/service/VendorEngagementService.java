package com.example.demo.service;

import com.example.demo.model.VendorEngagement;
import java.util.List;

public interface VendorEngagementService {
    VendorEngagement createVendor(VendorEngagement vendor);
    VendorEngagement updateVendor(Long id, VendorEngagement vendor);
    VendorEngagement getVendorById(Long id);
    List<VendorEngagement> getAllVendors();
}
