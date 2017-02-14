package week4.bits;

/**
 * <pre>
 * Reverse bits of an 32 bit unsigned integer
 * 
 * Example 1:
 * 
 * x = 0,
 * 
 *           00000000000000000000000000000000  
 * =>        00000000000000000000000000000000
 * return 0
 * 
 * Example 2:
 * 
 * x = 3,
 * 
 *           00000000000000000000000000000011 
 * =>        11000000000000000000000000000000
 * return 3221225472
 * 
 * Since java does not have unsigned int, use long
 * </pre>
 */
public class ReverseBits {

	public static void main(String[] args) {
		
		ReverseBits p = new ReverseBits();
		
		printBinary(p.reverse(0b00000000000000000000000000000011L));
		
	}
	
	public static void printBinary(long a) {
		System.out.println(Long.toBinaryString(a));
	}
	
	public long reverse(long a) {
		int bits = 32;
		
		int left = bits - 1;
		int right = 0;
		for (int i = 0; i < (bits / 2); i++) {
			int leftBit = getBitValue(left, a);
			int rightBit = getBitValue(right, a);
			if ((leftBit ^ rightBit) == 1) {
				// System.out.println("Reverse " + left + " - " + right);
				long setLeftBit = (long) Math.pow(2, left);
				long setRightBit = (long) Math.pow(2, right);
				
				//printBinary(setLeftBit);
				//printBinary(setRightBit);
				
				//printBinary(a);
				a ^= setLeftBit;
				//printBinary(a);
				a ^= setRightBit;
				//printBinary(a);
				

			}
			left--;
			right++;
		}
		
		
		return a;
	}
	
	public int getBitValue(int bitIndex, long n) {
		return (int) (n >> bitIndex) & 1; 
	}
}
