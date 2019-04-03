package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.DoublyLinkedList;

public class IterativeMergeSort {

	public static ListADT<Integer> split(ListADT<Integer> input) {
		// creates a list of lists
		DoublyLinkedList<DoublyLinkedList<Integer>> mergingList = new DoublyLinkedList<>();
		// adds all the elements from the input list into mini lists inside merging list
		for (int num : input) {
			DoublyLinkedList<Integer> newList = new DoublyLinkedList<>();
			newList.addBack(num);
			mergingList.addBack(newList);
		}
		// combines the element-lists in merging list until there's one big list
		while (mergingList.size()>1) {
			DoublyLinkedList<Integer> first = mergingList.removeFront();
			DoublyLinkedList<Integer> second = mergingList.removeFront();
			DoublyLinkedList<Integer> middleList = combine(first,second);
			mergingList.addBack(middleList);
		}
		return mergingList.getBack();
	}
	// same as recursive but with DLL
	public static DoublyLinkedList<Integer> combine(DoublyLinkedList<Integer> left,DoublyLinkedList<Integer> right) {
		DoublyLinkedList<Integer> middleList = new DoublyLinkedList<>();
		while (!left.isEmpty() && !right.isEmpty()) {
			int frontL = left.getFront();
			int frontR = right.getFront();

			if (left.getFront() <= right.getFront()) {
				middleList.addBack(frontL);
				left.removeFront();
			}
			else {
				middleList.addBack(frontR);
				right.removeFront();
			}
		}
		if (left.isEmpty()) { 
			middleList.addAll(right); 
		} 
		if (right.isEmpty()) {
			middleList.addAll(left); 
		}
		return middleList;
	}
	
}
