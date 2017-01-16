import java.util.ArrayList;
import java.util.List;
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
		// 2nd attempt failed during this edge case
		System.out.println("Result: " + c.longestConsecutive(a));
	}

	public int longestConsecutive(final List<Integer> a) {

        int longest = 0;
        List<TreeSet<Integer>> sequences = new ArrayList<TreeSet<Integer>>();
	    for (int i = 0; i < a.size(); i++) {
            int n = a.get(i);	        
            
            TreeSet<Integer> sequence = new TreeSet<Integer>();
            sequence.add(n);

            boolean inserted = false;
            if (sequences.size() > 0)
            {
                for (TreeSet<Integer> existingSequence : sequences)
                {
                    int first = existingSequence.first();
                    int last = existingSequence.last();

                    // Is n before 1st ?
                    if (n + 1 == first) {
                        existingSequence.addAll(sequence);
                        sequence = existingSequence;
                        inserted = true;
                    } 
                    // Is n after last ?
                    else if (n - 1 == last) {
                        existingSequence.addAll(sequence);
                        sequence = existingSequence;
                        inserted = true;
                    }
                }
            }
            
            if (!inserted) {
                sequences.add(sequence);
            }
            
            if (sequence.size() > longest) {
                longest = sequence.size();
            }
	    }
	    
	    return longest;
	}
}
