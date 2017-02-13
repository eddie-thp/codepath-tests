package week4.recursion;

import java.math.BigInteger;

/**
 * https://courses.codepath.com/courses/interview_prep/unit/4#!challenges
 * <pre>
 * The factorial of n is the product of all integers between 1 and n.
 * For example, the factorial of 5 is computed as follows: 5*4*3*2*1 == 120.
 * 
 * Write a program that takes as its input a java.math.BigInteger and 
 * returns a java.math.BigInteger equal to the factorial of the input.
 * 
 * Hint: this can be implemented using a single static method with only one line of code.
 * </pre>
 */
public class Factorial {

	public static void main(String[] args) {
		Factorial p = new Factorial();
		
		System.out.println(p.factorial(BigInteger.valueOf(5)));

	}
	
	public BigInteger factorial(BigInteger n) {
		BigInteger one = BigInteger.valueOf(1);
		
		if (one.compareTo(n) >= 0) {
			return one;
		} else {
			return n.multiply(factorial(n.subtract(one)));	
		}
		
	}

}
