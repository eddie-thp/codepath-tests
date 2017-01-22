package week1.challenges;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * https://www.interviewbit.com/problems/longest-common-prefix/
 * <pre>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 * 
 * As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 * 
 * Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
 * 
 * Example:
 * 
 * Given the array as:
 * 
 * [
 * "abcdefgh",
 * "aefghijk",
 * "abcefgh"
 * ]
 * The answer would be "a".
 * </pre>
 */
public class Challenge6 {
	public static void main(String args[]) {
		Challenge6 c = new Challenge6();

		ArrayList<String> a = new ArrayList<String>();
		a.add("abcd");
		a.add("abcd");
		a.add("efgh");

		System.out.println("Prefix: " + c.longestCommonPrefix(a));
	}

	public String longestCommonPrefix(ArrayList<String> a) {
		StringBuilder prefixBuilder = new StringBuilder();

		int index = 0;
		Character commonChar = null;

		if (a.size() == 1) {
			return a.get(0);
		}

		while (a.size() > 1) {

			if (commonChar != null) {
				prefixBuilder.append(commonChar);
				commonChar = null;
			}

			Iterator<String> aIter = a.iterator();
			while (aIter.hasNext()) {
				String s = aIter.next();

				if (index >= s.length()) {
					return prefixBuilder.toString();
				}

				if (commonChar == null) {
					commonChar = s.charAt(index);
				} else if (commonChar != s.charAt(index)) {
					return prefixBuilder.toString();
				} else {
					continue;
				}
			}
			index++;
		}

		return prefixBuilder.toString();
	}
}
