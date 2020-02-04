package com.techelevator.filesplitter.view;

import java.util.Scanner;

public class Menu {
	
	private Scanner in = new Scanner(System.in);
	
	public String getPathFromUser() {
		System.out.print("Path to File: ");
		return in.nextLine();
	}
	
	public void displayMessage(String message) {
		System.out.println(message);
		System.out.flush();
	}
	public int getLineCountFromUser() {
		System.out.print("Lines to split: ");
		int lineCount = in.nextInt();
		in.nextLine();
		return lineCount;
		
				}
}
