package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class InsertionSort {
	public static ListADT<Integer> insertionSort(ListADT<Integer> input) {
		int N = input.size();
		ListADT<Integer> sortedList = new JavaList<>();
		int S = sortedList.size();
		for (int i = 0; i<N; i++) {
			int front = input.removeFront();
			if (S == 0 || front >= sortedList.getBack()) { 
				sortedList.addBack(front); 
			} else { 
				for (int j=0; j<S;j++) { 
					if (front <= sortedList.getIndex(j)) { 
						if (j==0) {
							sortedList.addFront(front); 
						} 
						else { 
							if (front >= sortedList.getIndex(j-1)) {
								sortedList.addIndex(j-1, front); 
							}
							else {
								continue;
							}
						} 
					}
					else { 
						if (sortedList.getIndex(j+1) != null && front <= sortedList.getIndex(j+1)) {
							sortedList.addIndex(j+1, front); 
						}
						else {
							continue;
						}

					} 
					break; 
				}
			}
			S++;
		}
		return sortedList;
	}

}
