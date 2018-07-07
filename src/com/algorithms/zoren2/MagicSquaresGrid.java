package com.algorithms.zoren2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 840. Magic Squares In Grid
 * 
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9
 * such that each row, column, and both diagonals all have the same sum.
 * 
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?
 * (Each subgrid is contiguous).
 * 
 * Example 1:
 * 
 * Input: [[4,3,8,4], [9,5,1,9], [2,7,6,2]] Output: 1 Explanation: The following
 * subgrid is a 3 x 3 magic square: 438 951 276 while this one is not: 384 519
 * 762
 * 
 * In total, there is only one magic square inside the given grid.
 * 
 * Note: 1 <= grid.length <= 10 1 <= grid[0].length <= 10 0 <= grid[i][j] <= 15
 * 
 * @author Jack Tsang
 */

public class MagicSquaresGrid {

	public int numMagicSquaresInside(int[][] grid) {
		Set<Integer> gridNumbers;
		int numOfMagicNumbers = 0;
		int noMagicNumber = 0;
		int centerIsFive = 0; // Must be 5 for colums + rows to all be equal.
		int positiveDiagonal = 0;
		int negativeDiagonal = 0;

		for (int i = 0; i < grid.length - 2; i++) {
			for (int j = 0; j < grid[0].length - 2; j++) {
				gridNumbers = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
				positiveDiagonal = 0;
				negativeDiagonal = 0;
				noMagicNumber = 0;
				centerIsFive = 0;
				for (int k = j; k < j + 3; k++) {
					if (k == j) {
						negativeDiagonal += grid[i][k];
					}
					if (k == j + 2) {
						positiveDiagonal += grid[i][k];
					}
					if (gridNumbers.remove(grid[i][k]) == false) {
						noMagicNumber = 1;
						continue;
					}
				}
				System.out.println();

				for (int k = j; k < j + 3; k++) {
					if (k == j + 1) {

						if (grid[i + 1][k] == 5)
							centerIsFive = 1;
						positiveDiagonal += grid[i + 1][k];
						negativeDiagonal += grid[i + 1][k];
					}
					if (gridNumbers.remove(grid[i + 1][k]) == false) {
						noMagicNumber = 1;
						continue;
					}
				}
				for (int k = j; k < j + 3; k++) {
					if (k == j)
						positiveDiagonal += grid[i + 2][k];
					if (k == j + 2)
						negativeDiagonal += grid[i + 2][k];
					if (gridNumbers.remove(grid[i + 2][k]) == false) {
						noMagicNumber = 1;
						continue;
					}
				}

				if (noMagicNumber == 0 && negativeDiagonal == positiveDiagonal && centerIsFive == 1) {
					numOfMagicNumbers++;
				}
			} // End j loop

		} // End i loop

		return numOfMagicNumbers;
	}
}
