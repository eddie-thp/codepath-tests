package week2.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/2-sum/
 * <pre>
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. 
 * Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
 * 
 * If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
 * 
 * Input: [2, 7, 11, 15], target=9
 * Output: index1 = 1, index2 = 2
 * </pre>
 */
public class TwoSum {

	public static void main(String[] args) {
		TwoSum c = new TwoSum();

		List a = new ArrayList<Integer>();
		a.add(2);
		a.add(7);
		a.add(11);
		a.add(15);
		
		System.out.println("INDEXES: " + c.twoSum(a, 9));

		List b = new ArrayList<Integer>();
		b.add(4);
		b.add(7);
		b.add(-4);
		b.add(2);
		b.add(2);
		b.add(2);
		b.add(3);
		b.add(-5);
		b.add(-3);
		b.add(9);
		b.add(-4);
		b.add(9);
		b.add(-7);
		b.add(7);
		b.add(-1);
		b.add(9);
		b.add(9);
		b.add(4);
		b.add(1);
		b.add(-4);
		b.add(-2);
		b.add(3);
		b.add(-3);
		b.add(-5);
		b.add(4);
		b.add(-7);
		b.add(7);
		b.add(9);
		b.add(-4);
		b.add(4);
		b.add(-8);
		System.out.println("INDEXES: " + c.twoSum(b, -3));
		
	}

	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
		ArrayList<Integer> operands = new ArrayList<Integer>();

		for (int i = 0; i < a.size() - 1; i++) {
			int n1 = a.get(i);
			for (int j = i + 1; j < a.size(); j++) {
				int n2 = a.get(j);

				if (n1 + n2 == b) {
					if (operands.isEmpty()) {
						operands.add(i + 1);
						operands.add(j + 1);
					} else if (operands.get(1) - 1 > j) {
						operands.set(0, i + 1);
						operands.set(1, j + 1);
					}
					break;
				}
			}
		}

		return operands;
	}
}
