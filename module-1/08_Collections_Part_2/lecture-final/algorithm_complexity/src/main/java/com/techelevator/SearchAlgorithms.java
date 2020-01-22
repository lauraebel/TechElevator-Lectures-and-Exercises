package com.techelevator;

import java.util.Arrays;

public class SearchAlgorithms {
 
    /*
    Given an integer array, return the array sorted lowest to highest.
    CHALLENGE: Write the Sort algorithm, don't use the .Sort() method provided to an array. 
    arraySort([8, 13, 9, 12]) → [8, 9, 12, 13]        
    
    NOTE: There is now a test case with 100,000 random numbers including a lot of duplicates
          some sort algorithms will not perform well - compare Bubble Sort to Counting Sort
          
         Visualizations of types of sorts:  https://visualgo.net/bn/sorting
    */
    
    
    /* 
     * Solution with Optimized Bubble Sort
     * Time Complexity: O(n^n)
     * Space Complexity: O(1)
     */
    public int[] arraySortOptimizedBubbleSort(int[] nums) {
    	
    	boolean change = true;
    	int tmp = 0;
    	int pos = 0;
    	
    	while (change) {
    		change = false;
    		pos++;
    		for (int i = 0; i < nums.length - pos; i++) {
    			if (nums[i] > nums[i + 1]) {
    				tmp = nums[i];
    				nums[i] = nums[i + 1];
    				nums[i + 1] = tmp;
    				change = true;
    			}
    		}
    	}
    
    	return nums;
    }
    
    /* 
     * Solution with Insertion Sort
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int[] arraySortInsertionSort(int[] nums) {
    	
        for (int i = 1; i < nums.length; i++) { 
        	// Get the value at the current position
            int current = nums[i]; 
            int j = i - 1;
            
            // Move elements before the current position that 
            // are greater than the current number, 1 position ahead
            while (j >= 0 && nums[j] > current) {
            	nums[j + 1] = nums[j];
                j = j - 1;
            }
            // Set original value to its new position
            nums[j + 1] = current; 
        }

    	return nums;
    }
   
    
    /*
     * Solution using Counting Sort
     * https://brilliant.org/wiki/counting-sort/
     * Time complexity:  O(k + n)
     * Space complexity: O(k + n)
     */
    public int[] arraySortCountingSort(int[] nums) {
    	
    	// Get the Maximum value in the Array
    	int maxValue = Arrays.stream(nums).max().getAsInt();
    	
    	// Build an Array for the Sorted
    	int[] sorted = new int[nums.length];
    	
    	// Build the Intermediate Array used for the initial sort
    	// It is 1 larger than than the maxValue to allow the Max Value to be used as an index, otherwise
    	// we have to -1 everything.
    	int[] temp = new int[maxValue + 1];
    	
    	// Populate the Intermediate Array, this provides the initial sort, where
    	// there are duplicates the count is increased for that number
    	for (int num : nums) {
    		temp[num] = temp[num] + 1;
    	}
    	
    	// Determine the ranges each number will need, to allow for duplicates
    	int lastValue = 0;
    	for (int i = 0 ; i < temp.length; i++) {
    		int currentValue = temp[i] + lastValue;
    		temp[i] = currentValue;
    		lastValue = currentValue;
    	}
    	
    	// Go through the original array and for each number, the intermediate array's count for that
    	// number will tell us an index to use for that number
    	for (int num : nums) {
    		sorted[temp[num] - 1] = num;
    		// Once a number is placed reduce its count by 1, so duplicates will be placed in the 
    		// appropriate indexes in the range. 
    		temp[num] = temp[num] - 1;
    	}
    	
        return sorted;
    }

    /*
     * Solution using Merge Sort
     * Time complexity:  O(n log n)
     * Space complexity: O(n)
     */
    public int[] arraySortMergeSort(int[] nums) {
    	// Merge Sort is recursive, so we start the search by
    	// passing it the Array and the current length
    	mergeSort(nums, nums.length);
    	return nums;
    }
    
    // MergeSort uses a divide and conquer technique, meaning it
    // splits the input into half and then sorts the halves
	public void mergeSort(int[] arr, int arrLength) {
		
		// If the length is 1, then return it
	    if (arrLength < 2) {
	        return;
	    }
	    
	    // Find the mid point in the array
	    int mid = arrLength / 2;
	    // Create 2 new Arrays to hold the halves
	    int[] left = new int[mid];
	    int[] right = new int[arrLength - mid];
	 
	    // Populate the left half with values from 0 to the mid point
	    for (int i = 0; i < mid; i++) {
	        left[i] = arr[i];
	    }
	    
	    // Populate the Right with values from the mid point to the end of the Array
	    for (int i = mid; i < arrLength; i++) {
	        right[i - mid] = arr[i];
	    }
	    
	    // Recursively call mergeSort on the left Half
	    mergeSort(left, mid);
	    
	    // Recursively call mergeSort on the right half
	    mergeSort(right, arrLength - mid);
	 
	    // Call the merge method put things back together
	    merge(arr, left, right, mid, arrLength - mid);
	}
    
	public void merge(
	  int[] arr, int[] leftArr, int[] rightArr, int leftLength, int rightLength) {
	  
	    int i = 0, j = 0, k = 0;
	    
	    // Compare the 2 halves and put the smaller values back in the main array at
	    // the starting position
	    while (i < leftLength && j < rightLength) {
	        if (leftArr[i] <= rightArr[j]) {
	            arr[k++] = leftArr[i++];
	        }
	        else {
	            arr[k++] = rightArr[j++];
	        }
	    }
	    
	    // populate the rest of the array with the remaining values from the left then the right arrays
	    while (i < leftLength) {
	        arr[k++] = leftArr[i++];
	    }
	    while (j < rightLength) {
	        arr[k++] = rightArr[j++];
	    }
	}
	
	
//    public int[] arraySort(int[] nums) {
//    	return nums;
//    }
	
}
