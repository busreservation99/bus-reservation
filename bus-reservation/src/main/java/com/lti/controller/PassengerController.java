package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PassengerStatus;
import com.lti.dto.Status;

import com.lti.entity.Passenger;

import com.lti.exception.PassengerServiceException;

import com.lti.service.PassengerService;

@RestController
@CrossOrigin
public class PassengerController {
	// passsenger controller 
	@Autowired
	private PassengerService passengerservice;
	@PostMapping("/addPassenger")
	public PassengerStatus addbus(@RequestBody Passenger passenger) {
		try {
			passengerservice.addPassenger(passenger);
			PassengerStatus status= new PassengerStatus();
			status.setStatus(true);
			status.setMessage("Passenger Added Successfully");
			return status;
		}
		catch(PassengerServiceException e) {
			PassengerStatus status= new PassengerStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
		
	}
		
}
