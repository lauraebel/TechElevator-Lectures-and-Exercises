package com.techelevator.paint;

public abstract class Paint {

	public abstract String getName();
	public abstract double calculateCost(int area);
	
	protected double getCostOfPaintForArea(int area, int costPerGallon) {
		return (area / 600) * costPerGallon;
	}
}
