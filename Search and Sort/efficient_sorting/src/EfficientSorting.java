

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class EfficientSorting {

	public static void main(String[] args) {
		ArrayList<String> testList;
		final int ARRAY_SIZE = 10000;
		testList = new ArrayList<String>();
		long startTime = System.currentTimeMillis();
		
		
		// fill the ArrayList with gene sequences
		for (int i = 0; i < ARRAY_SIZE; i++) {
			testList.add(geneSequence());
		}
		
		
		// Testing how much the array is sorted
//		int sortedCount = 0;
//		for (int i = 1; i < testList.size(); i++) {
//			// sorted pair found
//			if (testList.get(i - 1).compareTo(testList.get(i)) <= 0)
//				sortedCount += 1;
//		}
//		System.out.println(sortedCount);

		// testSpeed(testList, "hybridsort");

		// Testing insertion sort alone
		// ArrayList<String> testSubList = new ArrayList<String>(testList.subList(0,
		// 5));
		// System.out.println("before\n" + testSubList);
		// insertionSort(testSubList);
		// System.out.println("after\n" + testSubList);

		// Testing merge sort alone
		// ArrayList<String> testSubList = new ArrayList<String>(testList.subList(0,
		// 10));
		// System.out.println("before\n" + testSubList);
		// mergeSort(testSubList);
		// System.out.println("after\n" + testSubList);

		// Testing merge sort alone
//		int beg = (int) (Math.random() * 9999);
//		System.out.println("beg is" + beg);
//		int end = beg + 100;
//		ArrayList<String> testSubList = new ArrayList<String>(testList.subList(beg, end));
//		System.out.println("before\n" + testSubList);
//		hybridSort(testSubList);
//		System.out.println("after\n" + testSubList);

		// calculate and display the timing for insertion sort
		testSpeed(testList, "insertionsort");

		// calculate and display the timing for mergesort
		testSpeed(testList, "mergesort");

		// calculate and display the timing for the hybrid
		testSpeed(testList, "hybridsort");
	}

	public static void testSpeed(ArrayList<String> testList, String algorithm) {
		int iterations = 0;
		int index;
		long startTime = System.currentTimeMillis();
		// when for the first time we enter the loop, the array is
		// not sorted, but subsequent iterations we get a sorted array
		// therefore we can either choose the to shuffle it or
		// we can only unsort one pair
		// If we mess only one pair of a sorted array, we can say
		// > 99% of the array is sorted
		// run for at least 5 seconds
		while (System.currentTimeMillis() - startTime < 5000) {
			iterations++;
			// now unsort the array in two different possible ways
			if (Math.random() < 0.5) {
				// completely shuffle the array
				 Collections.shuffle(testList);
			} else {
				for (int i = 0; i < 0.001 * testList.size(); i++) {
					// pick a random index
					index = (int) Math.floor(Math.random() * testList.size());
					// replace that sequence with a new one
					testList.set(index, geneSequence());
				}
			}
			// now sort the array
			// calls the appropriate sorting method
			if (algorithm.equals("insertionsort")) {
				insertionSort(testList);
			} else if (algorithm.equals("mergesort")) {
				mergeSort(testList);

			} else if (algorithm.equals("hybridsort")) {
				hybridSort(testList);
			}
		}

		if (algorithm.equals("insertionsort")) {
			long totalTime = System.currentTimeMillis() - startTime;
			System.out.println("insertion sort was able to run " + String.valueOf(iterations) + " times in "
					+ String.valueOf(totalTime) + " ms \n");
		} else if (algorithm.equals("mergesort")) {
			long totalTime = System.currentTimeMillis() - startTime;
			System.out.println("merge sort was able to run " + String.valueOf(iterations) + " times in "
					+ String.valueOf(totalTime) + " ms \n");

		} else if (algorithm.equals("hybridsort")) {
			long totalTime = System.currentTimeMillis() - startTime;
			System.out.println("hybrid sort was able to run " + String.valueOf(iterations) + " times in "
					+ String.valueOf(totalTime) + " ms \n");
		}

	}

	private static String geneSequence() {
		char[] seq = new char[20];
		double p;
		for (int i = 0; i < seq.length; i++) {
			p = Math.random();
			if (p < 0.25) {
				seq[i] = 'A';
			} else if (p < 0.5) {
				seq[i] = 'G';
			} else if (p < 0.75) {
				seq[i] = 'T';
			} else {
				seq[i] = 'C';
			}
		}
		return new String(seq);
	}

	public static ArrayList<String> insertionSort(ArrayList<String> a) {
		for (int i = 1; i < a.size(); i++) {
			// element variable contains the data
			// we intend on bringing over to the sorted
			// area
			String element = a.get(i);
			// j variable points to the index position of
			// the last value in the sorted area
			int j = i - 1;
			// compareTo returns a positive number if the jth element
			// is greater than the element variable
			// A jth element in the sorted portion that is greater
			// is shifted forward to leave space
			// for element to go in.
			while (j >= 0 && a.get(j).compareTo(element) > 0) {
				a.set(j + 1, a.get(j));
				j--;
			}
			// insert the element in the correct position
			a.set(j + 1, element);
		}
		return a;
	
	}

	// The merge sort is often implemented recursively, so this function
	// initiates the recursion.
	public static void mergeSort(ArrayList<String> inputArray) {
		sort(inputArray, 0, inputArray.size() - 1);
	}

	// This one is the actual merge sort algorithm
	public static void sort(ArrayList<String> inputArray, int start, int end) {
		if (end <= start) {
			return; // we're done traversing the array
		}

		// find the mid
		int mid = (start + end) / 2;
		// sort left half
		sort(inputArray, start, mid);
		// sort right half
		sort(inputArray, mid + 1, end);
		// merge sorted results into the inputArray
		merge(inputArray, start, mid, end);
	}

	// start and end show the portion of the array to be merged
	public static void merge(ArrayList<String> inputArray, int start, int mid, int end) {

		// Pointer for the left part of the array
		int leftC = start;
		// Pointer for the right part of the array
		int rightC = mid + 1;
		// copy the array
		ArrayList<String> copyOfArray = new ArrayList<String>(inputArray);
		// from start to end
		for (int i = start; i < end + 1; i++) {
			// if left pointer passed its boundary
			// this shows all the numbers on left half of the array were picked(merged)
			// so remaining is the right side
			if (leftC > mid) {
				inputArray.set(i, copyOfArray.get(rightC));
				rightC++;
			}
			// if right pointer passed its boundary
			// this shows all the numbers on the right half of the array were picked(merged)
			// so remaining is the left half
			else if (rightC > end) {
				inputArray.set(i, copyOfArray.get(leftC));
				leftC++;
			}
			// if a number on the left half is less than the its right counterpart
			// merge the lesser one and move left pointer
			else if (copyOfArray.get(leftC).compareTo(copyOfArray.get(rightC)) <= 0) {
				inputArray.set(i, copyOfArray.get(leftC));
				leftC++;
			}
			// else then a number on the right half is less than the its left counterpart
			// merge the lesser one and move right pointer
			else {
				inputArray.set(i, copyOfArray.get(rightC));
				rightC++;
			}

		}

	}

	public static void hybridSort(ArrayList<String> inputArray) {
		// Pick the first X values, and check to see if Y of them are in increasing
		// order.
		int size = inputArray.size();

		// Array has one or no element
		if (size != 0 && size != 1 && size >= 10) {
			// Important for smaller size arrays check portion
			int portion = 1;
			// if size of array is less than 100 take half of the array
			if (size < 100) {
				portion = (int) (size * 0.5);
			}
			// else take 10% of the array
			else {
				portion = (int) Math.floor(size * 0.1);

			}
			// take 10% of the array
			// size = 10000. portion = 1000
			ArrayList<String> testSubList = new ArrayList<String>(inputArray.subList(0, portion));
			// count how many sorted pairs you can get
			int sortedCount1 = 0;
			for (int i = 1; i < testSubList.size(); i++) {
				// sorted pair found
				if (testSubList.get(i - 1).compareTo(testSubList.get(i)) <= 0)
					sortedCount1 += 1;
			}

			// Pick X evenly spaced values throughout the array and see if Y are in
			// increasing order.
			// take 10 elements apart
			// size = 100000 we can get 10000/10 = 1000 elements
			// space is the amount skipped to get 10% of the data
			// evenly spaced from an inputArray of a given size
			int space = (int) Math.floor(size / portion);
			testSubList = new ArrayList<String>();
			// add the evenly spaced elements to a new array
			for (int i = 0; i < size; i += space) {
				testSubList.add(inputArray.get(i));
			}
			// count number of sorted pairs found
			int sortedCount2 = 0;
			for (int i = 1; i < portion; i++) {
				// sorted pair found
				if (testSubList.get(i - 1).compareTo(testSubList.get(i)) < 0)
					sortedCount2 += 1;
			}

			// find percentage of sorted values
			// 1.0 is added because the (number of pairs - size of the array) is - 1.0
			// for example if we have an array with 5 elements
			// there are 4 pairs (0,1) (1,2) (2,3) (4,5)
			//
			// for a perfectly random array of gene sequences
			// the most likely result is very close 0.5 for both
			// sortedAmount1 and sortedAmount2
			double sortedAmount1 = (sortedCount1 + 1.0) / portion;
			double sortedAmount2 = (sortedCount2 + 1.0) / portion;

			//System.out.println(sortedAmount1 + "-" +sortedAmount2);
			// if only less 90% of the array elements are sorted
			// we use mergeSort
			if ((sortedAmount1 < 0.9) && (sortedAmount2 < 0.9)) {
				mergeSort(inputArray);

			}
			// else if more than 90% of the elements are sorted
			// we use insertion sort
			else {

				insertionSort(inputArray);
			}

		} else {
			System.out.println("Invalid Array Given");
		}

	}

}
