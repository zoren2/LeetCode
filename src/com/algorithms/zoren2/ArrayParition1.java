package com.algorithms.zoren2;

import java.util.Arrays;

/*
 * 561. Array Parition 1 
 * 
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), 
 * (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * 
 * @author Jack Tsang
 */

public class ArrayParition1 {
	public int arrayPairSum(int[] nums) {
		int sum = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i += 2) {
			sum += nums[i]; // Math.min function doesn't need to be used since you only add the first number of the pair
		}
		return sum;
	}
}
