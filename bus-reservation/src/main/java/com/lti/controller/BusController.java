package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.entity.Bus;
import com.lti.exception.BusServiceException;
import com.lti.service.BusService;

@RestController
@CrossOrigin
public class BusController {
	@Autowired
	private BusService busService;
	
	@PostMapping("/addBus")
	public Status addbus(@RequestBody Bus bus) {
		try {
			busService.addBus(bus);
			Status status= new Status();
			status.setStatus(true);
			status.setMessage("Bus Added Successfully");
			return status;
		}
		catch(BusServiceException e) {
			Status status= new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}
