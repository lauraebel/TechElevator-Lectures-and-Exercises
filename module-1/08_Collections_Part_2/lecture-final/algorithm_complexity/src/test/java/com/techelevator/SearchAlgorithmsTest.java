package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchAlgorithmsTest {
	
	private static final int ARRAY_SIZE = 100000;
	
	SearchAlgorithms searchAlgorithms = new SearchAlgorithms();

//	@Test
//    public void arraySort() {
//		assertArrayEquals("Input: {8, 13, 9, 12})", new int[]{8, 9, 12, 13}, exercises.arraySort(new int[]{8, 13, 9, 12}));
//		assertArrayEquals("Input: {4, 0, 0, 1, 0, 2, 4, 5, 1})", new int[]{0, 0, 0, 1, 1, 2, 4, 4, 5}, exercises.arraySort(new int[]{4, 0, 0, 1, 0, 2, 4, 5, 1}));
//		int[] sorted = getSortedArray(100000);
//		int[] unsorted = getUnsortedArray(sorted);
//		assertArrayEquals(sorted, exercises.arraySort(unsorted));
//		
//    }
	
	@Test
    public void arraySortMergeSort() {
		assertArrayEquals("Input: {8, 13, 9, 12})", new int[]{8, 9, 12, 13}, searchAlgorithms.arraySortMergeSort(new int[]{8, 13, 9, 12}));
		assertArrayEquals("Input: {4, 0, 0, 1, 0, 2, 4, 5, 1})", new int[]{0, 0, 0, 1, 1, 2, 4, 4, 5}, searchAlgorithms.arraySortMergeSort(new int[]{4, 0, 0, 1, 0, 2, 4, 5, 1}));
		int[] sorted = getSortedArray(ARRAY_SIZE);
		int[] unsorted = getUnsortedArray(sorted);
		assertArrayEquals(sorted, searchAlgorithms.arraySortMergeSort(unsorted));
		
    }
	
	@Test
    public void arraySortInsertionSort() {
		assertArrayEquals("Input: {8, 13, 9, 12})", new int[]{8, 9, 12, 13}, searchAlgorithms.arraySortInsertionSort(new int[]{8, 13, 9, 12}));
		assertArrayEquals("Input: {4, 0, 0, 1, 0, 2, 4, 5, 1})", new int[]{0, 0, 0, 1, 1, 2, 4, 4, 5}, searchAlgorithms.arraySortInsertionSort(new int[]{4, 0, 0, 1, 0, 2, 4, 5, 1}));
		int[] sorted = getSortedArray(ARRAY_SIZE);
		int[] unsorted = getUnsortedArray(sorted);
		assertArrayEquals(sorted, searchAlgorithms.arraySortInsertionSort(unsorted));
		
    }
	
	@Test
    public void arraySortOptimizedBubbleSort() {
		assertArrayEquals("Input: {8, 13, 9, 12})", new int[]{8, 9, 12, 13}, searchAlgorithms.arraySortOptimizedBubbleSort(new int[]{8, 13, 9, 12}));
		assertArrayEquals("Input: {4, 0, 0, 1, 0, 2, 4, 5, 1})", new int[]{0, 0, 0, 1, 1, 2, 4, 4, 5}, searchAlgorithms.arraySortOptimizedBubbleSort(new int[]{4, 0, 0, 1, 0, 2, 4, 5, 1}));
		int[] sorted = getSortedArray(ARRAY_SIZE);
		int[] unsorted = getUnsortedArray(sorted);
		assertArrayEquals(sorted, searchAlgorithms.arraySortOptimizedBubbleSort(unsorted));
		
    }
	
	
	@Test
    public void arraySortCountingSort() {
		assertArrayEquals("Input: {8, 13, 9, 12})", new int[]{8, 9, 12, 13}, searchAlgorithms.arraySortCountingSort(new int[]{8, 13, 9, 12}));
		assertArrayEquals("Input: {4, 0, 0, 1, 0, 2, 4, 5, 1})", new int[]{0, 0, 0, 1, 1, 2, 4, 4, 5}, searchAlgorithms.arraySortCountingSort(new int[]{4, 0, 0, 1, 0, 2, 4, 5, 1}));
		int[] sorted = getSortedArray(ARRAY_SIZE);
		int[] unsorted = getUnsortedArray(sorted);
		assertArrayEquals(sorted, searchAlgorithms.arraySortCountingSort(unsorted));
		
    }

	private int[] getUnsortedArray(int[] sorted) {
		List<Integer> intList = Arrays.stream(sorted).boxed().collect(Collectors.toList());
		Collections.shuffle(intList);
		return intList.stream().mapToInt(x -> x).toArray();
	}
	
	private int[] getSortedArray(int max) {
		
		int[] sorted = new int[max];
		
		for (int i = 0; i < max; i++) {
			sorted[i] = i;
			if (i % 5 == 0 && i < max - 1) {
				i++;
				sorted[i] = i - 1;
			}
			if (i % 7 == 0 && i < max - 3) {
				i++;
				sorted[i] = i - 1;
				i++;
				sorted[i] = i - 2;
				i++;
				sorted[i] = i - 3;
			}
			
		}
		
		return sorted;
		
	}


}
