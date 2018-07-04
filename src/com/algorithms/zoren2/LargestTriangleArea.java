package com.algorithms.zoren2;

/*
 * 812. Largest Triangle Area
 * 
 * You have a list of points in the plane. Return the area of the largest
 * triangle that can be formed by any 3 of the points.
 * 
 * Solution is inspired by generic brute force method provided by LeetCode
 * contributor @awice.
 * 
 * @author Jack Tsang
 */

public class LargestTriangleArea {

	public double largestTriangleArea(int[][] points) {
		double area = 0.0;
		for (int i = 0; i < points.length; i++) {
			int[] a = points[i];
			for (int j = i + 1; j < points.length; j++) {
				int[] b = points[j];
				for (int k = j + 1; k < points.length; k++) {
					int[] c = points[k];
					area = Math.max(area, getArea(a, b, c));
				}
			}
		}
		return area;
	}

	public double getArea(int[] a, int[] b, int[] c) {
		return Math.abs(((a[0] - b[0]) * (a[1] - c[1]) - (a[0] - c[0]) * (a[1] - b[1])) / 2.0);
	}
}
