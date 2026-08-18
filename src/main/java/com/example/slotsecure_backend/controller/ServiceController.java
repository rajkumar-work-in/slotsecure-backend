package com.example.slotsecure_backend.controller;

import com.example.slotsecure_backend.entity.Service;
import com.example.slotsecure_backend.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        Service savedService = serviceService.createService(service);
        return ResponseEntity.ok(savedService);
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Service>> getAllServicesByVendor(@PathVariable Long vendorId) {
        List<Service> services = serviceService.getAllServicesByVendor(vendorId);
        return ResponseEntity.ok(services);
    }
}