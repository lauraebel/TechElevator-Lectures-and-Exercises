package com.techelevator.shoppingcart;

public class ShoppingCart {

	private int totalNumberOfItems = 0;
	private double totalAmountOwed = 0.0;
	
	
	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}
	public double getTotalAmountOwed() {
		return totalAmountOwed;
	}
	
	public double getAveragePricePerItem() {
		if (totalNumberOfItems == 0) {
			return 0.0;
		}
		return totalAmountOwed / totalNumberOfItems;
	}
	
	public void empty() {
		totalNumberOfItems = 0;
		totalAmountOwed = 0.0;
	}
	
	public void addItems(int numberOfItems, double pricePerItem) {
		// Update total Number of items
		totalNumberOfItems += numberOfItems;
		// INcrease total amount owed by pricePerItem * numberOfItems
		totalAmountOwed += ( pricePerItem * numberOfItems );
	}
	
}
