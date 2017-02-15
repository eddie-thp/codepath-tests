package week4.recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * https://courses.codepath.com/courses/interview_prep/unit/4#!challenges
 * <pre>
 * Given the input string 12345, the output of the program would contain the following strings:
 * 
 * [1, 12, 123, 1234, 12345, 2, 23, 234, 2345, 3, 34, 345, 4, 45, 5]
 * </pre>
 */
public class RecursiveSubstringProvider implements SubstringProvider {

	public static void main(String[] args) {
		SubstringProvider p = new RecursiveSubstringProvider();
		System.out.println(p.getSubstrings("12345"));
	}

	@Override
	public Collection<String> getSubstrings(String s) {
		List<String> result = new ArrayList<>();
		addSubstrings(0, s, result);
		return result;
	}
	
	public void addSubstrings(int index, String s, List<String> result) {
		if (index < s.length()) {
			StringBuilder sb = new StringBuilder();
			addSubstrings(index, s, sb, result);
			addSubstrings(index+1, s, result);
		}
	}
	
	public void addSubstrings(int index, String s, StringBuilder sb, List<String> result) {
		if (index < s.length()) {
			sb.append(s.charAt(index));
			result.add(sb.toString());
			addSubstrings(index + 1, s, sb, result);
		}		
	}

}
