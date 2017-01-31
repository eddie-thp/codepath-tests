package week2.challenges;

import java.util.HashSet;
import java.util.Set;

import week2.linkedList.ListNode;

/**
 * https://www.interviewbit.com/problems/list-cycle/
 * <pre>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Try solving it using constant additional space.
 * 
 * Example :
 * 
 * Input : 
 * 
 *                   ______
 *                  |     |
 *                  \/    |
 *         1 -> 2 -> 3 -> 4
 * 
 * Return the node corresponding to node 3. 
 * </pre>
 */
public class ListCycle {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = c;
		
		// At this point I don't know if this solution would be accepted
		// Look at:
		// http://stackoverflow.com/questions/2936213/explain-how-finding-cycle-start-node-in-cycle-linked-list-work/36214925#36214925
		
		System.out.println("Cycle: " + new ListCycle().detectCycle(a).val);
	}
	
	public ListNode detectCycle(ListNode a) {
	    ListNode cycle = null;
	    
	    Set<ListNode> nodes = new HashSet<ListNode>();
	    ListNode current = a;
	    while (current != null) {
	        if (nodes.contains(current)) {
	            cycle = current;
	            break;
	        }
	        nodes.add(current);
	        current = current.next;
	    }
	    
	    return cycle;
	}
}
