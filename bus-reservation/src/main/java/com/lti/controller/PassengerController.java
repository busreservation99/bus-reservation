package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PassengerStatus;
import com.lti.dto.Status;

import com.lti.entity.Passenger;

import com.lti.exception.PassengerServiceException;
import com.lti.repository.GenericRepository;
import com.lti.service.BookingService;
import com.lti.service.PassengerService;

@RestController
@CrossOrigin
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private GenericRepository genericRepository;
	
	@PostMapping("/addPassengers")
	@Transactional
	public PassengerStatus addPassenger(@RequestBody List<Passenger> passengers) {
		genericRepository.save(passengers);
		return null;
		
	}
	
	
}
