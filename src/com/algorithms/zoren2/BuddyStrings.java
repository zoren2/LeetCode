package com.algorithms.zoren2;

public class BuddyStrings {

	/*
	 * 859. Buddy Strings
	 * 
	 * Given two strings A and B of lowercase letters, return true if and only
	 * if we can swap two letters in A so that the result equals B.
	 * 
	 * @author Jack Tsang
	 */
	
	public boolean buddyStrings(String A, String B) {
		if (A.equals(B)) {
			int[] count = new int[26];
			for (int i = 0; i < A.length(); ++i) {
				count[A.charAt(i) - 'a'] += 1;
			}
			for (int c : count)
				if (c > 1) // Needs more than one to swap if the two strings are the same
					return true;
			return false;
		} else {
			int first = -1, second = -1;
			for (int i = 0; i < A.length(); ++i) {
				if (A.charAt(i) != B.charAt(i)) {
					if (first == -1)
						first = i;
					else if (second == -1)
						second = i;
					else
						return false;
				}
			}

			return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first)); // 4 pieces that moved are the from the same original string
		}
	}
}
