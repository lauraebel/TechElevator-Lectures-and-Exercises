package com.techelevator.money;

public class InvalidAmountException extends Exception {

	private static final long serialVersionUID = -4998352410403476336L;
	private double newAmount;
	
	public InvalidAmountException(String message, double newAmount) {
		super(message);
		this.newAmount = newAmount;
	}
	
	public double getNewAmount() {
		return newAmount;
	}
	
}
