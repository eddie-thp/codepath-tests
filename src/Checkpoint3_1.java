import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Find the kth smallest element in an unsorted array of non-negative integers.
 * 
 * Definition of kth smallest element
 * 
 * kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
 * In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based ) 
 * NOTE
 * You are not allowed to modify the array ( The array is read only ). 
 * Try to do it using constant extra space.
 * 
 * Example:
 * 
 * A : [2 1 4 3 2]
 * k : 3
 * 
 * answer : 2
 * </pre>
 */
public class Checkpoint3_1 {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(1);
		a.add(4);
		a.add(3);
		a.add(2);

		Checkpoint3_1 c = new Checkpoint3_1();
		System.out.println("Answer: " + c.kthsmallest(a, 3));
	}

	public int kthsmallest(final List<Integer> a, int k) {
	    List<Integer> kList = new ArrayList<Integer>();
	    
        for (int i = 0; i < a.size(); i++) {
            Integer n = a.get(i);

            boolean inserted = false;
            for (int j = 0; j < k && j < kList.size(); j++) {
                if (n < kList.get(j)) {
                    inserted = true;
                    kList.add(j, n);
                    break;
                }
            }
            
            if (inserted != true && kList.size() < k)
            {
                kList.add(n);
            }
	    }
	    
	    return kList.get(k - 1);
	}
}
