package com.techelevator.farm;

public abstract class FarmAnimal implements Singable, Sellable {
	
	private String name;
	private String sound;
	private int price;
	private boolean sleeping = false;
	
	public FarmAnimal(String name, String sound, int price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	public abstract String eat();
	
	public String getName() {
		return name;
	}

	public final String getSound() {
		if (sleeping) {
			return "Zzzzzzz";
		}
		return sound;
	}
	
	public int getPrice() {
		return price;
	}
	
	public boolean isSleeping() {
		return sleeping;
	}
	
	public void wakeUp() {
		sleeping = false;
	}
	
	public void sleep() {
		sleeping = true;
	}

}