package com.techelevator.transaction;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.techelevator.inventory.CartItem;
import com.techelevator.money.denominations.Money;

public class TransactionResult {

	private Map<Money, Integer> change;
	private List<CartItem> purchasedItems;
	
	public TransactionResult(Map<Money, Integer> change, List<CartItem> purchasedItems) {
		this.change = change;
		this.purchasedItems = purchasedItems;
	}

	public Map<Money, Integer> getChange() {
		return change;
	}

	public List<CartItem> getPurchasedItems() {
		return purchasedItems;
	}
	
	public double getTransactionTotal() {
		double total = 0;
		
		for (CartItem item : purchasedItems) {
			double amt = item.getTotalAmount();
			total += amt;
		}
		return total;
	}
	
	public double getChangeTotal() {
		int total = 0;
		
		for (Entry<Money, Integer> entry : change.entrySet()) {
			int moneyAmt = entry.getKey().getValue() * entry.getValue();
			total += moneyAmt;
		}
		
		return total / 100d;
	}
	
	
}
