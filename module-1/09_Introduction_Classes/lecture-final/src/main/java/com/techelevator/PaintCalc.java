package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalc {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		List<Rectangle> walls = new ArrayList<Rectangle>();
		
		while (true) {

			System.out.println();
			System.out.println("[1] Add a wall");
			System.out.println("[2] Calculate paint required (and Exit)");
			System.out.print("Please choose >>> ");
			String userChoice = scan.nextLine();

			System.out.println();

			// When checking if a variable is equal to a string literal
			// it is best practice to check that the string variable is
			// equal to the string literal, as specified below. If we
			// said `userChoice.equals("1")` instead, what might happen if
			// userChoice is null?
			if ("1".equals(userChoice)) {

				System.out.print("Enter wall height >>> ");
				int height = Integer.parseInt(scan.nextLine());
				System.out.print("Enter wall width >>> ");
				int width = Integer.parseInt(scan.nextLine());
				
				Rectangle wall = new Rectangle(width, height);
			
				System.out.println("Added " + wall);
				
				walls.add(wall);

			} else if ("2".equals(userChoice)) {

				int totalArea = 0; 
				int count = 1;
				for (Rectangle wall : walls) {
					totalArea += wall.getArea();
					System.out.println("Wall " + count + ": " + wall);
					count++;
				}
				
				System.out.println("===============================");
				System.out.println("Total Area: " + totalArea + " square feet");

				// 1 gallon of paint covers 400 square feet
				float gallonsRequired = (float) totalArea / 400;
				System.out.println("Paint Required: " + gallonsRequired + " gallons");

				System.exit(0); // Causes the program to end
			}
		}
	}

}
