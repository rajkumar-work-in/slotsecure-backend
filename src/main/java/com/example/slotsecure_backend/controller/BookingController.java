package com.example.slotsecure_backend.controller;

import com.example.slotsecure_backend.entity.Booking;
import com.example.slotsecure_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    public ResponseEntity<Booking> createBooking(@RequestParam Long userId, @RequestParam Long timeSlotId) {
        Booking booking = bookingService.createBooking(userId, timeSlotId);
        return ResponseEntity.ok(booking);
    }
}