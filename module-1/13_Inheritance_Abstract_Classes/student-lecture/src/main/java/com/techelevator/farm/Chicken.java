package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!", 10);
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public String eat() {
		return "Chicken eating";
	}

}