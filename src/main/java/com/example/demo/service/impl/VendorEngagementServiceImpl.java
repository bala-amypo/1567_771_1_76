package com.example.demo.service.impl;

import com.example.demo.model.VendorEngagement;
import com.example.demo.repository.VendorEngagementRepository;
import com.example.demo.service.VendorEngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorEngagementServiceImpl implements VendorEngagementService {

    @Autowired
    private VendorEngagementRecordRepository repository;

    @Override
    public VendorEngagementRecord create(VendorEngagementRecord record) {
        return repository.save(record);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByVendor(Long vendorId) {
        return repository.findByVendorId(vendorId);
    }

    @Override
    public List<VendorEngagementRecord> getAllEngagements() {
        return repository.findAll();
    }
}
