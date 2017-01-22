package week1.challenges;

/**
 * https://www.interviewbit.com/problems/palindrome-string/
 * 
 * <pre>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * Example:
 * 
 * "A man, a plan, a canal: Panama" is a palindrome.
 * 
 * "race a car" is not a palindrome.
 * 
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * </pre>
 *
 */
public class Challenge4 {
	public static void main(String args[]) {
		Challenge4 c = new Challenge4();
		
		System.out.println("is palindrome ? " + (c.isPalindrome("A man, a plan, a canal: Panama") == 1));
		System.out.println("is palindrome ? " + (c.isPalindrome("race a car") == 1));
	}
	
	public int isPalindrome(String a) {
	    a = a.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
	    
	    int aSize = a.length();
	    
	    for (int i = 0; (i+1) <= (aSize/2); i++) {
	    	if (a.charAt(i) != a.charAt(aSize - 1 - i)) {
	    		return 0;
	    	}
	    }
	    
	    return 1;
	}

}
