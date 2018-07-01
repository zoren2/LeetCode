package com.algorithms.zoren2;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;

/*
 * 496. Next Greater Element I
 * 
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2.
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number to
 * its right in nums2. If it does not exist, output -1 for this number.
 * 
 * @author Jack Tsang
 */

public class NextGreaterElement {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] answer = new int[nums1.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>(); // Java convenience to use Deque as stack
		HashMap<Integer, Integer> map = new HashMap<>(); // Holds the number that is potentially larger than the previous
		for (int i = nums2.length - 1; i >= 0; i--) {

			// If top of the stack is smaller than the current number
			while (!stack.isEmpty() && stack.peek() <= nums2[i])
				stack.pop();

			// if stack is empty, then no following element could be larger than the current element.
			if (stack.isEmpty())
				map.put(nums2[i], -1);
			else // Next element that is larger stored in k, v pair 
				map.put(nums2[i], stack.peek());

			stack.push(nums2[i]); // Add element to the stack to evaluate on next iteration
		}
		for (int i = 0; i < nums1.length; i++) {
			answer[i] = map.get(nums1[i]); // Retrieve k,v pair that has the next greater number (or none)
		}
		return answer;
	}
}
