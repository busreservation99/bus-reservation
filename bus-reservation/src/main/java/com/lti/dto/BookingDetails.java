package com.lti.dto;

import java.util.List;

import com.lti.entity.Passenger;
import com.lti.entity.Schedule;

public class BookingDetails {
	
	int scheduleId;
	
	List<Passenger> passengers;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
}
