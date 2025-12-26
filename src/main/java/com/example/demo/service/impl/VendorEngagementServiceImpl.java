package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.VendorEngagementRecordRepository;
import com.example.demo.service.VendorEngagementService;

import java.util.List;

public class VendorEngagementServiceImpl
        implements VendorEngagementService {

    private final VendorEngagementRecordRepository repository;
    private final PersonProfileRepository personRepository;

    public VendorEngagementServiceImpl(
            VendorEngagementRecordRepository repository,
            PersonProfileRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    @Override
    public VendorEngagementRecord addEngagement(
            VendorEngagementRecord record) {

        if (!personRepository.findById(record.getEmployeeId()).isPresent())
            throw new ApiException("employee not found");

        if (!personRepository.findById(record.getVendorId()).isPresent())
            throw new ApiException("vendor not found");

        return repository.save(record);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByEmployee(
            Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByVendor(
            Long vendorId) {
        return repository.findByVendorId(vendorId);
    }

    @Override
    public List<VendorEngagementRecord> getAllEngagements() {
        return repository.findAll();
    }
}
