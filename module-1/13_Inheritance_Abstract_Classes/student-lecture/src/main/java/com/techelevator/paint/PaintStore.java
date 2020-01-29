package com.techelevator.paint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintStore {

	public static void main(String[] args) {
		
		Scanner in = new Scanner( System.in );
		
		System.out.print("What size of area do you want to paint?");
		int area = in.nextInt();
		in.nextLine();
		
		List<Paint> paints = new ArrayList<Paint>();
		paints.add( new LatexPaint() );
		
		Paint interiorOil = new OilPaint(true);
		Paint exteriorOil = new OilPaint(false);
		paints.add(interiorOil);
		paints.add(exteriorOil);
		
		for (Paint paint : paints) {
			double cost = paint.calculateCost( area );
			System.out.println("The " + paint.getName() + " will cost $" + cost);
		}

	}

}
