package com.techelevator.inventory;

/**
 * Superclass for Vending Machine items
 * 
 * 
 * @author brianlauvray
 *
 */
public class Item {

	private String name;
	private double price;
	private String sound;
	
	
	public Item(String name, double price, String sound) {
		this.name = name;
		this.price = price;
		this.sound = sound;
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}


	public String getSound() {
		return sound;
	}
	
	
	
}
