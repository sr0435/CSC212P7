package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;

public class SelectionSort {


	public static int findMin(ListADT<Integer> input, int start, int end) {
		// the index of the minimum value
		int min = start;
		// the minimum value
		int minValue = input.getIndex(start);
		// goes through the list to find the min
		for (int i=start;i<end;i++) {
			int current = input.getIndex(i);
			if (minValue>current) {
				min = i;
				minValue = current;
			}
		}
		return min;
	}

	public static void selectionSort(ListADT<Integer> input) {
		int N = input.size();
		while(true) {
			// goes through the list until the end of the unsorted objects
			for (int i=0; i<N; i++) {
				// gets the index of the min
				int minIndex = findMin(input,0,N);
				// remove the value at the min index
				int removed = input.removeIndex(minIndex);
				// add that to the back
				input.addBack(removed);
				// "decrease" the size so you only check the unsorted parts
				N--;
			}
			// exits the loop if everything has been checked and sorted
			if (N==0) {
				break;
			}
		}
	}
}
