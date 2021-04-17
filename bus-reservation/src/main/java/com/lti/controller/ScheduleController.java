package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RegisterStatus;
import com.lti.dto.ScheduleStatus;
import com.lti.entity.Registration;
import com.lti.entity.Schedule;
import com.lti.exception.RegistrationServiceException;
import com.lti.exception.ScheduleServiceException;
import com.lti.service.ScheduleService;

@RestController
@CrossOrigin
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping("/addSchedule")
	public  ScheduleStatus addschedule(@RequestBody Schedule schedule) {
		try {
			int id=scheduleService.addschedule(schedule);
			ScheduleStatus status = new ScheduleStatus();
			status.setStatus(true);
			status.setMessage("Schedule added Successfully");
			status.setScheduleId(id);
			return status;
		}
		catch(ScheduleServiceException e) {
			ScheduleStatus status= new ScheduleStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}
