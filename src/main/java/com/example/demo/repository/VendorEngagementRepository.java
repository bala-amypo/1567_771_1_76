package com.example.demo.repository;

import com.example.demo.model.VendorEngagement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VendorEngagementRepository extends JpaRepository<VendorEngagement, Long> {
    List<VendorEngagement> findByEmployeeId(Long employeeId);
    List<VendorEngagement> findByVendorId(Long vendorId);
}
