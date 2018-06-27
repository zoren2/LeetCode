package com.algorithms.zoren2;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * 557. Reverse Words in a String III
 * 
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: "Let's take LeetCode contest"
 * 
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * Note: In the string, each word is separated by single space and there will
 * not be any extra space in the string.
 * 
 * @author Jack Tsang
 */

public class KeyboardRow {
	public String[] findWords(String[] words) {
		HashSet<Character> row1 = stringToCharHashSet("qwertyuiop");
		HashSet<Character> row2 = stringToCharHashSet("asdfghjkl");
		HashSet<Character> row3 = stringToCharHashSet("zxcvbnm");
		ArrayList<String> res = new ArrayList<String>();
		for (String word : words) {
			if (isValidWordFromRow(row1, word) || isValidWordFromRow(row2, word) || isValidWordFromRow(row3, word)) {
				res.add(word);
			}
		}
		return res.toArray(new String[0]);
	}

	public boolean isValidWordFromRow(HashSet<Character> row, String word) {
		for (char c : word.toCharArray()) {
			if (!row.contains(Character.toLowerCase(c)))
				return false;
		}
		return true;
	}

	// Used to initialize HashSet for each row
	public HashSet<Character> stringToCharHashSet(String s) {
		HashSet<Character> set = new HashSet();
		for (char c : s.toCharArray()) {
			set.add(c);
		}
		return set;
	}
}
