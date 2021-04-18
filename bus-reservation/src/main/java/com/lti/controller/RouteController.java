package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RouteStatus;
import com.lti.dto.ScheduleStatus;
import com.lti.entity.Route;
import com.lti.entity.Schedule;
import com.lti.exception.RouteServiceException;
import com.lti.exception.ScheduleServiceException;
import com.lti.service.RouteService;

@RestController
@CrossOrigin
public class RouteController {

	//50% kaam khtm
	@Autowired
	private RouteService routeService;
	
	@PostMapping("/addRoute")
	public  RouteStatus addschedule(@RequestBody Route route) {
		try {
			int id=routeService.addRoute(route);
			RouteStatus status = new RouteStatus();
			status.setStatus(true);
			status.setMessage("Route added Successfully");
			status.setRouteId(id);
			return status;
		}
		catch(RouteServiceException e) {
			RouteStatus status= new RouteStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
}
