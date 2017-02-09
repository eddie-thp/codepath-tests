package week2.linkedList;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	public static ListNode fromArray(int[] nodeArray) {
		ListNode root = null;
		ListNode previous = null;
		for (int i = 0; i < nodeArray.length; i++) {
			ListNode node = new ListNode(nodeArray[i]);
			if (i == 0) {
				root = node;
			} else {
				previous.next = node;
			}
			previous = node;
		}
		return root;
	}
}
