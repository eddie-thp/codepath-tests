package week4.recursion;

/**
 * https://courses.codepath.com/courses/interview_prep/unit/4#!challenges
 * <pre>
 * Challenge 4
 * Given the input string 12345, the output of the program would contain the following strings:
 * 
 * [1, 12, 123, 1234, 12345, 2, 23, 234, 2345, 3, 34, 345, 4, 45, 5]
 * </pre>
 */
interface SubstringProvider {
	  java.util.Collection<String> getSubstrings(String s);
}
