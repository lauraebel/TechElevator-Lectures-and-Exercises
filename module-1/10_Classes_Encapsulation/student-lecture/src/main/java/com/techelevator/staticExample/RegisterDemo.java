package com.techelevator.staticExample;

import java.util.Scanner;

public class RegisterDemo {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		CashRegister registerOne = new CashRegister("One");
		CashRegister registerTwo = new CashRegister("Two");
		
		while (true) {
			
			System.out.print("Register (1) or (2) >>>");
			int registerSelected = in.nextInt();
			in.nextLine();
			
			System.out.print("Amount of Sale >>>");
			double saleAmount = in.nextDouble();
			in.nextLine();
			
			if (registerSelected == 1) {
				registerOne.makeSale(saleAmount);
			} else if (registerSelected == 2) {
				registerTwo.makeSale(saleAmount);
			} else {
				System.out.println("Invalid Register selection!  Try Again!");
				continue;
			}
			printBalance(registerOne, registerTwo);
		}
	}
	private static void printBalance(CashRegister one, CashRegister two) {
		
		System.out.println();
		
		System.out.printf("%-30s ", "Register " + one.getName());
		System.out.printf("%-30s ", "Register " + two.getName());
		System.out.printf("|%-30s %n", "Store");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.printf("%-15s %-15s", "Sales", "Balance");
		System.out.printf("%-15s %-15s", "Sales", "Balance");
		System.out.printf("|%-15s%-15s%n", "Sales", "Balance");
		
		System.out.printf("%-15s$%-15s", one.getRegisterTransactions(), one.getRegisterBalance());
		System.out.printf("%-15s$%-15s", two.getRegisterTransactions(), two.getRegisterBalance());
		System.out.printf("|%-15s$%-15s%n", CashRegister.getStoreTransactions(), CashRegister.getStoreBalance());
		
		System.out.println();
		
	}

}
