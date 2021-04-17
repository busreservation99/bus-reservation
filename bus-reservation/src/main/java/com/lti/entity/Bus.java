package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bus_detail")
public class Bus {

	@Id
	@Column(name="bus_number")
	private int busNumber;
	
	@Column(name="bus_type")
	private String busType;
	
	@Column(name="bus_name")
	private String busName;
	
	private String source ;
	private String destination;
	
	@OneToMany(mappedBy = "bus")
	private List<Schedule> schedule;
	
	@OneToMany(mappedBy = "bus")
	private List<Booking> booking;
	
	@OneToMany(mappedBy = "bus")
	private List<BusSeat> busseats;
	

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public List<BusSeat> getBusseats() {
		return busseats;
	}

	public void setBusseats(List<BusSeat> busseats) {
		this.busseats = busseats;
	}


	
}
