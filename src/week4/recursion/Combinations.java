package week4.recursion;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/combinations/
 * <pre>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
 * 
 * Make sure the combinations are sorted.
 * 
 * To elaborate,
 * 1. Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 * 2. Entries should be sorted within themselves.
 * 
 * Example :
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *   [2,3],
 *   [2,4],
 *   [3,4],
 * ]
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 * Example : itertools.combinations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points. 
 * </pre>
 *
 */
public class Combinations {

	public static void main(String[] args) {
		System.out.println(new Combinations().combine(4, 2));
	}
	
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        return combine(0, n, k);
	}
	
	public ArrayList<ArrayList<Integer>> combine(int index, int n, int k) {
	    ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
	    if (k > 0) {
            for (int i = index; i <= (n - k); i++) {
                ArrayList<ArrayList<Integer>> nc = combine(i + 1, n, k - 1);
                
                if (nc.isEmpty()) {
                    ArrayList<Integer> al = new ArrayList<Integer>();
                    al.add(i+1);
                    combinations.add(al);
                } else {
                    for (ArrayList<Integer> al : nc) {
                        al.add(0, i+1);
                        combinations.add(al);
                    }
                }
                
            }	    
	    }
	    return combinations;
	}

}
