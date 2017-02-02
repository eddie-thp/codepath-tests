package week3.binarySearch;

/**
 * https://www.interviewbit.com/problems/square-root-of-integer/
 * 
 * # Solution from Elements of Programming Interview in Java (p. 196)
 * <pre>
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * If x is not a perfect square, return floor(sqrt(x))
 * 
 * Example :
 * 
 * Input : 11
 * Output : 3
 * DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 * </pre>
 */
public class IntegerSquareRoot {

	public static void main(String[] args) {
		System.out.println("SQRT: " + (new IntegerSquareRoot()).sqrt(234));
	}
	
	public int sqrt(int a) {
	    long left = 0;
	    long right = a;
	    
	    while (left <= right) {
	        long mid = left + ((right - left) / 2);
	        long midSquared = mid * mid;
	        
	    	System.out.println(String.format("left, right: [%d, %d] => mid (%d) mid * mid^2 (%d)", left, right, mid, midSquared));
	        
	        if (midSquared <= a) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    
	    return (int) (left - 1);
	}
}
