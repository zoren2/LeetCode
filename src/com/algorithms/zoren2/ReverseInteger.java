package com.algorithms.zoren2;

/*
 * Given a 32-bit signed integer, reverse digits of an integer.
 * @author Jack Tsang
 */

public class ReverseInteger {
	public int reverse(int x) {
		long temp = 0;
		boolean negative = false;
		if (x < 0) {
			x = Math.abs(x);
			negative = true;
		}
		/*
		 * The trick here is to use mod operator (% 10) to find the next digit. 
		 */
		while (x != 0) {
			temp *= 10;
			temp += x % 10;
			x /= 10;
		} // End while
		if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE)
			return 0;
		if (negative == true)
			return (int) temp * -1;
		return (int) temp;
	} // End reverse
}
