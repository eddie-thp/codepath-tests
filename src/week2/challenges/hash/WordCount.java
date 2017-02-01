package week2.challenges.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
 * 
 * </pre>
 * 
 * <pre>
 * Challenge 5:
 * One common pattern when using hash tables requires building a Map whose values are Collection instances. In this challenge, we'll take the output of the previous challenge and invert it.
 * 
 * Write a program that takes as its input a HashMap<String,Integer> and returns a HashMap<Integer,HashSet<String>> containing the same data as the input map, only inverted, such that the input map's values are the output map's keys and the input map's keys are the output map's values.
 * 
 * Example:
 * 
 * Consider the example output for Challenge #4. Using that map as the input, the output for this challenge would be:
 * </pre>
 *
 */
public class WordCount {

	public static void main(String[] args) {
		String a = "To be or not to be, that is the question";

		WordCount counter = new WordCount();
		Map<String, Integer> wordCounts = counter.countWords(a);
		
		for (Entry<String, Integer> wordCount : wordCounts.entrySet()) {
			System.out.println(String.format("%s : %d", wordCount.getKey(), wordCount.getValue()));
		}
		
		System.out.println("################");
		
		Map<Integer, Set<String>> multiMap = counter.multiMap(wordCounts);
		for (Entry<Integer, Set<String>> multiMapEntry : multiMap.entrySet()) {
			Integer count = multiMapEntry.getKey();
			Set<String> words = multiMapEntry.getValue();
			System.out.println(String.format("%d : %s", count, words));
		}
	}
	
	public Map<Integer, Set<String>> multiMap(Map<String, Integer> wordCounts) {
		Map<Integer, Set<String>> multiMap = new HashMap<Integer, Set<String>>();
		for (Entry<String, Integer> wordCount : wordCounts.entrySet()) {
			String word = wordCount.getKey();
			Integer count = wordCount.getValue();
			
			Set<String> words = null;
			
			if (!multiMap.containsKey(count)) {
				words = new HashSet<String>();
				multiMap.put(count, words);
			} else {
				words = multiMap.get(count);
			}
			
			words.add(word);
		}
		return multiMap;
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
