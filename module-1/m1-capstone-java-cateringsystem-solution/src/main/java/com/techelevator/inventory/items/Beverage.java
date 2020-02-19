package com.techelevator.inventory.items;

public class Beverage extends Item {

	private final static String TYPE_BEVERAGE = "Beverage";
	
	public Beverage(String name, double price) {
		super(name, price, TYPE_BEVERAGE);
	}

}
