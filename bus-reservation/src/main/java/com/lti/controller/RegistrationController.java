package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RegisterStatus;
import com.lti.entity.Registration;
import com.lti.exception.RegistrationServiceException;
import com.lti.service.RegistrationService;


@RestController
@CrossOrigin
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/register")
	public RegisterStatus register(@RequestBody Registration registration ) {
		try {
		int id=registrationService.register(registration);
		RegisterStatus status= new RegisterStatus();
		status.setStatus(true);
		status.setMessage("Registration Successful");
		status.setRegisteredCustomerId(id);
		return status;
	}catch(RegistrationServiceException e){
		
			RegisterStatus status= new RegisterStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		 }
	}
}
