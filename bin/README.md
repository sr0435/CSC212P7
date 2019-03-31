# CSC212P7

Sorting! In this assignment, you have little starter code. I have provided an implementation of BubbleSort (from class) and isSorted in a single test file. You do not need separate test files for each sorting algorithm, although you can do so.

Although we discussed Comparable and Comparator in class, your sorting algorithms here need only work on ``ListADT<Integer>``, like the provided bubbleSort. No signatures are provided. You will have to decide whether your sorting algorithm modifies a list (easy in BubbleSort) or returns a new list (much easier for MergeSort). Therefore, copying the BubbleSort test directly will not help you with MergeSort -- you'll have to deal with the fact that your mergesort will be returning a new ``ListADT<Integer>`` to you.

## About P7

We're going to focus on the mechanics of sorting here.
Some algorithm descriptions are derived from [N. Howe's assignment on Sorting](http://www.cs.smith.edu/~nhowe/teaching/csc212/Assignments/sorting.php). So you have these textual descriptions in addition to the slides.

## Rubric (100)

This assignment is a little smaller than usual and the maximum is only 100 points.

### (30) Reflection, Code Compiles and Tests Run.

It is very important your code compiles and you do not change the directory structure. If you have issues importing the code into Eclipse, let me know and we can fix it together. I plan to grade these as automatically as possible.

### (20) Simple Sorts

These are sorts that have quite short descriptions.

#### (10) Selection Sort

Selection Sort works by finding the minimum value in the list and bringing it to the front, over and over. This is one of the simplest sorting algorithms.

> Until unsorted is empty, scan it for the smallest remaining element. Remove that element from unsorted and add it to the tail of sorted. (One way to do this: Loop through all the nodes, keeping the index of the smallest element seen so far as you continue to scan through the list, then remove that element by index. Another way: avoid using an index by actually pulling out the smallest element seen so far, and then swapping it back in if and when you encounter a smaller one. Yet another: use two iterators, one to traverse the loop element by element and the other to hold the place of the smallest element seen so far, so you get a stable sort.)

#### (10) Insertion Sort

Insertion Sort works by building up a list one at a time, and inserting it into the right point. Some bonus points may be available for using binary search to insert, but it can be done with linear search as well. 

> Until unsorted is empty, take the first element off it and find the point where it should go in sorted (the point where all previous elements are smaller, and all following elements are equal to or greater than). Insert it into sorted at this point.


### (30) Merge Sort

Merge sort is an important sorting algorithm. We will explore the recursive and iterative solutions in this assignment.

#### (10) combine helper method

To merge two sorted lists into a single sorted list, look at the first element in each list. Take the smaller of the two off the front of its old list and put it at the end of the new (merged) list. Repeat this until both one of the old lists is empty, at which point you can append the remainder of the other original list to the new list. If the original lists were sorted, and you always take the smallest element available, then the resulting list will also be sorted. 

#### (10) Recursive MergeSort

Use recursion to break down the list into pieces and build it back up. Split the list in half until there are only tiny lists that remain.

Note two of the new methods on ``ListADT``: ``slice`` and ``addAll`` that can help you make a copy of a part of a list.

#### (10) Iterative MergeSort

Begin by placing each element of the original list into a new singleton list. You may store all the singleton lists in a list of lists.

How do you make a list of one element?

While more than one list remains, take the first two lists from your work queue and merge them, preserving the sorted order. Put the result back at the end of the work queue.

### (5) Make sure your MergeSort uses DoublyLinkedList where appropriate.

We discussed how the work queue should probably be a DLL.

### (15) Unit Testing your Sorts!

I have provided some simple tests for BubbleSort. While implementing these sorting algorithms from pseudocode and descriptions, you will need to test your implementations. Testing will require you to think of how the sorts work from a user perspective:

Which sorts change a list in place? Which sorts a list and returns a copy? You will need to change tests slightly to accomodate.

Note the addition of ``ListADT.shuffle``. 

