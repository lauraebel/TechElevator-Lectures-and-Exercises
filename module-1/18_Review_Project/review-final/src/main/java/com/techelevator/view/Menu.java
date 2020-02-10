package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.techelevator.inventory.Slot;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public String getInventoryFileFromUser() {
//		out.print("Inventory file path >>>");
//		out.flush();
//		return in.nextLine();
		
		return "vendingmachine.csv";
	}
	
	public void showErrorMessage(String message) {
		out.println("****** " + message + " ******");
		out.flush();
	}
	
	public void displayInventory(Map<String, Slot> inventory) {
		for ( Entry<String, Slot> entry : inventory.entrySet()) {
			
			String quantity = entry.getValue().getCount() > 0 ? String.valueOf(entry.getValue().getCount()) : "Sold Out";
			
			// A1  Name  Price  Quantity
			System.out.printf("%-5s  %-20s  %4.2f  %-10s %n", 
					entry.getKey(),
					entry.getValue().getItem().getName(),
					entry.getValue().getItem().getPrice(),
					quantity );
			
		}
	}
	
	
	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
}
