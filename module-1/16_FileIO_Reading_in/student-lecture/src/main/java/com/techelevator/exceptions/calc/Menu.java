package com.techelevator.exceptions.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private static Scanner in = new Scanner(System.in);
	
	public List<String> getValuesFromUser() {
		
		List<String> numbers = new ArrayList<String>();
		
		while (true) {
			System.out.print("Enter a value (enter=null value,N=null list,D=Done) >>>");
			String num = in.nextLine();
			if (num.equalsIgnoreCase("N")) {
				return null;
			}
			if (num.equalsIgnoreCase("D")) {
				break;
			}
			if (num.equals("")) {
				num = null;
			}

			numbers.add(num);
		}
		
		return numbers;
		
	}
	
	public void displayUserMessage(String message) {
		System.out.println(message);
		System.out.flush();
	}
	
}
