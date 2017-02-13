package week4.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/permutations/
 * <pre>
 * Given a collection of numbers, return all possible permutations.
 * 
 * Example:
 * 
 * [1,2,3] will have the following permutations:
 * 
 * [1,2,3]
 * [1,3,2]
 * [2,1,3] 
 * [2,3,1] 
 * [3,1,2] 
 * [3,2,1]
 *  NOTE
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * 
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * 		Example : next_permutations in C++ / itertools.permutations in python.
 * 		If you do, we will disqualify your submission retroactively and give you penalty points. 
 * </pre> 
 */
public class Permutation {

	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3};
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(arr));
		System.out.println(new Permutation().permute(a));
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (Integer n : a) {
			ArrayList<Integer> next = new ArrayList<Integer>(a);
			next.remove(n);

			ArrayList<ArrayList<Integer>> resultNext = permute(next);
			if (resultNext.isEmpty()) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(n);
				result.add(list);
			} else {
				for (ArrayList<Integer> list : resultNext) {
					list.add(0, n);
					result.add(list);
				}
			}
		}

		return result;
	}
}
