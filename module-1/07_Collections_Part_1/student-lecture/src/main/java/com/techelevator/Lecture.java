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
		
		// Had errors on List and ArrayList at first because we had to import them above
		List<String> instructors = new ArrayList<String>();
		
		// Now time to add data - Add strings to the list
		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Andrew");
		instructors.add("Carson");
		

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// Lists maintain order of insertion
		for (int i = 0; i < instructors.size(); i++) {
			System.out.println(instructors.get(i)); //prints all instructors we added
		}
		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		 
		
		instructors.add("John");
		
		for (int i = 0; i < instructors.size(); i++) {
			System.out.println(instructors.get(i));
		}
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		instructors.add(3, "Rachelle");
		// adds Rachelle to index 3 and moves John and Carson down
		
		for (int i = 0; i < instructors.size(); i++) {
			System.out.println(instructors.get(i));
		}
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		instructors.remove(5);
		
		for (int i = 0; i < instructors.size(); i++) {
			System.out.println(instructors.get(i));
		}
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		boolean isAndrewInList = instructors.contains("Andrew");
		System.out.println("Andrew is in the list: " + isAndrewInList);
		// the above returns true since Andrew is in the list we originally made
		// Contains is CASE SENSITIVE!
		
		
		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] instructorsArray = instructors.toArray(new String[instructors.size ()]);
		
		// Can also convert an array into a list (more common)
		
		List<String> instructorsListFromArray = Arrays.asList(instructorsArray);
		// Array is capital since it is a wrapper class
		
		
		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		
		Integer employees = new Integer(25);
		// This is boxing ^
		
		Integer piecesOfCake = new Integer("24");
		// Integer can parse into a String for you^
		
		if (employees > piecesOfCake) {
			System.out.println("Burn the building down");
		}
		// The > usually can't work here because it can only work on primitive but here it's possible because of autoboxing
		
		
		Integer objectX = 10;
		int intY = 20;
		intY = objectX + 5;
		// Assigns an int (10) to the wrapper class of Integer - autoboxes and then can solve the problem
		
		
		// Double accountBalance = null; // no reference in the stack
		// double newBalance = accountBalance + 10;
		// Won't autobox because of the null- there is nothing to reference and box (null pointer exception)
		
		
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
		
		for(String name : instructors) {
			System.out.println(name);
		}

		double[] doubles = new double[] {2.5d, 8.6d, 5.2d};
		for(double d : doubles) {
			System.out.println(d);
		}
		
		// Can use forEach with Arrays as well as Collections, and with Arrays, can use primitives
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();
		
		Queue<String> tasks = new LinkedList<String>();
		
		tasks.offer("Clean Dishes");
		tasks.offer("Sweep");
		tasks.offer("Wipe Counters");
		tasks.offer("Mop");
		
		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		
//		for( ; tasks.isEmpty() != true ; ) {
//			
//		}
		// This is unnecessary
		
		while (tasks.isEmpty() != true) {
		
			String nextTask = tasks.poll();
			System.out.println("Next Task Is: " + nextTask);
			System.out.println("Queue Size Is Now: " + tasks.size());
			
			String taskAfterThat = tasks.peek();
			System.out.println("Queue Size After Peek: " + tasks.size());
	}
		
		
		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();
		
		Stack<String> history = new Stack<String>();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////

		history.push("google.com");
		history.push("yahoo.com");
		history.push("facebook.com");
		history.push("stackoverflow.com");
		history.push("blog.codinghorror.com");
		
		
		////////////////////
		// POPPING THE STACK
		////////////////////
		
		while (!history.isEmpty() ) {
			String previousPage = history.pop();
			System.out.println("Previous Page: " + previousPage);
		}
		
		// A stack can be used to reverse values
		int [] nums = {10, 20, 30, 40, 50};
		
		Stack<Integer> numStack = new Stack<Integer>();
		
		for (int n: nums) {
			numStack.push(n);
		}
		int i = 0;
		while(!numStack.isEmpty()) {
			int num = numStack.pop();
			nums[i] = num;
			i++;
			System.out.println(num);
		}

	}
}
