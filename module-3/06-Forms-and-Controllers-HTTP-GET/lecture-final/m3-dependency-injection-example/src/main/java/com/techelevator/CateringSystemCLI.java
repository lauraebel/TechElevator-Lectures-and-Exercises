package com.techelevator;

import java.io.File;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.reader.CsvInventoryReader;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.inventory.reader.InventoryReaderException;
import com.techelevator.inventory.reader.JdbcInventoryReader;
import com.techelevator.view.Menu;


public class CateringSystemCLI {

	private final static int MAIN_MENU_DISPLAY_ITEMS = 0;
	private final static int MAIN_MENU_ORDER = 1;
	private final static int MAIN_MENU_QUIT = 2;
	private final static String[] MAIN_MENU = { "Display Catering Items", "Order", "Quit" };
	
	
	private Menu menu;
	private CateringSystem cateringSystem;
	
	public CateringSystemCLI(Menu menu, CateringSystem cateringSystem) {
		this.menu = menu;
		this.cateringSystem = cateringSystem;
	}


	public void run() {	

		while (true) {
			int choice = menu.getChoiceFromMenu(MAIN_MENU);
			if (choice == MAIN_MENU_DISPLAY_ITEMS) {
				menu.displayStock( cateringSystem.getStock() );
			} else if (choice == MAIN_MENU_ORDER) {
				menu.showErrorMessage("Not Implemented");
			} else if (choice == MAIN_MENU_QUIT) {
				break;
			} else {
				menu.showErrorMessage("Invlid selection!");
			}
			
		}
	}
	

	
	public static void main(String[] args) throws InventoryReaderException {
		Menu menu = new Menu();
		
		//InventoryReader reader = new CsvInventoryReader(getInventoryFile() );
	
		InventoryReader reader = new JdbcInventoryReader( getDataSource() );
		
		Inventory inventory = new Inventory(reader);
		CateringSystem cateringSystem = new CateringSystem(inventory);
		
		CateringSystemCLI cli = new CateringSystemCLI(menu, cateringSystem);
		cli.run();

	}
	
	
	private static File getInventoryFile() {
		String inventoryPath = "cateringsystem.csv";
		File inventoryFile = new File(inventoryPath);
		return inventoryFile;
	}
	
	
	private static DataSource getDataSource() {
		BasicDataSource cateringSystemDataSource = new BasicDataSource();
		cateringSystemDataSource.setUrl("jdbc:postgresql://localhost:5432/cateringsystem");
		cateringSystemDataSource.setUsername("postgres");
		cateringSystemDataSource.setPassword("postgres1");
		return cateringSystemDataSource;
	}
	
}
