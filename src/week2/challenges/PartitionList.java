package week2.challenges;

import week2.linkedList.ListNode;

/**
 * https://www.interviewbit.com/problems/partition-list/
 * <pre>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * </pre> 
 */
public class PartitionList {

	public static void main(String[] args) {
		// 1->4->3->2->5->2
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(2);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		PartitionList p = new PartitionList();
		ListNode r = p.partition(a, 3);
		
		while (r != null) {
			System.out.print(r.val + " -> ");
			r = r.next;
		}

	}
	
	public ListNode partition(ListNode a, int b) {
	    ListNode partitionAt = null;
	    ListNode previous = null;
	    ListNode current = a;
	    while (current != null) {
	        if (current.val < b) {
	            if ( previous == null || previous.val < b ) {
	                partitionAt = current;
	            } else {
	                if (partitionAt == null) {
	                    partitionAt = current;
	                    previous.next = current.next;
	                    current.next = a;
	                    a = current;
	                    current = previous;
	                } else {
	                    previous.next = current.next;
	                    current.next = partitionAt.next;
	                    partitionAt.next = current;
	                    partitionAt = current;
	                    current = previous;
	                }
	            }
	        }
	        
    	    previous = current;
	        current = current.next;
	    }
	    return a;
	}
}
