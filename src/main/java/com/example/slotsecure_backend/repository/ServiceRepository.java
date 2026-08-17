package com.example.slotsecure_backend.repository;

import com.example.slotsecure_backend.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findByVendor_VendorId(Long vendorId);
}