package com.lti.dto;

import java.util.List;

import com.lti.entity.Passenger;

public class PassengerStatus extends Status {

 private List<Passenger> passengers;
 
 private int passengerNumber;
 

 	public int getPassengerNumber() {
			return passengerNumber;
		}
		
		public void setPassengerNumber(int passengerNumber) {
			this.passengerNumber = passengerNumber;
		}
		
		public List<Passenger> getPassengers() {
			return passengers;
		}
		
		public void setPassengers(List<Passenger> passengers) {
			this.passengers = passengers;
		}
 	

}
