package week1.challenges;

/**
 * https://www.interviewbit.com/problems/implement-strstr/
 * 
 * <pre>
 * Please Note:
 * 
 * Another question which belongs to the category of questions which are intentionally stated vaguely. 
 * Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.
 * 
 * Implement strStr().
 * 
 * trstr - locate a substring ( needle ) in a string ( haystack ). 
 *   Try not to use standard library string functions for this question.
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
  * NOTE: Good clarification questions:
 *   What should be the return value if the needle is empty?
 *   What if both haystack and needle are empty?
 *   For the purpose of this problem, assume that the return value should be -1 in both cases. 
 * </pre>
 */
public class Challenge11 {

	public static void main(String[] args) {
		Challenge11 c = new Challenge11();
		
		System.out.println("index: " + c.strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));
		System.out.println("index: " + c.strStr("ab ", "b"));
		System.out.println("index: " + c.strStr("ba ", "b"));
		System.out.println("index: " + c.strStr("", ""));
		System.out.println("index: " + c.strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", ""));

	}

	public int strStr(final String haystack, final String needle) {
		if (needle.isEmpty()) {
			return 0;
		}

		if (needle.length() > haystack.length()) {
			return -1;
		}

		int nIndex = 0;
		int hIndex = 0;
		for (; hIndex < haystack.length() && nIndex < needle.length(); hIndex++) {
			char hc = haystack.charAt(hIndex);
			char nc = needle.charAt(nIndex);

			if (hc != nc) {
				if (nIndex > 0) {
					// reset search
					hIndex = hIndex - nIndex; // The trick piece is that I have to reset the hIndex if I find a mismatch
					nIndex = 0;
				}
				continue;
			} else {
				nIndex++;
			}
		}

		if (hIndex == haystack.length() && hIndex != nIndex) {
			return -1;
		}

		return hIndex - needle.length();
	}
}
