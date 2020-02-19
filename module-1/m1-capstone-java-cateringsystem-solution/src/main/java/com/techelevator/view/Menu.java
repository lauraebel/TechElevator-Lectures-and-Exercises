package com.techelevator.view;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.techelevator.inventory.CartItem;
import com.techelevator.inventory.Stock;
import com.techelevator.money.denominations.Money;
import com.techelevator.transaction.TransactionResult;

public class Menu {

	private Scanner in = new Scanner(System.in);
	
	public String getUserInput(String question) {
		System.out.print(question);
		return in.nextLine();
	}
	
	public void showErrorMessage(String message) {
		displayMessage(message, true);
	}
	
	public void showMessage(String message) {
		displayMessage(message, false);
	}
	
	private void displayMessage(String message, boolean isError) {
		System.out.println();
		System.out.println( (isError ? "ERROR: " : "") + message);
		System.out.println();
	}
	
	public void displayStock(Map<String, Stock> stock) {
		
		System.out.println();
		
		System.out.printf("%-6s  %-25s  %-7s   %-10s%n", "Code", "Product", "Price", "Available");
		System.out.println("------------------------------------------------------");
		
		for (Entry<String, Stock> entry : stock.entrySet()) {
			
			System.out.printf("%-6s  %-25s  $%5.2f     %-10s%n", 
					entry.getKey(),
					entry.getValue().getItem().getName(),
					entry.getValue().getItem().getPrice(), 
					( entry.getValue().getQuantity() > 0 ? entry.getValue().getQuantity() : "SOLD OUT" )
			);
			
		}
		
		System.out.flush();
		
	}
	
	public void showTransactionEnd(TransactionResult result) {
		
		System.out.println();
		System.out.println("Your Invoice");
		showInvoice(result);
		showChange(result);
		System.out.println();
		System.out.println("Your transaction is complete.  Thank you for shopping with us!");
	}
	

	
	public int getChoiceFromMenu(String[] menuItems) {
		return getChoiceFromMenu(menuItems, null);
	}
	
	public int getChoiceFromMenu(String[] menuItems, String infoMessage) {
		
		int userChoice = 0;
		
		while (true) {
			System.out.println();
			for (int i = 0; i < menuItems.length; i++) {
				System.out.printf("(%1s) %-20s%n", (i + 1), menuItems[i] );
			}
			if (infoMessage != null) {
				System.out.println(infoMessage);
			}
			System.out.print("Select >>>");
			String choice = in.nextLine();
			
			try {
				userChoice = Integer.parseInt(choice) - 1;
			} catch (NumberFormatException e) {
				showInvalidChoiceError();
				continue;
			}
			
			if (userChoice < 0 || userChoice >= menuItems.length) {
				showInvalidChoiceError();
				continue;
			}
			
			break;	
		}
		return userChoice;
	}
	
	private void showInvalidChoiceError() {
		System.out.println("Invalid choice!  Please make another selection.");
		System.out.println();
	}
	
	private void showChange(TransactionResult result) {
		
		System.out.printf("Total change: $%-8.2f%n%nChange returned as%n", result.getChangeTotal());
		
		for (Entry<Money, Integer> money : result.getChange().entrySet()) {
			System.out.printf("%-4s %-15s%n", money.getValue(), money.getKey().getDisplayName(money.getValue()));
		}
		
	}
	
	private void showInvoice(TransactionResult result) {
		System.out.printf("%n%-8s  %-30s  %-6s  %-8s %n",
				"Quantity", "Item", "Price", "Total");
		
		System.out.println("-------------------------------------------------------------");
		
		for (CartItem item : result.getPurchasedItems()) {
			System.out.printf("%-8s  %-30s  $%-5.2f  $%-7.2f %n", 
					item.getQuantity(), 
					item.getItem().getName(), 
					item.getItem().getPrice(), 
					item.getTotalAmount());
		}
		
		System.out.printf("%nTotal: $%-10.2f%n", result.getTransactionTotal());
	}
	
}
