package week4.bits;

/**
 * https://www.interviewbit.com/problems/number-of-1-bits/
 * <pre>
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 * 
 * Example:
 * 
 * The 32-bit integer 11 has binary representation
 * 
 * 00000000000000000000000000001011
 * so the function should return 3.
 * 
 * Note that since Java does not have unsigned int, use long for Java
 * </pre>
 */
public class NumberOf1Bits {

	public static void main(String[] args) {
		System.out.println(new NumberOf1Bits().numSetBits(4));
		System.out.println(new NumberOf1Bits().numSetBits(0x40000000));
		System.out.println(new NumberOf1Bits().numSetBits(0xF0000000));
		System.out.println(new NumberOf1Bits().numSetBits(0xF000000F));
	}
	
	public int numSetBits(long a) {
	    int count = 0;
	    long val = a;
        for (int i = 0; i < 32; ++i) {
            if ((val & 0x00000001) == 0x00000001) {
                count++;
            }

            val = val >> 1;
        }
        return count;
	}

}
