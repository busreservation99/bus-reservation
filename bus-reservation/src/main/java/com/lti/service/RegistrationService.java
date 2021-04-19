package com.lti.service;

import java.util.Base64;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Registration;
import com.lti.exception.RegistrationServiceException;
import com.lti.repository.RegistrationRepository;


@Service
@Transactional
public class RegistrationService {
		
	@Autowired
	private RegistrationRepository registrationRepository;
	
	public int register(Registration registration) {
		
		if(registrationRepository.isCustomerPresent(registration.getEmail())) {
			throw new RegistrationServiceException("Customer already registered");
		}
		
		else {
			registration.setPassword(Base64.getEncoder().encodeToString(registration.getPassword().getBytes()));
			Registration updateRegistration=(Registration) registrationRepository.save(registration);
			return updateRegistration.getRegistrationId();
						
		}
		
	}
	
	public Registration login(String email, String password) {
		try {
			password = Base64.getEncoder().encodeToString(password.getBytes());
			int id = registrationRepository.fetchIdByEmailAndPassword(email, password);
			Registration registration = registrationRepository.fetch(Registration.class, id);
			return registration;
		}
		catch(EmptyResultDataAccessException e) {
		//catch(NoResultException e) {
			throw new RegistrationServiceException("Invalid email/password");
		}
	}
		
}


