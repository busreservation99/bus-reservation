package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="bus_schedule")
public class Schedule {

	@Id
	@GeneratedValue
	@Column(name="schedule_id")
	private int scheduleId;
	
	@Column(name="bus_arrival_date")
	private LocalDate busArrivalDate;
	
	@Column(name="bus_departure_date")
	private LocalDate busDepartureDate;
	
	@Column(name="arrival_time")
	@JsonFormat(pattern = "hh:mm:ss a")
	private String arrivalTime;
	
	@Column(name="departure_time")
	@JsonFormat(pattern = "hh:mm:ss a")
	private String departureTime;
	
	
	@ManyToOne
	@JoinColumn(name="bus_number")
	private Bus bus;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}


	public LocalDate getBusArrivalDate() {
		return busArrivalDate;
	}

	public void setBusArrivalDate(LocalDate busArrivalDate) {
		this.busArrivalDate = busArrivalDate;
	}

	public LocalDate getBusDepartureDate() {
		return busDepartureDate;
	}

	public void setBusDepartureDate(LocalDate busDepartureDate) {
		this.busDepartureDate = busDepartureDate;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	
	
	
}
