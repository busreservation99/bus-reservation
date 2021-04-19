package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bus_payment")
public class Payment {
// payment entity 
	@Id
	@GeneratedValue
	private int id;
	@Column(name="payment_mode")
	private String paymentMode;
	private double amount;
	
	@Column(name="transaction_id")
	private int transactionId;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "registration_id")
	private Registration registration; 
	 
	public int getId() {
		return id;
	}
		public void setId(int id) {
		this.id = id;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	
	
	
	
}
