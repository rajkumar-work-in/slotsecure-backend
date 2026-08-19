package com.example.slotsecure_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEmail(DuplicateEmailException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error:", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(SlotAlreadyBookedException.class)
    public ResponseEntity<Map<String, String>> handleSlotAlreadyBooked(SlotAlreadyBookedException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error:", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}