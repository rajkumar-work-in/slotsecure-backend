package com.example.slotsecure_backend.service;

import com.example.slotsecure_backend.entity.User;
import com.example.slotsecure_backend.exception.DuplicateEmailException;
import com.example.slotsecure_backend.repository.UserRepository;
import com.example.slotsecure_backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public User registerUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if(existingUser != null) {
            throw new DuplicateEmailException("Email already registered!");
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    public String loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }

        boolean isPasswordCorrect = passwordEncoder.matches(password, user.getPassword());

        if (!isPasswordCorrect) {
            throw new RuntimeException("Invalid email or password");
        }

        return jwtUtil.generateToken(user.getEmail(), user.getUserId(), user.getPassword());
    }
}