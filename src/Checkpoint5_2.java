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
	}

	public int longestConsecutive(final List<Integer> a) {
	    
	    List<Integer> longestSequence = null;
	    List<Integer> currentSequence = new ArrayList<Integer>();
	    int lastN = 0;
	    for (int i = 0; i < a.size(); i++) {
	        int currentN = a.get(i);
	        // Check if the sequence has changed;
	        if (i > 0 && lastN+1 != currentN)
	        {
	            // New Sequence
	            if (longestSequence == null || longestSequence.size() < currentSequence.size())
	            {
	                longestSequence = currentSequence;
	                currentSequence = new ArrayList<Integer>();
	            }
	        }
	        
            currentSequence.add(currentN);
            lastN = currentN;
	    }
	    
        if (currentSequence.size() > longestSequence.size())
        {
            longestSequence = currentSequence;
        }
	    return longestSequence.size();
	}
}
