package com.lti.dto;

public class LoginStatus extends Status {

	private int registrationId;
	private String name;
	//private Customer customer;
	
	
	public String getName() {
		return name;
	}
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
