package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BookingDetails;
import com.lti.dto.Status;
import com.lti.entity.Booking;
import com.lti.entity.Passenger;
import com.lti.exception.BookingServiceException;
import com.lti.exception.PassengerServiceException;
import com.lti.service.BookingService;
import com.lti.service.PassengerService;
@RestController
@CrossOrigin
public class BookingController {

	@Autowired
	private BookingService bookingservice;
	
	@PostMapping("/addBooking")
	public Status addBooking(@RequestBody BookingDetails bookingDetails) throws BookingServiceException {
		try {
			
			int id=bookingservice.addBooking(bookingDetails);
			Status status= new Status();
			status.setStatus(true);
			status.setMessage("booking Added Successfully + id="+id);
			return status;
		}
		catch(PassengerServiceException e) {
			Status status= new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
		
	}
	@GetMapping("/cancel")
	public String cancelBooking(@RequestParam("id") int id ) {
		String str=bookingservice.cancelBooking(id);
		return str;
	}


}

