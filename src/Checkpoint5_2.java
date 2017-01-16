import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * Example: 
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * </pre>
 */
public class Checkpoint5_2 {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(100);
		a.add(4);
		a.add(200);
		a.add(1);
		a.add(3);
		a.add(2);

		Checkpoint5_2 c = new Checkpoint5_2();
		System.out.println("Result: " + c.longestConsecutive(a));

		a.clear();
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(2);
		a.add(3);
		a.add(3);
		a.add(4);
		a.add(4);
		a.add(5);
		a.add(5);
		System.out.println("Result: " + c.longestConsecutive(a));
	}

	/**
	 * If you look at the src control history, there were 6 attempts to solve this exercise
	 * 2rd and 4th failed due to the same edge case (duplicate numbers in the input)
	 * 3rd and 5th failed due to efficiency issues
	 * 6th solves efficiency with the use of Java TreeSet implementation for sorting
	 *  
	 * @param a
	 * @return
	 */
	public int longestConsecutive(final List<Integer> a) {

		Set<Integer> sa = new TreeSet<Integer>(a);

		int longestSize = 1;

		int previousN = 0;
		int currentSize = 0;
		int count = 0;
		for (Integer n : sa) {

			if (count > 0 && n != previousN + 1) {
				// Sequence has changed
				if (currentSize > longestSize) {
					longestSize = currentSize;
				}
				currentSize = 0;
			}
			previousN = n;
			++currentSize;
			++count;
		}

		if (currentSize > longestSize) {
			longestSize = currentSize;
		}

		return longestSize;
	}
}
