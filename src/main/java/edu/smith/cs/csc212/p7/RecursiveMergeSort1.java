package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class RecursiveMergeSort1 {
	
	public static ListADT<Integer> combiner(ListADT<Integer> left, ListADT<Integer> right, ListADT<Integer> combined) {
		//ListADT<Integer> combined = new JavaList<>();
		while (!left.isEmpty() && !right.isEmpty()) {
			int firstL = left.getFront();
			int firstR = right.getFront();
			if (firstL <= firstR) {
				combined.addBack(firstL);
				left.removeFront();		
			}
			else {
				combined.addBack(firstR);
				right.removeFront();
			}
		}
		if (left.isEmpty()) {
			combined.addAll(right);
		}
		else if (right.isEmpty()) {
			combined.addAll(left);
		}
		System.out.println("combiner combined " + combined.toJava());
		//System.out.println("left " + left.toJava());
		//System.out.println("right " + right.toJava());
		return combined;
	}
	
	public static ListADT<Integer> split(ListADT<Integer> input) {
		int N = input.size();
		int half = N/2;
		ListADT<Integer> left = new JavaList<>();
		left = input.slice(0, half);
		ListADT<Integer> right = new JavaList<>();
		right = input.slice(half, N);
		System.out.println("input " + input.toJava());
		if (left.size()!=1) {
			split(left);
		}
		if (left.size()==1) {
			ListADT<Integer> combinerList = new JavaList<>();
			ListADT<Integer> combined = combiner(left,right, combinerList);
			return combined;
		}
		return right;
	}
	
	public static void mergeSort(ListADT<Integer> input) {
		
	}
	
}
