package week2.challenges;

import static week2.challenges.LinkedListUtils.*;

/**
 * https://www.interviewbit.com/problems/add-two-numbers-as-lists/
 * https://courses.codepath.com/courses/interview_prep/unit/2#!challenges
 * Challenge 2:
 *
 * <pre>
 * In this exercise, we'll use your LinkedListNode implementation to represent 
 * a non-negative integer such that each node in the list represents 
 * a single digit (in base 10) and the digits are stored in reverse order.
 *
 * 1     == 1
 * 1→2   == 21
 * 1→2→3 == 321
 * Write a program which takes as its input two such lists, a and b, and adds them arithmetically one decimal at a time. Your algorithm should traverse both lists together, adding the values for each node and carrying the 1 to the next place when the sum >= 10. The result should be returned as a linked list in the same format as the input lists.
 *
 * Examples:
 *
 * 1→2     +   5→3   == 6→5      // 21 + 35 == 56
 * 1→2     +   1→2→3 == 2→4→3    // 21 + 321 == 342
 * 1→2→3   +   7→8→9 == 8→0→3→1  // 321 + 987 == 1308
 * </pre>
 */
public class LinkedListSum {

	public static void main(String[] args) {
		LinkedListNode<Integer> a = new LinkedListNodeImpl<Integer>();
		Integer[] av = { 1, 2, 3 };
		a.setValuesFromArray(av);
		
		Integer[] bv = { 7, 8, 9 };
		LinkedListNode<Integer> b = new LinkedListNodeImpl<Integer>();
		b.setValuesFromArray(bv);

		LinkedListNode<Integer> result = sum(a, b);

		System.out.print("Linked List: ");
		printLinkedList(result, "->");
		System.out.println();
		
		System.out.print("Linked List SUM: ");
		printLinkedListReverse(result, "");
		System.out.println();

	}

	static LinkedListNode<Integer> sum(LinkedListNode<Integer> a, LinkedListNode<Integer> b) {
		LinkedListNode<Integer> sum = new LinkedListNodeImpl<Integer>();
		sum.setValue(0);

		LinkedListNode<Integer> c = sum;
		int carryOver = 0;
		while (a != null || b != null) {
			int aVal = (a != null ? a.getValue() : 0);
			int bVal = (b != null ? b.getValue() : 0);

			int cVal = aVal + bVal + carryOver;
			carryOver = cVal/10;
			cVal = cVal % 10;

			c.setValue(cVal);

			if (a != null) {
				a = a.getNext();
			}
			if (b != null) {
				b = b.getNext();
			}
			
			if (a == null && b == null) {
				// Handles exit condition
				if (carryOver == 1) {
					c.setNext(new LinkedListNodeImpl<Integer>());
					c = c.getNext();
					c.setValue(carryOver);
				} 
			} else {
				c.setNext(new LinkedListNodeImpl<Integer>());
				c = c.getNext();
			}
		}

		return sum;
	}

}
