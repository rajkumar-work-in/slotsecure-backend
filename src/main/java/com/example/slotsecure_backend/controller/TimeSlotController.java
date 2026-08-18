package com.example.slotsecure_backend.controller;

import com.example.slotsecure_backend.entity.TimeSlot;
import com.example.slotsecure_backend.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TimeSlots")
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;

    @PostMapping
    public ResponseEntity<TimeSlot> createTimeSlot(@RequestBody TimeSlot timeSlot) {
        TimeSlot savedSlot = timeSlotService.createTimeSlot(timeSlot);
        return ResponseEntity.ok(savedSlot);
    }

    @GetMapping("/service/{serviceId}/available")
    public ResponseEntity<List<TimeSlot>> getAvailableTimeSlots(@PathVariable Long serviceId) {
        List<TimeSlot> slots = timeSlotService.getAvailableSlots(serviceId);
        return ResponseEntity.ok(slots);
    }
}