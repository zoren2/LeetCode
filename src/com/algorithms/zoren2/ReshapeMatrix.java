package com.algorithms.zoren2;

/*
 * 566. Reshape the Matrix
 * 
 * In MATLAB, there is a very useful function called 'reshape', which can
 * reshape a matrix into a new one with different size but keep its original
 * data.
 * 
 * You're given a matrix represented by a two-dimensional array, and two
 * positive integers r and c representing the row number and column number of
 * the wanted reshaped matrix, respectively.
 * 
 * The reshaped matrix need to be filled with all the elements of the original
 * matrix in the same row-traversing order as they were.
 * 
 * If the 'reshape' operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 * 
 * @author Jack Tsang
 */

public class ReshapeMatrix {

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if (r * c != nums.length * nums[0].length) {
			return nums;
		}
		int[][] newArray = new int[r][c];
		int row = 0, column = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				newArray[row][column] = nums[i][j];
				column++;
				if (column == newArray[0].length) { // Increment new row only when a row is fully filled
					row++;
					column = 0;
				}
			}
		}
		return newArray;
	}
}
