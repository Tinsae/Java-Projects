package algo.quicksort.copy_Tinsae;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		//int[] inputArray = { 12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4 };
		int[] inputArray = { 3, 4, 8, 5, 2, 6, 7};

		System.out.println("qs(" + 0 + " , " + (inputArray.length-1) + ")");

		quickSort(inputArray, 0, inputArray.length-1);
		
		System.out.println(Arrays.toString(inputArray));
	}
	
	
	public static void quickSort(int [] inputArray, int start, int end){
		if(start < end)
		{
			int q = partition(inputArray, start, end);
			System.out.println("qs(" + start + " , " + (q - 1) + ")");
			quickSort(inputArray, start , q - 1);
			System.out.println("qs(" + (q + 1) + " , " + end + ")");
			quickSort(inputArray, q + 1, end);
			
		}
	}
	
	public static int partition(int [] inputArray, int start, int end){
		// i points to the position to do the switching
		int i = start - 1;
		// j points to the current element
		int j = start;
		// the element which we find its position in the array
		int pivot = inputArray[end];
		for(;j < end; j++)
		{
			
			if(inputArray[j] < pivot)
			{
				i++;
				int temp = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = temp;
			}
		}
		// at the end of the loop i indicates the division point
		// between numbers less than pivot and those that are greater
		// so we  need to swap the pivot position with i++ position
		// in the best case i++ will be the same as end, this happens
		// when all elements are to the left of the pivot
		i++;
		int temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
		//System.out.println(Arrays.toString(inputArray));
		return i;
		
	}
}
