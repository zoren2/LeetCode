package com.algorithms.zoren2;

import java.util.ArrayList;
import java.util.List;

/*
 * 728. Self Dividing Numbers
 * 
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * 
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * 
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds.
 * 
 * @author Jack Tsang
 */

public class SelfDividingIntegers {

	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> integerList = new ArrayList<Integer>();
		boolean isSelfDividing;
		for (int i = left; i <= right; i++) {
			int temp = i; // Temporary holder for current number
			isSelfDividing = false;
			while (temp != 0) {
				int currentDigit = temp % 10;
				if (currentDigit == 0) {
					isSelfDividing = false;
					break;
				} else if (i % currentDigit == 0) {
					isSelfDividing = true;
				} else {
					isSelfDividing = false;
					break;
				}
				temp /= 10;
			} // End While
			if (isSelfDividing) {
				integerList.add(i);
			}
		} // End for
		return integerList;
	}
}
