package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.DoublyLinkedList;

public class IterativeMergeSort {

	public static ListADT<Integer> split(ListADT<Integer> input) {
		DoublyLinkedList<DoublyLinkedList<Integer>> mergingList = new DoublyLinkedList<>();
		int N = input.size();
		//ListADT<ListADT<Integer>> mergingList = new JavaList<>();
		for (int num : input) {
			DoublyLinkedList<Integer> newList = new DoublyLinkedList<>();
			newList.addBack(num);
			mergingList.addBack(newList);
		}
		while (mergingList.size()>1) {
			DoublyLinkedList<Integer> middleList = new DoublyLinkedList<>();
			DoublyLinkedList<Integer> first = mergingList.removeFront();
			DoublyLinkedList<Integer> second = mergingList.removeFront();
			combine(first,second,middleList);
			mergingList.addBack(middleList);
		}
		return mergingList.getFront();
	}

	public static void combine(DoublyLinkedList<Integer> left,DoublyLinkedList<Integer> right,DoublyLinkedList<Integer> output) {

		while (!left.isEmpty() && !right.isEmpty()) {
			int frontL = left.getFront();
			int frontR = right.getFront();

			if (left.getFront() <= right.getFront()) {
				output.addBack(frontL);
				left.removeFront();
			}
			else {
				output.addBack(frontR);
				right.removeFront();
			}
		}
		if (left.isEmpty()) { 
			output.addAll(right); 
		} 
		if (right.isEmpty()) {
			output.addAll(left); 
		}
	}
}
