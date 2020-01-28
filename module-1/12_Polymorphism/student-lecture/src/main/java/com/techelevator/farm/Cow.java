package com.techelevator.farm;

public class Cow extends FarmAnimal implements Milkable {

	public Cow() {
		super("Cow", "moo!", 2000);
	}

	@Override
	public int milk() {
		return 0;
	}

}