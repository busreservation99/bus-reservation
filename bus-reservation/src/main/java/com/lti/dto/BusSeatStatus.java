package com.lti.dto;

import com.lti.entity.BusSeat;

public class BusSeatStatus<String> extends Status{
	private int busNumber;
	
	private int noOfSeats;
	
	private BusSeat busSeat;
	
	

	public BusSeat getBusSeat() {
		return busSeat;
	}

	public void setBusSeat(BusSeat busSeat) {
		this.busSeat = busSeat;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}
	
}
