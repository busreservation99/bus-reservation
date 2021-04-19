package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.dto.RegisterStatus;
import com.lti.dto.Status;
import com.lti.entity.Bus;
import com.lti.entity.BusSeat;
import com.lti.entity.Registration;
import com.lti.entity.Route;
import com.lti.exception.RegistrationServiceException;
import com.lti.service.AdminService;
import com.lti.service.RegistrationService;


@RestController
@CrossOrigin
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private AdminService adminService;
	
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
	
	@PostMapping("/login")
	public LoginStatus login(@RequestBody Login login) {
		try {
			Registration registration = registrationService.login(login.getEmail(), login.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(true);
			loginStatus.setMessage("Login successful!");
			loginStatus.setRegistrationId(registration.getRegistrationId());
			loginStatus.setName(registration.getFirstName());
			return loginStatus;
		}
		catch(RegistrationServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(false);
			loginStatus.setMessage(e.getMessage());		
			return loginStatus;
		}
	}
	
	@PostMapping("/addbus")
	public Status addbus(@RequestBody Bus bus) {
		try {
		    adminService.addBus(bus);
			Status status= new Status();
			status.setStatus(true);
			status.setMessage("Bus Added Successfully");
			return status;
		}
		catch(RegistrationServiceException e) {
			Status status= new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/removebus")
	public Status removeBus(@RequestParam("busNumber") int busNumber) {
		try {
			adminService.removeBus(busNumber);
			Status status= new Status();
			status.setStatus(true);
			status.setMessage("Bus Removed Successfully");
			return status;
		}
		catch(RegistrationServiceException e) {
			Status status= new Status();
			status.setStatus(false);
			status.setMessage("Already Removed");
			return status;
		}
	}
	
	//completed admin 
	/*
	 * @PostMapping("/addroute") public Status addroute(@RequestBody Route route) {
	 * try { adminService.addroute(route); Status status= new Status();
	 * status.setStatus(true); status.setMessage("Routes Removed Successfully");
	 * return status; } catch(RegistrationServiceException e) { Status status= new
	 * Status(); status.setStatus(false); status.setMessage("Error 475"); return
	 * status; }
	 * 
	 * }
	 */
	
	
}
