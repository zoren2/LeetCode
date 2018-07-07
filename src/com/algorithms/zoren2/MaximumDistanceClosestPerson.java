package com.algorithms.zoren2;

/*
 * 849. Maximize Distance to Closest Person
 * 
 * In a row of seats, 1 represents a person sitting in that seat, and 0
 * represents that the seat is empty.
 * 
 * There is at least one empty seat, and at least one person sitting.
 * 
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized.
 * 
 * Return that maximum distance to closest person.
 * 
 * @author Jack Tsang
 */

public class MaximumDistanceClosestPerson {

	public int maxDistToClosest(int[] seats) {
		int lengthOfRunningZeroes = 0;
		int maximumDistance = 0;

		// First segment before encountering a person
		for (int i = 0; i < seats.length; i++)
			if (seats[i] == 1) {
				maximumDistance = Math.max(maximumDistance, i);
				break;
			}

		// Middle segment potentially between two people
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				lengthOfRunningZeroes = 0;
			} else {
				lengthOfRunningZeroes++;
				maximumDistance = Math.max(maximumDistance, (lengthOfRunningZeroes + 1) / 2);
			}
		}

		// Last running segment of 0's where it runs off the edge
		for (int i = seats.length - 1; i >= 0; i--)
			if (seats[i] == 1) {
				maximumDistance = Math.max(maximumDistance, seats.length - 1 - i);
				break;
			}
		return maximumDistance;
	}
}
