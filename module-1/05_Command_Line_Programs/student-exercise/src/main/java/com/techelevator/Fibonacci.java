package com.techelevator;
import java.util.Scanner;

// a+b=c
// b+c=d
// c+d=e

public class Fibonacci {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
	System.out.print("Please enter a whole number: ");
	String userInput = in.nextLine();
	
    int userInteger = Integer.parseInt(userInput);
    
    int a = 0;
    int b = 1;

		for (int i = 0; i <= userInteger; i++) {
			
			int sum = a + b;
			a = b;
			b = sum;
			
		if (sum <= userInteger) {
			System.out.print(sum + " , ");
		
		} else {
			break;
		}

}
}
}