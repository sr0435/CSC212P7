package edu.smith.cs.csc212.p7;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(ListADT<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) > items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}

	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};

	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));

		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		System.out.println("shuffled sortMe: " + sortMe.toJava());
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		Assert.assertEquals(sortMe.size(), data.length);
	}

	@Test
	public void testClassBubbleSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));

		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		Assert.assertEquals(sortMe.size(), 9);
	}

	@Test
	public void testSlice() {
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		int mid = sortMe.size()/2;
		ListADT<Integer> leftSlice = sortMe.slice(0, mid);
		ListADT<Integer> rightSlice = sortMe.slice(mid, sortMe.size());

		Assert.assertEquals(leftSlice.toJava(), Arrays.asList(35, 88, 11, 47));
		Assert.assertEquals(rightSlice.toJava(), Arrays.asList(14, 24, 41, 62, 27));

		Assert.assertEquals(14, (int) rightSlice.removeFront());
		Assert.assertEquals(4, rightSlice.size());
		Assert.assertEquals(27, (int) rightSlice.removeBack());
		Assert.assertEquals(3, rightSlice.size());
	}

	@Test
	public void testSelectionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		Assert.assertTrue(sortMe.size()==9);
		Random rand = new Random(12);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		System.out.println("shuffled sortMe: " + sortMe.toJava());
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		Assert.assertEquals(sortMe.size(), data.length);
	}

	@Test
	public void testClassSelectionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		Assert.assertEquals(sortMe.size(), 9);

	}

	@Test
	public void testInsertionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		ListADT<Integer> sortedInsertion = InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortedInsertion));
		Assert.assertEquals(data.length, sortedInsertion.size());
		// since all of sortMe's data is removed while doing insertion sort, we need to add it back
		sortMe.addAll(sortedInsertion);
		Random rand = new Random(11);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		System.out.println("shuffled sortMe: " + sortMe.toJava());
		ListADT<Integer> sortedInsertion2 = InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortedInsertion2));
		Assert.assertEquals(data.length, sortedInsertion2.size());
	}

	@Test
	public void testClassInsertionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		ListADT<Integer> sortedInsertion = InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortedInsertion));
		Assert.assertEquals(sortedInsertion.size(), 9);
	}

	@Test
	public void testRecursiveMerge() {
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		ListADT<Integer> combined = RecursiveMergeSort.split(sortMe);
		Assert.assertTrue(checkSorted(combined));
		Assert.assertEquals(data.length, combined.size());
		
		Random rand = new Random(10);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		System.out.println("shuffled sortMe: " + sortMe.toJava());
		ListADT<Integer> combined2 = RecursiveMergeSort.split(sortMe);
		Assert.assertTrue(checkSorted(combined2));
		Assert.assertEquals(data.length, combined2.size());
	}
	@Test
	public void testClassRecursiveMergeSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(88, 35, 11, 47, 14, 24, 41, 62, 27));
		ListADT<Integer> combined = RecursiveMergeSort.split(sortMe);
		Assert.assertTrue(checkSorted(combined));
		Assert.assertEquals(combined.size(), 9);
	}

	@Test
	public void testIterativeMergeSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		ListADT<Integer> sortI = IterativeMergeSort.split(sortMe);
		Assert.assertTrue(checkSorted(sortI));
		Assert.assertEquals(data.length, sortI.size());

		Random rand = new Random(9);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		System.out.println("shuffled sortMe: " + sortMe.toJava());
		ListADT<Integer> sortI2 = IterativeMergeSort.split(sortMe);
		Assert.assertTrue(checkSorted(sortI2));
		Assert.assertEquals(data.length, sortI2.size());

	}

	@Test
	public void testClassIterativeMergeSort() {
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(88, 35, 11, 47, 14, 24, 41, 62, 27));
		ListADT<Integer> combined =IterativeMergeSort.split(sortMe);
		Assert.assertTrue(checkSorted(combined));
		Assert.assertEquals(combined.size(), 9);
	}

}
