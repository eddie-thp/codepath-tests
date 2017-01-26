package week2.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/anagrams/
 * <pre>
 * Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.
 * 
 * Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
 * Note: All inputs will be in lower-case. 
 * Example :
 * 
 * Input : cat dog god tca
 * Output : [[1, 4], [2, 3]]
 * cat and tca are anagrams which correspond to index 1 and 4. 
 * dog and god are another set of anagrams which correspond to index 2 and 3.
 * The indices are 1 based ( the first element has index 1 instead of index 0).
 * 
 * Ordering of the result : You should not change the relative ordering of the words / phrases
 * </pre>
 */
public class Anagrams {

	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		
		List<String> l = new ArrayList<String>();
		l.add("cat");
		l.add("dog");
		l.add("god");
		l.add("tca");
		System.out.println(a.anagrams(l));

	}

	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    Map<List<Character>, ArrayList<Integer>> strings = new HashMap<List<Character>, ArrayList<Integer>>();

        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i);
            
            ArrayList<Character> cList = new ArrayList<Character>();
            for (int j = 0; j < s.length(); j++) {
                cList.add(s.charAt(j));
            }
            
            Collections.sort(cList);
            
            if (!strings.containsKey(cList)) {
                strings.put(cList, new ArrayList<Integer>());
            }
            
            strings.get(cList).add(i + 1);
        }
        
        return new ArrayList<ArrayList<Integer>>(strings.values());
	}
}
