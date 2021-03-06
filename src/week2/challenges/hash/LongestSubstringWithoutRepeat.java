package week2.challenges.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/longest-substring-without-repeat/
 * <pre>
 * Given a string, 
 * find the length of the longest substring without repeating characters.
 * 
 * Example:
 * 
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * </pre>
 */
public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		String a = "u";
		String b = "dadbc";
		String c = "ExIa3DhLjq21FC2aV2dwUtnKydCCsAuX5Nzy4vkVyErPKlpPa7u0iVuHOsVHVXRIOVcmtXd34xoL9xTMEFq6eVJZbK6ExQXKjLxbEUEv5cqrnVWgUe6Um5FFIIxr8W1YhtAz6x2ZdocAVLMoY4Ocfz6N0HZrGO1UYYkBGAQA9m8OPOGXgZxwD4uGNcTZ8exN4eSoC6Enfo4da5UEeuLqR88LPfQdY8EAbRFpknLuqQo9FH42M6n9h18NM0ZjhMpDJqTyJhrBkzgdrZwTjCjX0EBWVOQY2bECYgI6nAr3BFOxkLeM6xBbsGxDrzOgEIfQNdZbxoRdba1RLZvbDjhir9PrqYJhVrLBLv4MTslKFcK4TRDu1PqotWMwJiSN7z5WYuvT7YiCjoyljdoCdTfjB6PfvpI5nL8gc7BJSX9W2dL7m8PMAH2KCMsFxqMGepeaT2V9z0J40rXmAT42yVD3nY5Ss1fGNaiUkrmVgru3NMGbEWQJvp8S9niJmKsMBxqQYffzU5GDfOkaBrdv72Oje0g4trMwv30WS1ovfMsYIdBBF4fRfpeVosNNTRNJ3QWtPn4z8fIZ3go08eMi444E5cr4NoExxraZ9W4kTtwsq4om5fZ8C8nC16fWOH0suSq9dQWUGbSWJYvQJhN6mDVAQ0V2H9aZMwunqZIXHRKhCEhUWxeLdSiSy39C0SGZvcq78VDd6sDAazC9PM2Ft57OZiwuOyvP0FGkquxIIeUympRbwwJ9yJlcsQz5in3weQqeCz3KVGzsCFLL62aVFbo3PApmcDnSUBSFeaokJ3oPVUTFdIV2jbz05NQq0RJaUB3vvFe7aLAiFSqkGvFQxI78NOwwvcz53kRuAdNvwoiBdLkZjqx3RVflzmzzWPJQmh0x45Dt4UKfwQOXQFkej8tAtX9p8wWrDuL3SV8A7l0ePi3JMkHUYqHvUYV7qcmFFjEEUKoRzh3auP0MV3fl3EyXCwXEILHlS6CBu5mF3sBlWnT6VNUPhvvqaXJ8OUDCrmYvjVEZZlutFc6dW1TtO1Fd47keqrHnfAWJLr7R2XSxBRDbf1NP5mFM5LV8R3DeG4ON1uo1zzQ74gIaAVyAHClSodVkJOL6RmpMJrVcxFFHQsQOeDzcqxWNOzl3gWb4Z7DWGsbX41l4WAVuSvL6N1p3LM5TW79hk2xhbu0uZpCGbWpDfmcBo8wTsHCS84QphhBE";
		System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring(a));
		System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring(b));
		System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring(c));
	}

	public int lengthOfLongestSubstring(String a) {
		int aLength = a.length();

		int longest = 0;
		if (!a.isEmpty()) {
			for (int i = 0; i < aLength; i++) {
				Set<Character> charSet = new HashSet<Character>();

				if (longest > (aLength - i)) {
					break;
				}

				for (int j = i; j < aLength; j++) {
					Character c = a.charAt(j);
					if (charSet.contains(c)) {
						break;
					}
					charSet.add(c);
				}

				int charSetSize = charSet.size();
				if (charSetSize > longest) {
					longest = charSetSize;
				}
			}
		}
		return longest;
	}
}
