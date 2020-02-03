package com.techelevator.exceptions.trashcan;


import java.io.IOException;

public class Trashcan {

	private int items;
	
	public boolean addItems(int number) {
		
		if (items + number > 5) {
			return false;
		}
		items += number;
		return true;
	}
	
	public void putItemsOnTop(int number) throws IOException {
		throw new IOException("Putting Items on top never works... an item fell off!");
	}
	
	public void pushItemsIn(int number) throws IOException {
		if (items + number > 10) {
			throw new IOException("Too many items to push in... items now on top, which never works so one fell off!");
		}
		items += number;
	}
	
	
}