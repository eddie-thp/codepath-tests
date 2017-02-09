package week4.recursion;

import week2.linkedList.ListNode;

/**
 * https://www.interviewbit.com/problems/reverse-link-list-recursion/
 * <pre>
 * Reverse a linked list using recursion.
 * 
 * Example :
 * Given 1->2->3->4->5->NULL,
 * 
 * return 5->4->3->2->1->NULL.
 * 
 * PROBLEM APPROACH :
 * 
 * Complete solution code in the hints
 * </pre>
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		int[] nodesArr = {1, 2, 3, 4, 5};
		ListNode root = ListNode.fromArray(nodesArr);
		
		ListNode reverse = new ReverseLinkedList().reverseList(root);

		while(reverse != null) {
			System.out.print(reverse.val + " -> ");
			reverse = reverse.next;
		}
	}
	
	public ListNode reverseList(ListNode a) {
	    return reverseNodes(null, a);
	}
	
	public ListNode reverseNodes(ListNode previous, ListNode current) {
	    ListNode temp = current.next;
	    current.next = previous;
	    if (temp != null) {
    	    return reverseNodes(current, temp);
	    } else {
	        return current;
	    }
	}

}
