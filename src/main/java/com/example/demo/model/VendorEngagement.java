package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class VendorEngagement{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private VendorEngagement vendor;

    private String recordDetails;

    // Constructors
    public VendorEngagementRecord() {}

    public VendorEngagementRecord(VendorEngagement vendor, String recordDetails) {
        this.vendor = vendor;
        this.recordDetails = recordDetails;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public VendorEngagement getVendor() { return vendor; }
    public void setVendor(VendorEngagement vendor) { this.vendor = vendor; }

    public String getRecordDetails() { return recordDetails; }
    public void setRecordDetails(String recordDetails) { this.recordDetails = recordDetails; }
}
