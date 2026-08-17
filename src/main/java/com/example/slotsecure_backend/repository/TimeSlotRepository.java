package com.example.slotsecure_backend.repository;

import com.example.slotsecure_backend.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {

    List<TimeSlot> findByService_ServiceIdAndIsBookedFalse(Long serviceId);
}