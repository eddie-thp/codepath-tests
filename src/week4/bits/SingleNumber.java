package week4.bits;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/single-number/
 * <pre>
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * Example :
 * 
 * Input : [1 2 2 3 1]
 * Output : 3
 * </pre>
 */
public class SingleNumber {

	public static void main(String[] args) {
		Integer[] arr = {1, 2, 2, 3, 1};
		List<Integer> a = Arrays.asList(arr);
		
		System.out.println(new SingleNumber().singleNumber(a));
	}

	public int singleNumber(final List<Integer> a) {
	    int val = a.get(0);
	    for (int i = 1; i < a.size(); i++) {
	        val = val ^ a.get(i);
	    }
	    return val;
	}
}
