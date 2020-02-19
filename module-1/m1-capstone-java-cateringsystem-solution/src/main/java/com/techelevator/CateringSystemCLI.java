package com.techelevator;

import java.io.File;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.InventoryException;
import com.techelevator.inventory.reader.CsvInventoryReader;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.inventory.reader.InventoryReaderException;
import com.techelevator.inventory.report.FileWriteException;
import com.techelevator.inventory.report.LogWriter;
import com.techelevator.inventory.report.SalesReportWriter;
import com.techelevator.inventory.report.TextLogWriter;
import com.techelevator.inventory.report.TextSalesReportWriter;
import com.techelevator.money.ChangeMaker;
import com.techelevator.money.InvalidAmountException;
import com.techelevator.money.MoneyHandler;
import com.techelevator.money.denominations.Dime;
import com.techelevator.money.denominations.FiveDollar;
import com.techelevator.money.denominations.Money;
import com.techelevator.money.denominations.Nickel;
import com.techelevator.money.denominations.OneDollar;
import com.techelevator.money.denominations.Quarter;
import com.techelevator.money.denominations.TenDollar;
import com.techelevator.money.denominations.TwentyDollar;
import com.techelevator.transaction.TransactionResult;
import com.techelevator.view.Menu;

/**
 * Handles the user workflow of the Application
 * @author Brian
 *
 */
public class CateringSystemCLI {

	private static final Money[] monies = new Money[] { new TwentyDollar(), new TenDollar(), new FiveDollar(), new OneDollar(), new Quarter(), new Dime(), new Nickel() };
	
	private final static int MAIN_MENU_DISPLAY_ITEMS = 0;
	private final static int MAIN_MENU_ORDER = 1;
	private final static int MAIN_MENU_QUIT = 2;
	private final static String[] MAIN_MENU = { "Display Catering Items", "Order", "Quit" };
	
	
	private final static int PURCHASE_MENU_ADD_MONEY = 0;
	private final static int PURCHASE_MENU_SELECT_PRODUCTS = 1;
	private final static int PURCHASE_MENU_COMPLETE_TRANSACTION = 2;
	private final static String[] PURCHASE_MENU = { "Add Money", "Select Products", "Complete Transaction" };
	
	private Menu menu;
	private CateringSystem cateringSystem;
	
	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	/**
	 * Starts the Catering System Command Line Interface application, by creating the 
	 * catering system and displaying the first menu.
	 */
	public void run() {	
		this.cateringSystem = getCateringSystem();
		
		boolean running = true;
		while (running) {
			int choice = menu.getChoiceFromMenu(MAIN_MENU);
			switch (choice) {
				case MAIN_MENU_DISPLAY_ITEMS:
					displayItems();
					break;
				case MAIN_MENU_ORDER:
					showPurchaseMenu();
					break;
				case MAIN_MENU_QUIT:
					running = false;
					break;
			}			
			
		}
	}
	
	private void showPurchaseMenu() {
		boolean running = true;
		while (running) {
			String customerBalanceDisplay = String.format("Current Account Balance: $%-7.2f", cateringSystem.getCustomerBalance());
			int choice = menu.getChoiceFromMenu(PURCHASE_MENU, customerBalanceDisplay);
			switch (choice) {
				case PURCHASE_MENU_ADD_MONEY:
					addMoney();
					break;
				case PURCHASE_MENU_SELECT_PRODUCTS:
					selectProducts();
					break;
				case PURCHASE_MENU_COMPLETE_TRANSACTION: 
					endTransaction();
					running = false;
					break;
			}
		}
	}
	
	private void endTransaction() {
		TransactionResult results = cateringSystem.endTransaction();
		menu.showTransactionEnd(results);
	}
	
	private void selectProducts() {
		displayItems();
		
		while (true) {
			
			String itemCode = menu.getUserInput("Select product to purchase >>>");
			String quantityInput = menu.getUserInput("Select quantity >>>");
			int quantity = 0;
			
			try {
				quantity = Integer.parseInt(quantityInput);
			} catch (NumberFormatException e) {
				menu.showMessage("Invalid Quantity.");
				continue;
			}
			
			try {
				cateringSystem.addItemToCart(itemCode, quantity);
			} catch (InventoryException e) {
				menu.showMessage(e.getMessage());
				continue;
			} catch (InvalidAmountException e) {
				menu.showMessage(e.getMessage());
			}
			
			break;
		}
	}
	
	private void addMoney() {
		
		while (true) {
			String amountInput = menu.getUserInput("Amount to add >>>");
			
			try {
				int amount = Integer.parseInt(amountInput);
				
				if (!cateringSystem.addMoney(amount)) {
					menu.showMessage("Cannot add negative amount");
					continue;
				}
			} catch (NumberFormatException e) {
				menu.showMessage("Invalid Amount.");
				continue;
			} catch (InvalidAmountException e) {
				menu.showMessage(e.getMessage());
				continue;
			}
			
			break;
		}
		
	}
	
	private void displayItems() {
		menu.displayStock( cateringSystem.getStock() );
	}

	private CateringSystem getCateringSystem() {
		
		Inventory inventory = null;
		
		while (inventory == null) {
			File inventoryFile = null;
			
			//String inventoryPath = menu.getUserInput("Path to inventory file >>>");
			//TODO: remove hard coded path to inventory file
			String inventoryPath = "cateringsystem.csv";
			
			inventoryFile = new File(inventoryPath);
			InventoryReader reader = new CsvInventoryReader(inventoryFile);
		
			try {
				inventory = new Inventory(reader);
			} catch (InventoryReaderException e) {
				menu.showErrorMessage("Invalid file!  Please try again.");
				inventory = null;
			}
		}
		
		return new CateringSystem( 
				inventory,  
				new MoneyHandler(new ChangeMaker(monies)),
				new TextLogWriter("Log.txt"), 
				new TextSalesReportWriter("TotalSales.rpt"));
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		try {
			cli.run();
		} catch (FileWriteException e) {
			menu.showErrorMessage(e.getMessage());
			System.exit(1);
		} 
//		catch (Exception e) {
//			menu.showErrorMessage("Unexpected error: " + e.getMessage());
//			System.exit(1);
//		}
	}
}
