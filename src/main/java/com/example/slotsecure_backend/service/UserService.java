package com.example.slotsecure_backend.service;

import com.example.slotsecure_backend.entity.User;
import com.example.slotsecure_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if(existingUser != null) {
            throw new RuntimeException("Email already registered!");
        }

        return userRepository.save(user);
    }
}
