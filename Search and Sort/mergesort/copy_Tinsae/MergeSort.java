package algo.mergesort.copy_Tinsae;

import java.util.Arrays;

public class MergeSort {

	public static void sort(int inputArray[]) {
		System.out.println("ms(" + 0 + " , " + (inputArray.length-1) + ")");
		sort(inputArray, 0, inputArray.length - 1);
		System.out.println("sorted: " + Arrays.toString(inputArray));

	}

	public static void sort(int inputArray[], int start, int end) {
		if (end <= start) {
			return; // we're done traversing the array
		}
		
		int mid = (start + end) / 2;
		System.out.println("ms(" + start + " , " + mid + ")");
		sort(inputArray, start, mid); // sort left half
		System.out.println("ms(" + (mid + 1) + " , " + end + ")");
		sort(inputArray, mid + 1, end); // sort right half
		merge(inputArray, start, mid, end); // merge sorted results into the inputArray
	}

	// TGA Merge Sort Implementation
	// start and end show the portion of the array to be merged
	public static void merge(int inputArray[], int start, int mid, int end) {
		
		// Pointer for the left part of the array
		int leftC = start;
		// Pointer for the right part of the array
		int rightC = mid + 1;
		// copy the array, size is end - start + 1
		int [] copyOfArray = new int [(end - start) + 1];
		// the start and end pointers can be anywhere inside the array
		// however, copyOfArray copies the slice starting index 0
		System.arraycopy(inputArray, start, copyOfArray, 0, (end - start) + 1);
		
		// from start to end
		for (int i = start; i < end + 1; i++) {
			
			// if left pointer passed its boundary
			// this shows all the numbers on left half of the array were picked(merged)
			// so remaining is the right side
			if(leftC > mid)
			{
				// (rightC - start) is for accessing the element at rightC 
				// in the input array from copyOfArray
				inputArray[i] = copyOfArray[rightC - start];
				rightC++;
			}
			// if right pointer passed its boundary
			// this shows all the numbers on the right half of the array were  picked(merged)
			// so remaining is the left half
			else if(rightC > end)
			{		
				// (leftC - start) is for accessing the element at leftC 
				// in the input array from copyOfArray
				inputArray[i] = copyOfArray[leftC - start];
				leftC++;
			}
			// if a number on the left half is less than the its right counterpart
			// merge the lesser one and move left pointer
			else if (copyOfArray[leftC - start] <= copyOfArray[rightC - start]) {
				inputArray[i] = copyOfArray[leftC - start];
				leftC++;
			}
			// else then a number on the right half is less than the its left counterpart
			// merge the lesser one and move right pointer
			else {
				inputArray[i] = copyOfArray[rightC - start];
				rightC++;
			}
		

		}
		System.out.println("sub-sorted: " + Arrays.toString(inputArray));

	}
	

	// **************************************************************************

	// ---------BELOW IS AN OPTIONAL ASSIGNMENT WITH A REWARD FOR YOU------------

	// **************************************************************************
	/**
	 * Hopefully you were able to complete the above merge() method Below is a more
	 * challenging implementation. It's called an in-place merge. This is usually
	 * pretty difficult for even average programmers to wrap their head around. If
	 * you put in the effort to try and understand the below code, you will
	 * certainly get it. Here is an incentive for you to put in the time: If you can
	 * email me a detailed easy to read explanation in your own words about how the
	 * below code works, I'll provide you a 75% discount for all my current and
	 * future courses on my online school! my email address is
	 * imtiaz@eliminatecodefear.com
	 * 
	 * <br>
	 * <b> GOOD LUCK!<b>
	 * 
	 * @param inputArray
	 * @param start
	 * @param mid
	 * @param end
	 */
	private static int tempArray[]; // an array used for merging
	// To use the mergeInPlace() method, you'll need to initialize tempArray as
	// shown on the next line inside of the wrapper sort() method.
	// tempArray = new int [inputArray.length];

	public static void mergeInPlace(int inputArray[], int start, int mid, int end) {
		int i = start; // save starting index into temporary variable
		int j = mid + 1;

		for (int k = 0; k <= end; k++) {
			tempArray[k] = inputArray[k];
		}

		for (int k = start; k <= end; k++) {
			if (i > mid) {
				inputArray[k] = tempArray[j];
				j = j + 1;
			} else if (j > end) {
				inputArray[k] = tempArray[i];
				i = i + 1;
			} else if (tempArray[j] < tempArray[i]) {
				inputArray[k] = tempArray[j];
				j = j + 1;
			} else {
				inputArray[k] = tempArray[i];
				i = i + 1;
			}
		}
	}

}
