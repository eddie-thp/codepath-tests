package week1.challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-distance/
 * <pre>
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 *
 * If there is no solution possible, return -1.
 *
 * Example :
 *
 * A : [3 5 4 2]
 *
 * Output : 2 
 * for the pair (3, 4)
 * </pre>
 */
// This solution failed due to efficiency problems
public class Challenge9 {

	public static void main(String[] args) {
		Challenge9 c = new Challenge9();

		int arr[] = { 3, 5, 4, 2 };
		List<Integer> a = new ArrayList<Integer>();
		for (int n : arr) {
			a.add(n);
		}
		
		System.out.println("MAX: " + c.maximumGap(a));
	}

	public int maximumGap(final List<Integer> a) {
		int aSize = a.size();
		int max = 0;

		for (int i = 0; i < aSize; i++) {
			int n = a.get(i);

			int savedJ = i;
			for (int j = i + 1; j < aSize; j++) {
				int n2 = a.get(j);

				if (n2 >= n) {
					savedJ = j;
				}
			}

			if (savedJ > i) {
				int diff = savedJ - i;
				if (diff > max) {
					max = diff;
				}
			}
		}
		return max;
	}
}
