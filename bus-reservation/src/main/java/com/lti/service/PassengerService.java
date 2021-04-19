package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Bus;
import com.lti.entity.Passenger;
import com.lti.entity.Schedule;
import com.lti.exception.PassengerServiceException;
import com.lti.exception.RegistrationServiceException;
import com.lti.repository.PassengerRepository;
import com.lti.repository.ScheduleRepository;

// adding Passengers 

@Service
@Transactional
public class PassengerService {

	@Autowired
	private PassengerRepository passengerrepository;
	
	public int  addPassenger(Passenger passenger) {
		
		if(passengerrepository.addPassengers(passenger.getPhoneNumber())) {
			throw new PassengerServiceException("passenger already in database");
			
		}
		else
		{
			Passenger b = (Passenger)passengerrepository.save(passenger);
			return b.getId();
		}
//		passengerrepository.save(passenger);	
	}
}
