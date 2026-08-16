package com.example.slotsecure_backend.repository;

import com.example.slotsecure_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}