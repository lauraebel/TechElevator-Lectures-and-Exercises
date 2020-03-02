package com.techelevator.inventory.items;

public class Dessert extends Item {

	private final static String TYPE_DESSERT = "Dessert";
	
	public Dessert(String name, double price) {
		super(name, price, TYPE_DESSERT);
	}

}
