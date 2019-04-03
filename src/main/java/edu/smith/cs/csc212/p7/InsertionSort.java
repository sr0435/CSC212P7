package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class InsertionSort {
	public static ListADT<Integer> insertionSort(ListADT<Integer> input) {
		int N = input.size();
		// creates a new list to insert the sorted elements into
		ListADT<Integer> sortedList = new JavaList<>();
		int S = sortedList.size();
		// loop that takes out everything from the input, 
		//sorts it, and then puts it into  the sorted list
		for (int i = 0; i<N; i++) {
			int front = input.removeFront();
			// easily adds to the back rather than going by index
			if (S == 0 || front >= sortedList.getBack()) { 
				sortedList.addBack(front); 
			} else { 
				// checks every element in the sorted list linearly
				for (int j=0; j<S;j++) { 
					// if it's smaller than the element then it gets placed behind
					if (front <= sortedList.getIndex(j)) { 
						// if it needs to get placed first, use add front
						if (j==0) {
							sortedList.addFront(front); 
						} 
						else { 
							// otherwise just add it right before the index
								sortedList.addIndex(j-1, front); 
						} 
					}
					// if it's bigger then add after
					else { 
						// if there is a next element, and front is less than it, then add
						// the element right before the next one
						if (sortedList.getIndex(j+1) != null 
								&& front <= sortedList.getIndex(j+1)) {
							sortedList.addIndex(j+1, front); 
						}
						// if there isn't a next element, we add to the back, 
						//which we've taken care of 
						else {
							continue;
						}
					} 
					// if you've already placed the element, time to quit the loop
					break; 
				}
			}
			// increase the count of S
			S++;
		}
		return sortedList;
	}

}
