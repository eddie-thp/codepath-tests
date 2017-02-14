package week4.bits;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Given an array of integers, every element appears thrice except for one which occurs once.
 * 
 * Find that element which does not appear thrice.
 * 
 * Note: Your algorithm should have a linear runtime complexity.
 * 
 * Could you implement it without using extra memory?
 * 
 * Example :
 * 
 * Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 * Output : 4
 * </pre>
 */
public class SingleNumber2 {

	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3, 3, 2, 2, 3, 1, 1, 4, 5, 5, 5, 6, 7, 6, 7, 6, 7, 9, 9, 9};
		List<Integer> a = Arrays.asList(arr);
		
		System.out.println(new SingleNumber2().singleNumber(a));
	}
	
	public int singleNumber(final List<Integer> a) {
	    int[] bits = new int[32];
	    
	    for (int i = 0 ; i < 32; i++) {
	        bits[i] = 0;
	    }
	    
	    
	    int result = 0;
	    for (int n : a) {
    	    for (int i = 0 ; i < 32; i++) {
    	        if (getBit(i, n) == 1) {
	                bits[i] = bits[i]+1;
    	        }
	        }
	    }
	    
	    for (int i = 31 ; i >= 0; i--) {
	        if (bits[i]%3 == 1) {
	        	result ^= (int) Math.pow(2, i);
	        }
	    }
	    return result;
	}
	
	public int getBit(int index, long n) {
	    return (int) (n >> index) & 1;
	}

}
