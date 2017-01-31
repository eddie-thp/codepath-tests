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
	    ListNode start = a;
	    
	    ListNode current = a;
	    int count = 1;
	    while (current.next != null) {
	        count++;
	        current = current.next;
	    }
	    
	    ListNode last = current;
	    b = b % count; // In case counter is larger than the list

        if (b > 0) {
            last.next = start;
            
            current = a;
            int rotateAt = count - b;
            for(int i = 1; i < rotateAt; i++) {
                current = current.next;
            }
            
            start = current.next;
            current.next = null;
            
        }
	    
	    return start;
	}
}