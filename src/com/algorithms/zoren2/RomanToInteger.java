package com.algorithms.zoren2;

/*
 * 13. Roman to Integer
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * @author Jack Tsang
 */

public class RomanToInteger {
	public int romanToInt(String s) {
		int decimal = 0;
		if (s.length() == 0)
			return decimal;
		for (int i = 0; i < s.length() - 1; i++) {
			int current = getValueOfRomanNumeral(s.charAt(i)); // Read values in pairs until s.length - 1. Will add the last number number at the return statement.
			int next = getValueOfRomanNumeral(s.charAt(i + 1));
			if (current < next)
				decimal -= current;
			else
				decimal += current;

		}
		return decimal + getValueOfRomanNumeral(s.charAt(s.length() - 1)); // Adds value of remaining Roman Numeral
	}

	private int getValueOfRomanNumeral(char c) {
		switch (c) {
		case 'M':
			return 1000;
		case 'D':
			return 500;
		case 'C':
			return 100;
		case 'L':
			return 50;
		case 'X':
			return 10;
		case 'V':
			return 5;
		case 'I':
			return 1;
		default:
			return 0;
		}
	}
}
