package com.techelevator.inventory.report;

public class SalesReportEntry {

	private int quantity = 0;
	private double cost = 0;
	
	public SalesReportEntry(int quantity, double cost) {
		this.quantity = quantity;
		this.cost = cost;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public double getCost() {
		return cost;
	}

	
	public void addToCost(double costToAdd) {
		this.cost += costToAdd;
	}
	
	public void addToQuantity(double quantityToAdd) {
		this.quantity += quantityToAdd;
	}
	
}
