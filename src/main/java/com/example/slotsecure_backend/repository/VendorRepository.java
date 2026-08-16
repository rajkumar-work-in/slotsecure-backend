package com.example.slotsecure_backend.repository;

import com.example.slotsecure_backend.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
