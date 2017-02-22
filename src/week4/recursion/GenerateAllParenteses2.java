package week4.recursion;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/generate-all-parentheses-ii/
 * <pre>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * Make sure the returned list of strings are sorted.
 * </pre>
 */
public class GenerateAllParenteses2 {

	public static void main(String[] args) {
		GenerateAllParenteses2 p = new GenerateAllParenteses2();

		System.out.println(p.generateParenthesis(1));
		System.out.println(p.generateParenthesis(2));
		System.out.println(p.generateParenthesis(3));

	}

	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> results = new ArrayList<String>();

		generate(n, 0, 0, results, "");

		return results;
	}

	void generate(int n, int openCount, int closeCount, ArrayList<String> result, String prevString) {

		if (n == openCount && n == (closeCount + 1)) {
			prevString += ")";
			result.add(prevString);
		} else {
			if (openCount <= closeCount) {
				generate(n, openCount + 1, closeCount, result, prevString + "(");
			} else {
				if (openCount < n) {
					generate(n, openCount + 1, closeCount, result, prevString + "(");
				}
				generate(n, openCount, closeCount + 1, result, prevString + ")");
			}
		}
	}
}
