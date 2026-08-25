package com.example.slotsecure_backend.service;

import com.example.slotsecure_backend.entity.User;
import com.example.slotsecure_backend.exception.DuplicateEmailException;
import com.example.slotsecure_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if(existingUser != null) {
            throw new DuplicateEmailException("Email already registered!");
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }
}