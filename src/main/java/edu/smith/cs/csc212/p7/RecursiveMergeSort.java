package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class RecursiveMergeSort {
	public static ListADT<Integer> split(ListADT<Integer> input) {
		int N = input.size();
		// if there's only one thing, no point in splitting it further
		if (N==1) {
			return input;
		}
		// creates the list halves
		int half = N/2;
		ListADT<Integer> left = new JavaList<>();
		left = input.slice(0, half);
		ListADT<Integer> right = new JavaList<>();
		right = input.slice(half, N);

		// splits the lists until they get small enough
		ListADT<Integer> sortedL = split(left);
		ListADT<Integer> sortedR = split(right);
		// then combines them
		ListADT<Integer> sorted = combine(sortedL,sortedR);

		return sorted;
	}
	public static ListADT<Integer> combine(ListADT<Integer> left,ListADT<Integer> right) {
		ListADT<Integer> sortedList = new JavaList<>();
		while (!left.isEmpty() && !right.isEmpty()) {
			int frontL = left.getFront();
			int frontR = right.getFront();
			// sorts the elements and puts them in the returned list
			if (left.getFront() <= right.getFront()) {
				sortedList.addBack(frontL);
				left.removeFront();
			}
			else {
				sortedList.addBack(frontR);
				right.removeFront();
			}
		}
		// adds if one list is bigger than the other
		if (left.isEmpty()) { 
			sortedList.addAll(right); 
		} 
		if (right.isEmpty()) {
			sortedList.addAll(left); 
		}
		// returns the list with all the sorted elements
		return sortedList;
	}
}
