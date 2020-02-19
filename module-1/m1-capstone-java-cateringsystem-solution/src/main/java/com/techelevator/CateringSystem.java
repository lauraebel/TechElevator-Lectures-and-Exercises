package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.techelevator.inventory.ShoppingCart;
import com.techelevator.inventory.CartItem;
import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.InventoryException;
import com.techelevator.inventory.Stock;
import com.techelevator.inventory.items.Item;
import com.techelevator.inventory.report.LogWriter;
import com.techelevator.inventory.report.SalesReportWriter;
import com.techelevator.inventory.report.TextLogWriter;
import com.techelevator.inventory.report.TextSalesReportWriter;
import com.techelevator.money.InvalidAmountException;
import com.techelevator.money.MoneyHandler;
import com.techelevator.money.denominations.Money;
import com.techelevator.transaction.TransactionResult;

public class CateringSystem {

	private final static int MAXIMUM_ALLOWED_BALANCE = 5000;
	
	private MoneyHandler moneyHandler;
	private Inventory inventory;
	private LogWriter log;
	private SalesReportWriter report;
	private ShoppingCart cart;
	
	public CateringSystem(Inventory inventory, MoneyHandler moneyHandler, LogWriter log, SalesReportWriter report) {
		this.inventory = inventory;
		this.moneyHandler = moneyHandler;
		this.log = log;
		this.report = report;
		cart = new ShoppingCart();
	}
	
	public Map<String, Stock> getStock() {
		return inventory.getStock();
	}
	
	public double getCustomerBalance() {
		return moneyHandler.getBalance();
	}
	
	public boolean addMoney(double amount) throws InvalidAmountException {
		
		double newBalance = amount + moneyHandler.getBalance();
		
		if (newBalance > MAXIMUM_ALLOWED_BALANCE) {
			throw new InvalidAmountException("Amount would exceed the maximum allowed balance of $" + MAXIMUM_ALLOWED_BALANCE, newBalance);
		}
		
		boolean wasSuccessful = moneyHandler.addMoney(amount);
		
		if (wasSuccessful) {
			log.write("ADD MONEY", amount, moneyHandler.getBalance());
		}
	
		return wasSuccessful;
	}
	
	public int getTotalItemsInCart() {
		return cart.getNumberOfItems();
	}
	
	public List<CartItem> getCartItems() {
		return cart.getItems();
	}
	
	public void addItemToCart(String itemCode, int quantity) throws InvalidAmountException, InventoryException {
		
		if (quantity < 1) {
			throw new InventoryException("Item selected with 0 quantity");
		}
		
		CartItem cartPeek = new CartItem(inventory.peekItemFromInventory(itemCode), quantity);
		double totalAmount = cartPeek.getTotalAmount();
		if (!moneyHandler.enoughBalanceForPurchase(totalAmount)) {
			throw new InvalidAmountException("Not enough balance remains to purchase items", totalAmount);
		}
		
		moneyHandler.removeMoney(totalAmount);
		
		CartItem cartItem;
		try {
			cartItem = new CartItem(inventory.getItemFromInventory(itemCode, quantity), quantity);
		} catch (InventoryException e) {
			// Revert the money back into the account
			moneyHandler.addMoney(totalAmount);
			throw e;
		}
		cart.add(cartItem);
	
		StringBuilder logMessage = new StringBuilder().append(cartItem.getQuantity())
			.append(" ").append(cartItem.getItem().getName())
			.append(" ").append(itemCode.toUpperCase());
		
		log.write(logMessage.toString(), cartItem.getTotalAmount(), moneyHandler.getBalance());
		
	}
	
	public TransactionResult endTransaction() {
		List<CartItem> purchasedItems = cart.clear();
		Map<Money, Integer> change = moneyHandler.cashOut();
		TransactionResult result = new TransactionResult(change, purchasedItems);
		
		log.write("GIVE CHANGE", result.getChangeTotal(), moneyHandler.getBalance());
		report.write(result);
		return result;
	}
	

	
}
