package com.algorithms.zoren2;

/*
 * Let's call an array A a mountain if the following properties hold:
 * A.length >= 3 There exists some 0 < i < A.length - 1 such that A[0] <
 * A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 
 * 
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ...
 * A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * 
 * @author Jack Tsang
 */

public class PeakIndexMountainArray {
	
	public int peakIndexInMountainArray(int[] A) {
		int low = 0, high = A.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2; // (high - low) / 2 returns middle of particular piece
			if (A[mid] < A[mid + 1]) { // Values are ascending, check latter half
				low = mid + 1;
			} else { // Values are descending, check first half
				high = mid;
			}
		}
		return low; // Low will be the peak where following values descend
	}
}
