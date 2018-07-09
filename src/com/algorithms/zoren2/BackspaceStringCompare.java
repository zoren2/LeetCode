package com.algorithms.zoren2;

import java.util.ArrayDeque;

/*
 * 844. Backspace String Compare
 * 
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become
 * "ac". Example 2:
 * 
 * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T become
 * "". Example 3:
 * 
 * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T become
 * "c". Example 4:
 * 
 * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while T
 * becomes "b". Note:
 * 
 * 1 <= S.length <= 200 1 <= T.length <= 200 S and T only contain lowercase
 * letters and '#' characters. Follow up:
 * 
 * Can you solve it in O(N) time and O(1) space?
 * 
 * @author Jack Tsang
 */

public class BackspaceStringCompare {

	public boolean backspaceCompare(String S, String T) {
		// Strategy used will use two stacks, then popped items will be compared at the end
		ArrayDeque<Character> firstStack = new ArrayDeque<Character>();
		ArrayDeque<Character> secondStack = new ArrayDeque<Character>();

		// Pop if # is encountered, otherwise push to stack.
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '#' && firstStack.size() != 0)
				firstStack.pop();
			else if (S.charAt(i) == '#' && secondStack.size() == 0)
				continue;
			else
				firstStack.push(S.charAt(i));

		}

		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == '#' && secondStack.size() != 0)
				secondStack.pop();
			else if (T.charAt(i) == '#' && secondStack.size() == 0)
				continue;
			else
				secondStack.push(T.charAt(i));
		}

		while (firstStack.size() != 0 && secondStack.size() != 0) {
			if (firstStack.pop() == secondStack.pop())
				continue;
			else
				return false;
		}
		return firstStack.size() == secondStack.size();
	}
}
