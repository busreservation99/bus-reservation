package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.lti.entity.Booking;
import com.lti.entity.Passenger;
import com.lti.entity.Payment;
import com.lti.exception.PassengerServiceException;
import com.lti.exception.PaymentServiceException;
import com.lti.repository.PassengerRepository;
import com.lti.repository.PaymentRepository;

@Service
@Transactional
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentrepository ;
	
	public int paymentPresent(Payment payment) {
		if(paymentrepository.isPaymentPresent(payment.getId())) {
			throw new PaymentServiceException("payment already in database");
			
		}
		else
		{
			Payment b = (Payment)paymentrepository.save(payment);
			return b.getId();
		}
	}
	
	

}
