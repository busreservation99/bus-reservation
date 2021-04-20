package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PassengerStatus;
import com.lti.dto.Status;

import com.lti.entity.Passenger;

import com.lti.exception.PassengerServiceException;
import com.lti.service.BookingService;
import com.lti.service.PassengerService;

@RestController
@CrossOrigin
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;
	
	@PostMapping("/addPassengers")
	public PassengerStatus addPassenger(@RequestBody Passenger passengers) {
		try {
		
		passengerService.addPassenger(passengers);
		PassengerStatus status= new PassengerStatus();
		status.setStatus(true);
		status.setMessage("Passenger Added Successfully");
		System.out.println("Hello "+passengers.getName());
		return status;
		}
		catch(PassengerServiceException e){
			PassengerStatus status= new PassengerStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
		
	}
	
	
}
