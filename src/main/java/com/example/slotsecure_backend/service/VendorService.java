package com.example.slotsecure_backend.service;

import com.example.slotsecure_backend.entity.Role;
import com.example.slotsecure_backend.entity.User;
import com.example.slotsecure_backend.entity.Vendor;
import com.example.slotsecure_backend.repository.UserRepository;
import com.example.slotsecure_backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private UserRepository userRepository;

    public Vendor createVendor(Vendor vendor, String email) {
        User existingUser = userRepository.findByEmail(email);

        if(existingUser == null) {
            throw new RuntimeException("User not found!");
        }

        existingUser.setRole(Role.VENDOR);
        userRepository.save(existingUser);

        vendor.setUser(existingUser);

        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
}