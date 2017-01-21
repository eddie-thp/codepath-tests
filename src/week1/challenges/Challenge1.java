package week1.challenges;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <pre>
 * Remove duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
 * 
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * Example: 
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2]. 
 * </pre>
 */
public class Challenge1 {
	public static void main(String args[]) {
		Challenge1 c = new Challenge1();

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		a.add(2);

		System.out.println("New Size: " + c.removeDuplicates(a));
		System.out.println("A: " + a);
	}

	// 1st Implementation was removing duplicates (not efficient)
	// 2nd Implementation process the whole list and moves the "unique" items to the beginning of the list
	// and returns the appropriate size (passed efficiency test)
	public int removeDuplicates(ArrayList<Integer> a) {
	    int total = 0;
	    
        Integer current = null;
		Iterator<Integer> ai = a.iterator();
		while(ai.hasNext()) {
			Integer n = ai.next();
			if (!n.equals(current)) {
				current = n;
				a.set(total, current);
				total++;
			}
		}
		
		return total;
}
}
