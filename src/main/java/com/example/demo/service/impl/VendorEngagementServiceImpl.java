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
        return repository.findById(id).orElse(null);
    }

    @Override
    public VendorEngagement createVendor(VendorEngagement vendor) {
        return repository.save(vendor);
    }

    @Override
    public VendorEngagement updateVendor(Long id, VendorEngagement vendor) {
        Optional<VendorEngagement> existing = repository.findById(id);
        if(existing.isPresent()) {
            VendorEngagement v = existing.get();
            v.setName(vendor.getName());
            v.setEmail(vendor.getEmail());
            v.setPhone(vendor.getPhone());
            return repository.save(v);
        }
        return null;
    }

    @Override
    public void deleteVendor(Long id) {
        repository.deleteById(id);
    }
}
