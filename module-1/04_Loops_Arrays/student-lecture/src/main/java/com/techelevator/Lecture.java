package com.techelevator;

public class Lecture {

    /*
    1. Return the created array
    */
//	   public int[] returnArray() {
//	        int[] array = { 80, 8080, 443 };
//	        return null;
//	    }
    public int[] returnArray() {
        int[] array = { 80, 8080, 443 };
        return array;
    }

    /*
    2. Return the first element of the array
    */
//    public int returnFirstElement() {
//        int[] portNumbers = { 80, 8080, 443 };
//        return 1;
//    }
    public int returnFirstElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers [0];
    }

    /*
    3. Return the last element of the array
    */
//    public int returnLastElement() {
//        int[] portNumbers = { 80, 8080, 443 };
//        return 1;
//    }
    public int returnLastElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers [2];
    }

    /*
    4. Return the first element of the array from the parameters
    */
//    public int returnFirstElementOfParam(int[] passedInArray) {
//        return 1;
//    }
    public int returnFirstElementOfParam(int[] passedInArray) {
        return passedInArray [0];
    }

    /*
    5. Return the last element of the array from the parameters
    */
//    public int returnLastElementOfParam(int[] passedInArray) {
//        return 1;
//    }
    public int returnLastElementOfParam(int[] passedInArray) {
        return passedInArray[passedInArray.length - 1];
    }
    
// in-class example below
    public void arrayExample() {
    	double[] numbers = new double[5];
    	
    	numbers[0] = 10.5;
    	numbers[1] = 4.6;
    	numbers[2] = 7.8;
    	numbers[3] = 3.2;
    	numbers[4] = 7.0;
    	
    	numbers[4] = numbers[3] + 10; //will change numbers[4] from 7.0 to 13.2
    }
    
    /*
    6. Here, a variable is defined within a block. How can we get the value of that outside of the block in order to
       return it? There are a couple of different ways of doing this, what can you come up with?
    */
    public int returnVariableFromBlock(int number) {
    	int result; //declare it here
        { // A new block with scoped variables
           result = number * 5;

        } // the result variable disappears here

        return result; // We want to return result here. How? - since it is declared outside the child block
    }

    /*
    7. What will the variable result be at the end of the method? Change the number in the logic expression so that
       it returns true.
    */
    public boolean returnOperationInBlock() {
        int result = 5;

        {
            int multiplier = 10;
            result *= multiplier;
        }

        return result == 50; // <-- Change the number to match result and make this be true
    }

    /*
    8. Return the only variable that is in scope at the return statement.
    */
    public double returnInScopeVariable() {
        double one = 1.0;
        {
            double three = 3.0;
            one += three;
            {
                double four = 4.0;
                three = four - one;
                one++;
            }

            double five = 5.0;
            double eight = five + three;
        }

        return one;
    }

    /*
    9. How many times do we go through this loop? Change the number in the logic expression so that it returns true.
    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = { 3, 4, 2, 9 };

        int counter = 0; // Must be started outside the block so that have access to it after the block

        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter++;
        }

        return counter == 1; // What should the number be to return true?
    }

    /*
    10. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCorrectCount() {
        int[] arrayToLoopThrough = { 4, 23, 9 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 1; i < arrayToLoopThrough.length; i++) {
            counter += 1;
        }

        return counter == 3;
    }

    /*
    11. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCountCorrectTimes() {
        int[] arrayToLoopThrough = { 4, 23, 9, 4, 33 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i <= arrayToLoopThrough.length; i++) {
            counter = counter + 1;
        }

        return counter == 5;
    }

    /*
    12. We want this loop to only count every other item starting at zero. What needs to change in the loop for
        it to do that?
    */
    public boolean returnSumEveryOtherNumber() {
        int[] arrayToLoopThrough = { 4, 3, 4, 1, 4, 6 };

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i = i + 1) {
            sum = sum + arrayToLoopThrough[i];
        }

        return sum == 12;
    }
}