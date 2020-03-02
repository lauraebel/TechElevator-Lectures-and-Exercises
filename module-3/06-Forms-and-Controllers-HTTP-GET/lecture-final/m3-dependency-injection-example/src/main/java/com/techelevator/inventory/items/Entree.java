package com.techelevator.inventory.items;

public class Entree extends Item {

	private final static String TYPE_ENTREE = "Entree";
	
	public Entree(String name, double price) {
		super(name, price, TYPE_ENTREE);
	}

}
