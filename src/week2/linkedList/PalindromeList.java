package week2.linkedList;

/**
 * https://www.interviewbit.com/problems/palindrome-list/
 * <pre>
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
 * 
 * Notes: 
 * - Expected solution is linear in time and constant in space.
 * 
 * For example,
 * 
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 * </pre> 
 *
 */
public class PalindromeList {

	public static void main(String[] args) {
		PalindromeList p = new PalindromeList();
		
		ListNode A = new ListNode(6);
		ListNode B = new ListNode(3);
		ListNode C = new ListNode(7);
		ListNode D = new ListNode(3);
		ListNode E = new ListNode(6);
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		
		System.out.println("isPalindrome ? " + (p.lPalin(A) == 1 ? true : false));
		
		ListNode F = new ListNode(1);
		ListNode G = new ListNode(1);
		ListNode H = new ListNode(6);
		ListNode I = new ListNode(4);
		ListNode J = new ListNode(1);
		F.next = G;
		G.next = H;
		H.next = I;
		I.next = J;
		
		System.out.println("isPalindrome ? " + (p.lPalin(F) == 1 ? true : false));

		
		ListNode K = new ListNode(8);
		ListNode L = new ListNode(1);
		K.next = L;

		System.out.println("isPalindrome ? " + (p.lPalin(K) == 1 ? true : false));
	}

	public int lPalin(ListNode A) {
		int count = 0;
		ListNode next = A;
		while (next != null) {
			next = next.next;
			count++;
		}

		if (count > 1) {
			int halfCount = count / 2 + count % 2;
			// Find the middle of the list
			ListNode aMiddle = A;
			for (int i = 0; i < halfCount; i++) {
				aMiddle = aMiddle.next;
			}
			
			// Reverse the 2nd half of the list
			ListNode previous = null;
			while (true) {
				ListNode temp = aMiddle.next;
				aMiddle.next = previous;
				if (temp == null) break;
				previous = aMiddle;
				aMiddle = temp;
			} 

			// Compare 1st half with 2nd half
			ListNode a1 = A;
			ListNode a2 = aMiddle;
			for (int i = 1; i <= halfCount - (count % 2); i++) {
				if (a1.val != a2.val) {
					return 0;
				}
				a1 = a1.next;
				a2 = a2.next;
			}
		}

		return 1;
	}
}

