import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Given a singly linked list, modify the value of first half nodes such that :
 * 
 * 1st node’s new value = the last node’s value - first node’s current value
 * 2nd node’s new value = the second last node’s value - 2nd node’s current value,
 * and so on …
 * 
 * NOTE : 
 * - If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes. 
 * - If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes. 
 * Example :
 * 
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5,
 * 
 * You should return 4 -> 2 -> 3 -> 4 -> 5
 * as
 * 
 * for first node, 5 - 1 = 4
 * for second node, 4 - 2 = 2
 * Try to solve the problem using constant extra space.
 * </pre>
 */
public class Checkpoint4_1 {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		Checkpoint4_1 chk = new Checkpoint4_1();
		ListNode result = chk.subtract(a);
		
		
		while (result != null) {
			System.out.print(result.val + " => ");
			result = result.next;
		}
		
		
	}

	public ListNode subtract(ListNode a) {
		List<Integer> values = new ArrayList<Integer>();

		ListNode processing = a;

		// 1st Add values to a list
		values.add(a.val);
		while (processing.next != null) {
			processing = processing.next;
			values.add(processing.val);
		}

		int half = values.size() / 2;

		ListNode change = a;
		for (int i = 0; i < half; i++) {
			int v = values.get(values.size() - 1 - i);
			change.val = v - change.val;
			change = change.next;
		}

		return a;
	}

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

