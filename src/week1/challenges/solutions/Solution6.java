package week1.challenges.solutions;

import java.util.ArrayList;

// Longest Common Prefix
// https://www.interviewbit.com/problems/longest-common-prefix
public class Solution6 {
	public String longestCommonPrefix(ArrayList<String> A) {

		if (A.size() == 0)
			return "";

		String str;
		String res = "";
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); i++) {
			min = Math.min(min, A.get(i).length());
		}

		for (int i = 0; i < min; i++) {

			char c = A.get(0).charAt(i);

			for (int j = 1; j < A.size(); j++) {

				if (c != A.get(j).charAt(i))
					return res;

			}

			res += c;

		}

		return res;

	}
}