import java.util.ArrayList;

public class Checkpoint4_2 {

	/**
	 * <pre>
	 * Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array. 
	 * More formally,
	 * 
	 * G[i] for an element A[i] = an element A[j] such that 
	 * 	j is minimum possible AND 
	 * 	j > i AND
	 * 	A[j] > A[i]
	 * 
	 * Elements for which no greater element exist, consider next greater element as -1.
	 * 
	 * Example:
	 * 
	 * Input : A : [4, 5, 2, 10]
	 * Output : [5, 10, 10, -1]
	 * 
	 * Example 2:
	 * 
	 * Input : A : [3, 2, 1]
	 * Output : [-1, -1, -1]
	 * </pre>
	 */
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(4);
		a.add(5);
		a.add(2);
		a.add(10);
		
		Checkpoint4_2 c = new Checkpoint4_2();
		ArrayList<Integer> result = c.nextGreater(a);
		System.out.println(result);

	}
	
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    for (int i = 0; i < a.size(); i++) {
	        Integer v = a.get(i);
	        Integer g = -1;
	        for (int j = 1 + i; j < a.size(); j++)
	        {
	            Integer isG = a.get(j);
	            if (isG > v)
	            {
                    g = isG;
	                break;
	            }
	        }
            result.add(g);
	    }
	    return result;
	}

}
