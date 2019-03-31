package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class InsertionSort {
	public static ListADT<Integer> insertionSort(ListADT<Integer> input) {
		int N = input.size();
		System.out.println("input " + input.toJava());
		ListADT<Integer> sortedList = new JavaList<>();
		int S = sortedList.size();
		for (int i = 0; i<N; i++) {
			int front = input.removeFront();
			if (S == 0) { 
				sortedList.addBack(front); 
			} else { 
				for (int j=0; j<S-1; j++) { 
					if (front <= sortedList.getIndex(j)) { 
						if (j==0) { 
							sortedList.addIndex(0, front); 
						}  else { 
							sortedList.addIndex(j-1, front); 
						}
					}  else { sortedList.addIndex(j+1, front); } break; }
			}

			S++;
		}
		System.out.println("end " + sortedList.toJava());
		return sortedList;
	}

}
