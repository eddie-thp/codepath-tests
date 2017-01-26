package week2.linkedList;

/**
 * https://www.interviewbit.com/problems/reverse-link-list-ii/
 * <pre>
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list.
 * 
 * Note 2:
 * Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 * </pre>
 */
public class ReverseLinkdedList2 {

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
		
		ListNode r = new ReverseLinkdedList2().reverseBetween(a, 2, 4);
		
		while (r != null) {
			System.out.print(r.val + " -> ");
			r = r.next;
		}

	}

	public ListNode reverseBetween(ListNode a, int m, int n) {

		if (m < n) {
			ListNode reversePrevious = null;
			ListNode reverseStart = null;
			ListNode previous = null;
			ListNode current = a;
			for (int i = 1; i <= n; i++) {
				ListNode temp = current.next;

				if (i == m) {
					reversePrevious = previous;
					reverseStart = current;
					current.next = null;
				} else if (i > m) {
					current.next = previous;
				}

				previous = current;
				current = temp;
			}

			reverseStart.next = current;

			if (m == 1) {
				a = previous;
			} else {
				reversePrevious.next = previous;
			}
		}
		return a;
	}
}
