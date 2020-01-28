package com.techelevator.farm;

public class MusicBox implements Singable, Sellable {

	@Override
	public int getPrice() {
		return 25;
	}

	@Override
	public String getSound() {
		return "Duh Duh Doo";
	}

	@Override
	public String getName() {
		return "Music Box";
	}
	
	

}
