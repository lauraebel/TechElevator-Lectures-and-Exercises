package com.techelevator.inventory;

//superclass for vending machine items

public class Item {
	
	private String name;
	private double price;
	private String sound;
	
	//constructor - we do not want these to be able to change once set so constructor instead of setters
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
