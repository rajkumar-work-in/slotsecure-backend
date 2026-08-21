package com.example.slotsecure_backend.service;

import com.example.slotsecure_backend.entity.Booking;
import com.example.slotsecure_backend.entity.BookingStatus;
import com.example.slotsecure_backend.entity.TimeSlot;
import com.example.slotsecure_backend.entity.User;
import com.example.slotsecure_backend.exception.SlotAlreadyBookedException;
import com.example.slotsecure_backend.repository.BookingRepository;
import com.example.slotsecure_backend.repository.TimeSlotRepository;
import com.example.slotsecure_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Long userId, Long timeSlotId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(""));

        TimeSlot timeSlot = timeSlotRepository.findById(timeSlotId)
                .orElseThrow(() -> new RuntimeException("TimeSlot not found!"));

        if(timeSlot.isBooked()) {
            throw new SlotAlreadyBookedException("This slot is already booked!");
        }

        timeSlot.setBooked(true);

        try{
            timeSlotRepository.save(timeSlot);
        } catch (OptimisticLockingFailureException ex) {
            throw new RuntimeException("This slot was just booked by someone else. Please choose another slot!");
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setTimeSlot(timeSlot);
        booking.setStatus(BookingStatus.BOOKED);

        return bookingRepository.save(booking);
    }
}