package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PaymentStatus;
import com.lti.dto.Status;
import com.lti.entity.Booking;
import com.lti.entity.Payment;
import com.lti.exception.BookingServiceException;
import com.lti.exception.PassengerServiceException;
import com.lti.exception.PaymentServiceException;
import com.lti.service.BookingService;
import com.lti.service.PaymentService;

@RestController
@CrossOrigin
public class PaymentController {
	
	@Autowired
	private PaymentService paymentservice ;
	@PostMapping("/addPayment")
	public PaymentStatus addbus(@RequestBody Payment payment) throws BookingServiceException {
		try {
			paymentservice.paymentPresent(payment);
			PaymentStatus status= new PaymentStatus();
			status.setStatus(true);
			status.setMessage("payment Added Successfully");
			return status;
		}
		catch(PaymentServiceException e) {
			PaymentStatus status= new PaymentStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
		
	}
	
	
	
	
	
	

}
