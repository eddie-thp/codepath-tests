package week4.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * https://www.interviewbit.com/problems/subset/
 * <pre>
 * Subset
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 *  Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 * Example :
 * 
 * If S = [1,2,3], a solution is:
 * 
 * [
 *   [],
 *   [1],
 *   [1, 2],
 *   [1, 2, 3],
 *   [1, 3],
 *   [2],
 *   [2, 3],
 *   [3],
 * ]
 * </pre>
 */
public class Subset {

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3};
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));
		
		System.out.println(new Subset().subsets(a));

	}
	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
	    Collections.sort(a);

	    ArrayList<ArrayList<Integer>> subsets = subsets(0, a);

        subsets.add(0, new ArrayList<Integer>());

	    return subsets;
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int index, ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();    
        
	    if (index < a.size()) {
	        
	        int val = a.get(index);
	        
	        ArrayList<Integer> valSubset = new ArrayList<Integer>();
	        valSubset.add(val);
	        subsets.add(valSubset);


	        ArrayList<ArrayList<Integer>> nextSubsets = subsets(index + 1, a);
            for (ArrayList<Integer> nextSubset : nextSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.add(val);
                newSubset.addAll(nextSubset);
                subsets.add(newSubset);
	        }
	        
	        subsets.addAll(nextSubsets);
	    }
        
        return subsets;
	}

}
