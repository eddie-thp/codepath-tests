package week2.challenges.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://courses.codepath.com/courses/interview_prep/unit/2#!challenges
 * 
 * <pre>
 * Challenge 4:
 * Write a program which takes as its input a String of natural language text and outputs a HashMap<String,Integer> 
 * whose keys are the unique words in the input and whose values are the number of times those words occur.
 * 
 * The algorithm should be case-insensitive (e.g. "Program" and "program" would count as the same word) and ignore punctuation and whitespace.
 * 
 * Example: Given the input "To be or not to be, that is the question", 
 * the outputted HashMap would contain 8 entries, with two words having a count of 2 and six words having a count of 1:
 * </pre>
 *
 */
public class WordCount {

	public static void main(String[] args) {
		String a = "To be or not to be, that is the question";

		Map<String, Integer> wordCounts = (new WordCount()).countWords(a);
		
		for (Entry<String, Integer> wordCount : wordCounts.entrySet()) {
			System.out.println(String.format("%s : %d", wordCount.getKey(), wordCount.getValue()));
		}
	}

	public Map<String, Integer> countWords(String a) {
		Map<String, Integer> wordCounts = new HashMap<String, Integer>();

		StringBuilder builder = null;
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				if (builder == null) {
					builder = new StringBuilder();
				}
				builder.append(c);
			} else {
				if (builder != null) {
					String word = builder.toString();
					builder = null;

					addWordCount(word, wordCounts);
				}
			}
		}
		if (builder != null) {
			addWordCount(builder.toString(), wordCounts);
		}
		return wordCounts;
	}

	public void addWordCount(String word, Map<String, Integer> wordCounts) {
		word = word.toLowerCase();
		int count = 1;
		if (wordCounts.containsKey(word)) {
			count += wordCounts.get(word);
		}
		wordCounts.put(word, count);
	}

}
