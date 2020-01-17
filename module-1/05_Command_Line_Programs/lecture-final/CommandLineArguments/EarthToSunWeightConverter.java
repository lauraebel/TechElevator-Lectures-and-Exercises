public class EarthToSunWeightConverter {

	/*
	 * String[] args contains arguments passed on the command like, for example, for 
	 * an application like git, if we typed git add -A, then git would be the program and 
	 * args would contain  args[0] = "add"  and args[1] = "-A".
	 * 
	 * This allows the user to give our program commands or feed it data from the terminal
	 * command line when they run it.
	 */
	public static void main(String[] args) {
		
		int sunGravity = 28;
		
		/*
		 * How could we display all the arguments passed into the args array?
		 */
		for (int i = 0 ; i < args.length; i++) {
			System.out.println("Argument " + i + " : " + args[i]);
		}
		
		/*
		 * How could we use those arguments in our calculator program?
		 */
		System.out.printf("%-15s    %-15s%n", "Earth (lbs)", "Sun (lbs)");
		System.out.println("--------------------------------");

		for (int i = 0 ; i < args.length; i++) {
			int earthWeight = Integer.parseInt(args[i]);
			int sunWeight = earthWeight * sunGravity;
			System.out.printf("%-15s    %-15s%n", earthWeight, sunWeight);
		}

	}

}