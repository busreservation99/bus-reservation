package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BookingStatus;
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
public Status addBooking(@RequestBody Booking booking) throws BookingServiceException {
try {

bookingservice.addBooking(booking);
Status status= new Status();
status.setStatus(true);
status.setMessage("booking Added Successfully");
return status;
}
catch(PassengerServiceException e) {
Status status= new Status();
status.setStatus(false);
status.setMessage(e.getMessage());
return status;
}

}



}

