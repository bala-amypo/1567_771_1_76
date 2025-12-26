package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.VendorEngagementRecordRepository;
import com.example.demo.service.VendorEngagementService;

import java.util.List;

public class VendorEngagementServiceImpl implements VendorEngagementService {

    private final VendorEngagementRecordRepository engagementRepo;
    private final PersonProfileRepository personRepo;

    // ✅ Constructor injection (REQUIRED)
    public VendorEngagementServiceImpl(
            VendorEngagementRecordRepository engagementRepo,
            PersonProfileRepository personRepo) {
        this.engagementRepo = engagementRepo;
        this.personRepo = personRepo;
    }

    @Override
    public VendorEngagementRecord addEngagement(VendorEngagementRecord record) {

        // validate employee
        personRepo.findById(record.getEmployeeId())
                .orElseThrow(() -> new ApiException("employee not found"));

        // validate vendor
        personRepo.findById(record.getVendorId())
                .orElseThrow(() -> new ApiException("vendor not found"));

        return engagementRepo.save(record);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByEmployee(Long employeeId) {
        return engagementRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByVendor(Long vendorId) {
        return engagementRepo.findByVendorId(vendorId);
    }

    @Override
    public List<VendorEngagementRecord> getAllEngagements() {
        return engagementRepo.findAll();
    }
}
