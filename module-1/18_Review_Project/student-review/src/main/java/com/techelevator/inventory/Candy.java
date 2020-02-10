package com.techelevator.inventory;

public class Candy extends Item {

	//hardcoding the sound because no matter which type of chips it is, the sound is the same
	public Candy(String name, double price) {
		super(name, price, "Munch Munch, Yum!");
	}

}
