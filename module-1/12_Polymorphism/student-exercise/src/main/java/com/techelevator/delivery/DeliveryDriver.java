package com.techelevator.delivery;

public interface DeliveryDriver {
	
	String getName();
	double calculateRate(int distance, double weight);	

}
