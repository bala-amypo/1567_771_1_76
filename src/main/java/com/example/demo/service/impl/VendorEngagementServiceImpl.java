package com.example.demo.service.impl;

import com.example.demo.model.VendorEngagement;
import com.example.demo.repository.VendorEngagementRepository;
import com.example.demo.service.VendorEngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorEngagementServiceImpl implements VendorEngagementService {

    @Autowired
    private VendorEngagementRepository repository;

    @Override
    public List<VendorEngagement> getAllVendors() {
        return repository.findAll();
    }

    @Override
    public VendorEngagement getVendorById(Long id) {
        Optional<VendorEngagement> vendor = repository.findById(id);
        return vendor.orElse(null);
    }

    @Override
    public VendorEngagement saveVendor(VendorEngagement vendor) {
        return repository.save(vendor);
    }

    @Override
    public void deleteVendor(Long id) {
        repository.deleteById(id);
    }
}
