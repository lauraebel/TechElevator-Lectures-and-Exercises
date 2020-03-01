package com.techelevator.inventory;

public class InventoryException extends Exception {

	private static final long serialVersionUID = -1791236624925423371L;
	private String itemCode = "";
	private int quantityToRemove = 0;
	
	public InventoryException(String message) {
		super(message);
	}
	
	public InventoryException(String message, String itemCode, int quantityToRemove) {
		super(message);
		this.itemCode = itemCode;
		this.quantityToRemove = quantityToRemove;
	}

	public String getItemCode() {
		return itemCode;
	}

	public int getQuantityToRemove() {
		return quantityToRemove;
	}
	
	
}
