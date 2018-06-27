package com.algorithms.zoren2;

/*
 * 557. Reverse Words in a String III
 * 
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1: Input: "Let's take LeetCode contest" Output:
 * "s'teL ekat edoCteeL tsetnoc" Note: In the string, each word is separated by
 * single space and there will not be any extra space in the string.
 * 
 * @author Jack Tsang
 */

public class ReverseString3 {
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		String[] words = s.split(" "); // Split the string then handle each word

		if (s.equals(""))
			return "";

		for (String string : words) {
			sb.append(reverseWord(string) + " ");
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}

	public String reverseWord(String s) {
		StringBuilder sb = new StringBuilder(); // Strings are immutable - use StringBuilder
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
