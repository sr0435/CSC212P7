package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class Combiner {
	public static ListADT<Integer> combiner(ListADT<Integer> left, ListADT<Integer> right) {
		ListADT<Integer> combined = new JavaList<>();
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
		if (!left.isEmpty()) {
			combined.addAll(left);
			left.removeBack();
			
		}
		else if (!right.isEmpty()) {
			combined.addAll(right);
			right.removeBack();
		}
		System.out.println("combined " + combined.toJava());
		//System.out.println("left " + left.toJava());
		//System.out.println("right " + right.toJava());
		return combined;
	}
	
	
	public static void split(ListADT<Integer> input) {
		int N = input.size();
		int half = N/2;
		ListADT<Integer> left = new JavaList<>();
		left = input.slice(0, half);

		ListADT<Integer> right = new JavaList<>();
		right = input.slice(half, N);

		boolean isWhole = false;
		if (left.size()!=1) {
			System.out.println("left splitting " + left.toJava());
			System.out.println("right leftover " + right.toJava());
			split(left);
			split(right);
		}
		if (right.size()!=1) {
			System.out.println("right splitting " + right.toJava());
			split(right);
		}
		if (left.size()==1 && right.size()==1) { 
			ListADT<Integer> totalList = new JavaList<>();
			while (!isWhole) {
				ListADT<Integer> combined = Combiner.combiner(left, right);
				totalList.addAll(combined);
				System.out.println("total list: " + totalList.toJava());
				if (combined.size()==N) {
					isWhole = true;
				}
			}
			
		}

	}
	
	
	
}
