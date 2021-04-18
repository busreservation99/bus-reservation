package com.lti.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.entity.Bus;
import com.lti.entity.Schedule;
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
	
	@GetMapping("/fetchBus")
	public Status fetchAllBus(@RequestParam("source") String source, @RequestParam("destination") String destination ) {
		try {
			Status status= new Status();
			List<Bus> b=(List<Bus>)busService.fetchBus(source, destination);
			if(!b.isEmpty()) {
				status.setStatus(true);
				status.setMessage("Bus fetched Successfully");
			}
			else {
				status.setMessage("Sorry no buses found!!");
				return status;
			}
			return status;
		}
		catch(BusServiceException e) {
			
			Status status= new Status();
			status.setStatus(false);
			status.setMessage("Sorry no buses found!!");
			return status;
		}
	}
	
	

	/* Final working code for fetching Bus details */
	@GetMapping("/fetchBus3")
	public List<Schedule> fetchAllBus3(@RequestParam("source") String source, @RequestParam("destination") String destination, @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date ) {
		try {
			Status status= new Status();
			List<Schedule> b=(List<Schedule>)busService.fetchBus2(source, destination, date);
			if(!b.isEmpty()) {
				status.setStatus(true);
				status.setMessage("Bus fetched Successfully");
				return b;
			}
			else {
				status.setMessage("Sorry no buses found!!");
				return b;
			}
		}
		catch(BusServiceException e) {
			List<Schedule> b = null;
			Status status= new Status();
			status.setStatus(false);
			status.setMessage("Sorry no buses found!!");
			return b ;
		}
	}

}
