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
		System.out.println("Result: " + c.longestConsecutive(a));
	}

	public int longestConsecutive(final List<Integer> a) {

        int longest = 0;
        List<int[]> sequences = new ArrayList<int[]>();
	    for (int i = 0; i < a.size(); i++) {
            int n = a.get(i);	        
            
            int[] sequenceRange = new int[2];
            sequenceRange[0] = n;
            sequenceRange[1] = n;

            boolean inserted = false;
            if (sequences.size() > 0)
            {
                for (int[] existingSequence : sequences)
                {
                    int first = existingSequence[0];
                    int last = existingSequence[1];
                    
                    if (n == first || n == last) {
                        // Ignore number that has already been processed
                        sequenceRange = existingSequence;
                        inserted = true;
                        break;
                    }

                    // Is n before 1st ?
                    if (n + 1 == first) {
                        existingSequence[0] = sequenceRange[0];
                        sequenceRange = existingSequence;
                        inserted = true;
                    } 
                    // Is n after last ?
                    else if (n - 1 == last) {
                        existingSequence[1] = sequenceRange[1];
                        sequenceRange = existingSequence;
                        inserted = true;
                    }
                }
            }
            
            if (!inserted) {
                sequences.add(sequenceRange);
            }
            
            int sRangeSize = (sequenceRange[1] - sequenceRange[0]) + 1;
            if (sRangeSize > longest) {
                longest = sRangeSize;
            }
	    }
	    
	    return longest;
	}
}
