package com.example.slotsecure_backend.service;

import com.example.slotsecure_backend.entity.TimeSlot;
import com.example.slotsecure_backend.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public TimeSlot createTimeSlot(TimeSlot timeSlot) {
        return timeSlotRepository.save(timeSlot);
    }

    public List<TimeSlot> getAvailableSlots(Long serviceId) {
        return timeSlotRepository.findByService_ServiceIdAndIsBookedFalse(serviceId);
    }
}