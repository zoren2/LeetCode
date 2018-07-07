package com.algorithms.zoren2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 819. Most Common Word
 * 
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words. It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation. Words in the paragraph are not case sensitive. The answer is in
 * lowercase.
 * 
 * @author Jack Tsang
 */

public class MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) {
		List<String> bannedWords = new ArrayList<String>(Arrays.asList(banned));
		Map<String, Integer> hashmap = new HashMap<String, Integer>();
		String[] words;
		String currentString = ""; // Temporary holder for return statement
		int max = 0;

		// If it's empty, return an empty string
		if (paragraph.length() == 0)
			return "";

		// Replace all string to lower case and remove punctuation
		paragraph = paragraph.replaceAll("\\pP", "").toLowerCase();
		words = paragraph.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (bannedWords.contains(words[i]))
				continue;
			hashmap.put(words[i], hashmap.getOrDefault(words[i], 0) + 1); // Update or Add
			if (hashmap.get(words[i]) > max) {
				max = hashmap.get(words[i]);
				currentString = words[i]; // Updates highest recurring word
			}
		}
		return currentString;
	}
}
