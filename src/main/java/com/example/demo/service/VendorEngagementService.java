package com.example.demo.service;

import com.example.demo.model.VendorEngagement;
import java.util.List;

public interface VendorEngagementService {
    List<VendorEngagement> getAllVendors();
    VendorEngagement getVendorById(Long id);
    VendorEngagement saveVendor(VendorEngagement vendor);
    void deleteVendor(Long id);
}
