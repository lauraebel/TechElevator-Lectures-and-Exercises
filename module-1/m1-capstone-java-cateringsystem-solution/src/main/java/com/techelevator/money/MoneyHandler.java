package com.techelevator.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.techelevator.money.denominations.Money;

public class MoneyHandler {

	private BigDecimal balance;

	private ChangeMaker changeMaker;
	
	public MoneyHandler(ChangeMaker changeMaker) {
		this.changeMaker = changeMaker;
		resetBalance();
	}
	
	public double getBalance() {
		return balance.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	public boolean enoughBalanceForPurchase(double purchaseAmount) {
		return balance.subtract(new BigDecimal(purchaseAmount)).compareTo(BigDecimal.ZERO) >= 0;
	}
	
	public boolean removeMoney(double amount) {
		if (amount >= 0 && enoughBalanceForPurchase(amount)) {
			balance = balance.subtract(new BigDecimal(amount));
			return true;
		}
		return false;
	}
	
	
	public boolean addMoney(double amount) {
		
		if (amount < 0) {
			return false;
		}
		
		balance = balance.add(new BigDecimal(amount));
		return true;
	}
	
	public Map<Money, Integer> cashOut() {
		Map<Money, Integer> change = changeMaker.makeChange(balance.setScale(2, RoundingMode.HALF_UP).doubleValue());
		resetBalance();
		return change;	
	}
	
	private void resetBalance() {
		balance = BigDecimal.ZERO;
	}
	
	
	
}
