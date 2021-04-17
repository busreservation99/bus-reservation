package com.lti.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bus_routes")
public class Route {

	@Id
	@GeneratedValue
	@Column(name="route_id")
	private int routeId;
	
	@Column(name="bus_stop_name")
	private String busStopName;
	
	private double fare;
	
	@Column(name="stop_arrival_time")
	private LocalTime stopArrivalTime;
	
	@Column(name="stop_departure_time")
	private LocalTime stopDepartureTime;
	
	@OneToOne
	@JoinColumn(name="bus_number")
	private Bus bus;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getBusStopName() {
		return busStopName;
	}

	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}


	public LocalTime getStopArrivalTime() {
		return stopArrivalTime;
	}

	public void setStopArrivalTime(LocalTime stopArrivalTime) {
		this.stopArrivalTime = stopArrivalTime;
	}

	public LocalTime getStopDepartureTime() {
		return stopDepartureTime;
	}

	public void setStopDepartureTime(LocalTime stopDepartureTime) {
		this.stopDepartureTime = stopDepartureTime;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
	
	
}
