package week2.challenges;

import week2.linkedList.ListNode;

/**
 * https://www.interviewbit.com/problems/rotate-list/
 * 
 * <pre>
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * </pre>
 */
public class RotateRight {

	public static void main(String[] args) {
		// 91 -> 34 -> 18 -> 83 -> 38 -> 82 -> 21 -> 69
		ListNode a = new ListNode(91);
		ListNode b = new ListNode(34);
		ListNode c = new ListNode(18);
		ListNode d = new ListNode(83);
		ListNode e = new ListNode(38);
		ListNode f = new ListNode(82);
		ListNode g = new ListNode(21);
		ListNode h = new ListNode(69);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		
		ListNode r = new RotateRight().rotateRight(a, 89);
		
		while (r != null) {
			System.out.print(r.val + " -> ");
			r = r.next;
		}
		
	}

	public ListNode rotateRight(ListNode a, int b) {

		Storage storage = new Storage();
		storage.first = a;

		traverse(a, b, storage);

		if (storage.newFirst != null) {
			storage.last.next = storage.first;
			storage.beforeNewFirst.next = null;
			a = storage.newFirst;
		}

		return a;
	}

	public int traverse(ListNode current, int b, Storage storage) {
		storage.count++;

		if (current.next != null) {

			int pos = traverse(current.next, b, storage) + 1;

			b = storage.b;

			if (b > 0 && b < storage.count) {
				if (b == pos) {
					// New First
					storage.newFirst = current;
				} else if (b == (pos - 1)) {
					// Before new first
					storage.beforeNewFirst = current;
				}
			}

			return pos;
		} else {
			storage.b = b % storage.count;
			storage.last = current;
			if (storage.b == 1) {
				storage.newFirst = storage.last;
			}
			return 1;
		}
	}
}

class Storage {
	ListNode first;
	ListNode newFirst;
	ListNode beforeNewFirst;
	ListNode last;
	int b;
	int count;
}