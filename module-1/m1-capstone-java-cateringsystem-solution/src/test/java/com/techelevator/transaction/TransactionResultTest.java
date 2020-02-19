package com.techelevator.transaction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.inventory.CartItem;
import com.techelevator.inventory.InventoryException;
import com.techelevator.inventory.items.Beverage;
import com.techelevator.inventory.items.Entree;
import com.techelevator.money.denominations.Dime;
import com.techelevator.money.denominations.FiveDollar;
import com.techelevator.money.denominations.Money;
import com.techelevator.money.denominations.Nickel;
import com.techelevator.money.denominations.OneDollar;
import com.techelevator.money.denominations.Quarter;
import com.techelevator.money.denominations.TenDollar;
import com.techelevator.money.denominations.TwentyDollar;

public class TransactionResultTest {


	@Test
	public void transaction_total_is_correct() throws InventoryException {
		List<CartItem> items = new ArrayList<CartItem>();
		items.add(new CartItem(new Beverage("TestBeverageOne", 1.50), 10));
		items.add(new CartItem(new Entree("TestEntreeOne", 2.55), 17));
		Map<Money, Integer> change = new LinkedHashMap<Money, Integer>();
		TransactionResult result = new TransactionResult(change, items);
		
		Assert.assertEquals(58.35, result.getTransactionTotal(), 2);
	}
	
	@Test
	public void transaction_total_is_correct_when_cart_empty() throws InventoryException {
		List<CartItem> items = new ArrayList<CartItem>();
		Map<Money, Integer> change = new LinkedHashMap<Money, Integer>();
		TransactionResult result = new TransactionResult(change, items);
		
		Assert.assertEquals(0.00, result.getTransactionTotal(), 2);
	}
	
	@Test
	public void transaction_change_total_is_correct() throws InventoryException {
		List<CartItem> items = new ArrayList<CartItem>();
		Map<Money, Integer> change = new LinkedHashMap<Money, Integer>();
		
		change.put(new TwentyDollar(), 2); 	// 40
		change.put(new TenDollar(), 1);  	// 50
		change.put(new FiveDollar(), 1); 	// 55
		change.put(new OneDollar(), 3);  	// 58
		change.put(new Quarter(), 2); 		// 58.50
		change.put(new Dime(), 1); 			// 58.60
		change.put(new Nickel(), 1); 		// 58.65
		
		TransactionResult result = new TransactionResult(change, items);
		
		Assert.assertEquals(58.65, result.getChangeTotal(), 2);
	}
	
	@Test
	public void transaction_change_total_is_correct_when_no_change() throws InventoryException {
		List<CartItem> items = new ArrayList<CartItem>();
		Map<Money, Integer> change = new LinkedHashMap<Money, Integer>();
		TransactionResult result = new TransactionResult(change, items);
		
		Assert.assertEquals(0.00, result.getChangeTotal(), 2);
	}
	
}
