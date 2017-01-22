package week1.challenges;

/**
 * 
 * <pre>
 * https://www.interviewbit.com/problems/longest-palindromic-substring/
 * 
 * Given a string S, find the longest palindromic substring in S.
 * 
 * Substring of string S:
 * 
 * S[i...j] where 0 <= i <= j < len(S)
 * 
 * Palindrome string:
 * 
 * A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
 * 
 * Incase of conflict, return the substring which occurs first ( with the least starting index ).
 * 
 * Example :
 * 
 * Input : "aaaabaaa"
 * Output : "aaabaaa"
 * </pre>
 *
 */
public class Challenge5 {
	public static void main(String args[]) {
		Challenge5 c = new Challenge5();
		
		// Test case 1 - pass
		System.out.println(c.longestPalindrome("aaaabaaa"));
		
		// Test case 2 - 
		System.out.println(c.longestPalindrome("abbcccbbbcaaccbababcbcabca"));
	}

	public String longestPalindrome(String a) {
		int aSize = a.length();
		int currentSize = aSize;
		while (currentSize > 0) {
			for (int i = 0; (i + currentSize) <= aSize; i++) {
				String b = a.substring(i, i + currentSize);
				
				if (isPalindrome(b)) {
					return b;
				}
				
			}
			currentSize--;
		}
		
		return "";
	}
	
	public boolean isPalindrome(String p)
	{
		int pSize = p.length();
		int lastChar = pSize - 1;
		
		for (int i = 0; (i + 1) <= (pSize /2) ; i++) {
			if (p.charAt(i) != p.charAt(lastChar - i)) {
				return false;
			}
		}
		
		return true;
	}
}
