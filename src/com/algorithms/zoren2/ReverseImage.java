package com.algorithms.zoren2;

public class ReverseImage {

	/*
	 * Given a binary matrix A, we want to flip the image horizontally, then
	 * invert it, and return the resulting image.
	 * 
	 * To flip an image horizontally means that each row of the image is
	 * reversed. For example, flipping [1, 1, 0] horizontally results in [0, 1,
	 * 1].
	 * 
	 * To invert an image means that each 0 is replaced by 1, and each 1 is
	 * replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
	 * 
	 * @author Jack Tsang
	 */

	public int[][] flipAndInvertImage(int[][] A) {
		int[][] tempMDA = A; // Temporary Multidimensional Array
		for (int i = 0; i < A.length; i++) {
			int[] temp = reverseArray(A[i]); // Reverse the numbers
			for (int j = 0; j < temp.length; j++) {
				temp[j] ^= 1; // Binary XOR
			}
			tempMDA[i] = temp;
		}
		return tempMDA;
	}

	public int[] reverseArray(int[] array) {
		int[] tempArray = array;
		for (int i = 0; i < array.length / 2; i++) {
			int temp = tempArray[i];
			int distanceFromEnd = tempArray.length - i - 1;
			tempArray[i] = tempArray[distanceFromEnd]; // Swap outside to the
														// middle
			tempArray[distanceFromEnd] = temp;
		} // End For
		return tempArray;
	}
}
