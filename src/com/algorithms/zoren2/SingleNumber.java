package com.algorithms.zoren2;

import java.util.HashSet;
import java.util.Set;

/*
 * 136. Single Number
 * 
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * CD
 * 
 * @author Jack Tsang
 */

public class SingleNumber {

	public int singleNumber(int[] nums) {
		Set<Integer> integerList = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (integerList.add(nums[i]) == false)
				integerList.remove(nums[i]);
		}
		return integerList.iterator().next();
	}
}
