package com.algorithms.zoren2;

/*
 * 463. Island Perimeter
 * 
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water. Grid cells are connected
 * horizontally/vertically (not diagonally). The grid is completely surrounded
 * by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected to
 * the water around the island). One cell is a square with side length 1. The
 * grid is rectangular, width and height don't exceed 100.
 * 
 * Determine the perimeter of the island.
 * 
 * @author Jack Tsang
 */

public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		int counter = 0;
		int boxPerimeter = 4;

		// Solution checks adjacent boxes and subtracts 1 for every adjacency
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					boxPerimeter = 4;
					// check up
					if (i - 1 >= 0 && grid[i - 1][j] == 1)
						boxPerimeter--;

					// check right
					if (j + 1 < grid[i].length && grid[i][j + 1] == 1)
						boxPerimeter--;

					// check down
					if (i + 1 < grid.length && grid[i + 1][j] == 1)
						boxPerimeter--;
					// check left
					if (j - 1 >= 0 && grid[i][j - 1] == 1)
						boxPerimeter--;
					counter += boxPerimeter;
				}
			}
		}
		return counter;
	}
}
