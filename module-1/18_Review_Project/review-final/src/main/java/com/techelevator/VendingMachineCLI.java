package com.techelevator;

import java.io.FileNotFoundException;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCAHSE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCAHSE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCAHSE_MENU_FINISH_TRANSACTION };
	
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;
	private VendingMachine vendingMachine;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		
		
		String inventoryFile = menu.getInventoryFileFromUser();
		try {
			vendingMachine = new VendingMachine(inventoryFile);
		} catch (FileNotFoundException e) {
			menu.showErrorMessage( inventoryFile + " not found!");
			return;
		}
		
		
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				menu.displayInventory( vendingMachine.getInventory() );
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				showPurchaseMenu();
			}
		}
	}

	private void showPurchaseMenu() {
		
		while (true) {
			String choice = (String) menu.getChoiceFromOptions( PURCAHSE_MENU_OPTIONS );
			
			if (choice.equals(PURCHASE_MENU_FEED_MONEY)) {
				showFeedMoney();
			} else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
				
			} else if (choice.equals(PURCAHSE_MENU_FINISH_TRANSACTION)) {
				break;
			}
		}
	}
	
	private void showFeedMoney() {
		String[] testOptions = { "Feed Money", "Exit" } ;
		
		while (true) {
			String choice = (String) menu.getChoiceFromOptions( testOptions );
			
			if ( choice.equals("Feed Money")) {
				
			} else if (choice.equals("Exit")) {
				break;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
