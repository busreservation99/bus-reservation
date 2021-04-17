package com.lti;

import java.time.LocalDate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lti.repository.AdminRepository;

@SpringBootApplication
public class BusReservationApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BusReservationApplication.class, args);
		System.out.println("working?");
		
		
	}
			
}
