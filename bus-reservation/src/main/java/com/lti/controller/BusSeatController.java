package com.lti.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BusSeatStatus;
import com.lti.dto.ScheduleStatus;
import com.lti.entity.BusSeat;
import com.lti.exception.BusSeatServiceException;
import com.lti.exception.ScheduleServiceException;
import com.lti.service.BusSeatService;

@CrossOrigin
@RestController
public class BusSeatController {
	
	@Autowired
	private BusSeatService busSeatService;
	
	@PostMapping("/addSeats")
	public BusSeatStatus addSeats(@RequestBody BusSeatStatus busSeatStatus) {
		try {
			int id=busSeatService.addSeatsForBus(busSeatStatus.getBusSeat(), busSeatStatus.getNoOfSeats());
			BusSeatStatus status = new BusSeatStatus();
			status.setStatus(true);
			status.setMessage("Seat added Successfully");
			status.setBusNumber(id);
			status.setBusSeat(busSeatStatus.getBusSeat());
			return status;
		}
		catch(BusSeatServiceException e) {
			BusSeatStatus status= new BusSeatStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	
	}
	
	@GetMapping("/getSeatStatus")
	public List getseatStatus(@RequestParam("busno")int bus,@RequestParam("schedule")int schedule) {
		List seatsS=busSeatService.getBusSeatStatus(bus, schedule);
		return seatsS;
	}
}
