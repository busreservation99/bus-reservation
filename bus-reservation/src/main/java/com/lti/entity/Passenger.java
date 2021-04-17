package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bus_passenger")
public class Passenger {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Column(name="phone_number")
	private double phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	@OneToOne
	@JoinColumn(name="seat_id")
	private BusSeat seatId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public BusSeat getSeatId() {
		return seatId;
	}

	public void setSeatId(BusSeat seatId) {
		this.seatId = seatId;
	}
	
	
}
