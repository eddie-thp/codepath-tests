package week1.challenges;

/**
 * https://www.interviewbit.com/problems/length-of-last-word/
 * <pre>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * Example:
 * 
 * Given s = "Hello World",
 * 
 * return 5 as length("World") = 5.
 * 
 * Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 * </pre>
 *
 */
public class Challenge7 {
	public static void main(String args[]) {
		Challenge7 c = new Challenge7();
	}

	public int lengthOfLastWord(final String a) {
		int size = 0;
		for (int i = a.length() - 1; i >= 0; i--) {
			if (a.charAt(i) == ' ') {
				if (size > 0) {
					break;
				}
			} else {
				size++;
			}
		}
		return size;
	}
}
