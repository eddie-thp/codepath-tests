package week4.recursion;

/**
 * https://www.interviewbit.com/problems/greatest-common-divisor/
 * <pre>
 * Given 2 non negative integers m and n, find gcd(m, n)
 * 
 * GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
 * Both m and n fit in a 32 bit signed integer.
 * 
 * Example
 * 
 * m : 6
 * n : 9
 * 
 * GCD(m, n) : 3 
 * NOTE : DO NOT USE LIBRARY FUNCTIONS 
 * </pre>
 */
public class GreatestCommonDivisor {

	public static void main(String args[]) {
		GreatestCommonDivisor p = new GreatestCommonDivisor();
		
		System.out.println(p.gcd(24, 54));
	}
	
	public int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}