package com.techelevator.farm;

public class Sheep extends FarmAnimal {

	public Sheep() {
		super("Sheep", "Baa!", 150);
	}

	@Override
	public String eat() {
		return "Sheep eating";
	}

}
