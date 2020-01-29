package com.techelevator.farm;

public class Cow extends FarmAnimal implements Milkable {

	public Cow() {
		super("Cow", "moo!", 2000);
	}

	@Override
	public int milk() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return "Cow eating";
	}

}