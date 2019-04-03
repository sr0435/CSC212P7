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
		int counter = N;
		while(true) {
			// goes through the list until the end of the unsorted objects
			for (int i=0; i<N; i++) {
				// gets the index of the min
				int minIndex = findMin(input,i,N);
				// swaps the minimum of the unsorted part with the spot in the list
				input.swap(i, minIndex);
				counter--;
			}
			// exits the loop if everything has been checked and sorted
			if (counter==0) {
				break;
			}
		}
	}
}
