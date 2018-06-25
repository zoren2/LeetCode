package com.algorithms.zoren2;

import java.lang.reflect.Array;

/*
 * 806. Number of Lines To Write String
 * 
 * We are to write the letters of a given string S, from left to right into
 * lines. Each line has maximum width 100 units, and if writing a letter would
 * cause the width of the line to exceed 100 units, it is written on the next
 * line. We are given an array widths, an array where widths[0] is the width of
 * 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 * 
 * Now answer two questions: how many lines have at least one character from S,
 * and what is the width used by the last such line? Return your answer as an
 * integer list of length 2.
 * 
 * @author Jack Tsang
 */

public class NumberOfLines {

	public static int[] numberOfLines(int[] widths, String S) {

		int accumulator = 0;
		int characterIndex = 0; // Holds index inside width for clarity
		int numberOfLines = 1; // Problem statement indicates there must exist a String in inputf

		for (char c : S.toCharArray()) {
			characterIndex = c - 97;
			accumulator += widths[characterIndex];
			if (accumulator / 100 == 1) {
				numberOfLines++;
				if (accumulator == 100) {
					accumulator = 0;
				} else {
					accumulator = widths[characterIndex];
				}
			}
		} // End for
		return new int[] { numberOfLines, accumulator };
	}
}
