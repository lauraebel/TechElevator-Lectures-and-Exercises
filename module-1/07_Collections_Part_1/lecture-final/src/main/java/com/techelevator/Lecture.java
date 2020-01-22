package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> instructors = new ArrayList<String>();
		
		// Add Strings to the list
		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Andrew");
		instructors.add("Carson");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// List maintain order of insertion
		
		for (int i = 0 ; i < instructors.size() ; i++) {
			System.out.println( instructors.get(i) );
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		instructors.add("John");
		
		for (int i = 0 ; i < instructors.size() ; i++) {
			System.out.println( instructors.get(i) );
		}
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		instructors.add(3, "Rachelle");
		
		for (int i = 0 ; i < instructors.size() ; i++) {
			System.out.println( instructors.get(i) );
		}
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		instructors.remove(5);
		
		for (int i = 0 ; i < instructors.size() ; i++) {
			System.out.println( instructors.get(i) );
		}
		
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		
		boolean isAndrewInList = instructors.contains("Andrew");
		System.out.println("Andrew is in the list: " + isAndrewInList);
		
		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] instructorsArray = instructors.toArray( new String[ instructors.size() ]);
		
		// Can also convert an Array into a List
		
		List<String> instructorsListFromArray = Arrays.asList( instructorsArray );
		
		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		Integer employees = new Integer(25);
		Integer piecesOfCake = new Integer("24");
		
		if ( employees > piecesOfCake ) {
			System.out.println("Burn the building down");
		}
		
		Integer objX = 10;
		int intY = 20;
		intY = objX + 5;
		objX = intY + 10;
	
		
		Double accountBalance = null;
		//double newBalance = accountBalance + 10;;
		

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		
		int xy = 40;
		numbers.add(xy);
		
		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for ( String name : instructors ) {
			System.out.println( name );
		}
		
		double[] doubles = new double[] { 2.5d, 3.5d, 3.14d, 1.2d, 42.0d };
		
		// Use forEach with Arrays as well as Collections and with Arrays can use primitives
		for (double d : doubles) {
			System.out.println(d);
		}
		
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();
		
		Queue<String> tasks = new LinkedList<String>();
		
		tasks.offer("Clean dishes");
		tasks.offer("Sweep floor");
		tasks.offer("Clean counter");
		tasks.offer("Scrub ceiling");
		
		
		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		
		while ( !tasks.isEmpty() ) {
			
			String nextTask = tasks.poll();
			System.out.println("Next Tasks is: " + nextTask);
			System.out.println("Queue size: " + tasks.size() );
			
			String taskAfterThat = tasks.peek();
			System.out.println("Queue size after peek: " + tasks.size() );
		}


		
		
		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		Stack<String> history = new Stack<String>();
		
		
		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		history.push("http://www.google.com");
		history.push("http://www.microsoft.com");
		history.push("http://www.stackoverflow.com");
		history.push("https://blog.codinghorror.com");
		history.push("https://dashboard.techelevator.com");
		
		////////////////////
		// POPPING THE STACK
		////////////////////
		while( !history.isEmpty() ) {
			String previousPage = history.pop();
			System.out.println("Previous Page: " + previousPage);
		}

		
		// A Stack can be used to reverse values
		int[] nums = { 10, 20, 30, 40 , 50 };
		
		Stack<Integer> numStack = new Stack<Integer>();
		
		for (int n: nums) {
			numStack.push(n);
		}
		
		int i = 0;
		while( !numStack.isEmpty() ) {
			int num = numStack.pop();
			nums[i] = num;
			i++;
			System.out.println( num );
		}
		
	}
}
