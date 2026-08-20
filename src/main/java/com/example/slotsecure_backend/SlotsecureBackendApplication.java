package com.example.slotsecure_backend;

import com.example.slotsecure_backend.service.BookingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SlotsecureBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(SlotsecureBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner testConcurancy(BookingService bookingService) {
		return args -> {

			Long timeSlotId = 2l;

			Runnable aravindTask = () -> {
				try {
					bookingService.createBooking(1L, timeSlotId);
					System.out.println("ARAVIND: Booking SUCCESS!");
				} catch (Exception e) {
					System.out.println("ARAVIND: Booking FAILED - " + e.getMessage());
				}
			};

			Runnable priyaTask = () -> {
				try {
					bookingService.createBooking(2L, timeSlotId);
					System.out.println("PRIYA: Booking SUCCESS!");
				} catch (Exception e) {
					System.out.println("PRIYA: Booking FAILED - " + e.getMessage());
				}
			};

			Thread thread1 = new Thread(aravindTask);
			Thread thread2 = new Thread(priyaTask);

			thread1.start();
			thread2.start();

			thread1.join();
			thread2.join();

			System.out.println("=== TEST COMPLETE ===");

		};
	}
}