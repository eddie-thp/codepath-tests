package week3.binarySearch;

/**
 * <pre>
 * Implement pow(x, n) % d.
 * 
 * In other words, given x, n and d,
 * 
 * find (xn % d)
 * 
 * Note that remainders on division cannot be negative. 
 * In other words, make sure the answer you return is non negative.
 * 
 * Input : x = 2, n = 3, d = 3
 * Output : 2
 * 
 * 2^3 % 3 = 8 % 3 = 2.
 * </pre>
 * 
 * <pre>
 * HINT:
 * There are two major things to note here:
 * 
 * 1) Overflow situation: Note that if x is large enough, multiplying x to the answer might overflow in integer.
 * 
 * 2) Multiplying x one by one to the answer is O(x). We are looking for something better than O(x).
 * 
 * If n is even, note the following:
 * 
 * x ^ n = (x * x) ^ n/2
 * 
 * Can you use the above observation to come up with a solution better than O(x)?
 * </pre>
 */
public class ImplementPowerFunction {

	public static void main(String[] args) {
		ImplementPowerFunction p = new ImplementPowerFunction();
		
		int x = 71045970;
		int n = 41535484;
		int d = 64735492;
		
		System.out.println(p.pow(x, n, d));
	}
	
	public int pow(int x, int n, int d) {
	    if (n == 0) return 1 % d;
	    
	    long result = 1;
	    long base = x;
	    
	    while (n > 0) {
	        if (n % 2 == 1) {
	            result = (result * base) % d;
	            n--;
	        } else {
	            base = (base * base) % d;
	            n /= 2;
	        }
	    }
	    
	    if (result < 0) result = (result + d) % d;
	    return (int) result;
	}

}
