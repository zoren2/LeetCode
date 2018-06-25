package com.algorithms.zoren2;

/*
 * 476. Number Complement
 * 
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * 
 * Note: The given integer is guaranteed to fit within the range of a 32-bit
 * signed integer. You could assume no leading zero bit in the integer’s binary
 * representation.
 * 
 * @author Jack Tsang
 */

public class NumberComplement {
	public int findComplement(int num) {
		int exponent = 0;
		while (Math.pow(2, exponent) < num) {
			exponent++;
		}
		int mask = (1 << exponent) - 1;
		return ~num & mask;
	}
}
