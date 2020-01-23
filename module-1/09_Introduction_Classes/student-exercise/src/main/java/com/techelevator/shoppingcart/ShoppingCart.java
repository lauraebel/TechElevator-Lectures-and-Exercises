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
		//update total number of items
		totalNumberOfItems += numberOfItems;
		//increase total amount owed by priceperitem * numberofitems
		totalAmountOwed += (pricePerItem * numberOfItems);
	}
	
}
