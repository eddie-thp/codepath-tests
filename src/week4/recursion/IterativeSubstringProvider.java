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
public class IterativeSubstringProvider implements SubstringProvider {

	public static void main(String[] args) {
		SubstringProvider p = new IterativeSubstringProvider();
		
		System.out.println(p.getSubstrings("12345"));
	}

	@Override
	public Collection<String> getSubstrings(String s) {
		List<String> result = new ArrayList<>();
		
		int sLength = s.length();
		for (int i = 0; i < sLength; i++) {
			StringBuilder sBuilder = new StringBuilder();
			for (int j = i; j < sLength; j++) {
				sBuilder.append(s.charAt(j));
				result.add(sBuilder.toString());
			}
		}
		
		return result;
	}

}
