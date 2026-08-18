package com.example.slotsecure_backend.service;

import com.example.slotsecure_backend.entity.Service;
import com.example.slotsecure_backend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    public List<Service> getAllServicesByVendor (Long vendorId) {
        return serviceRepository.findByVendor_VendorId(vendorId);
    }
}