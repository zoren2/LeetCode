package com.algorithms.zoren2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 830. Positions of Large Groups
 * 
 * In a string S of lowercase letters, these letters form consecutive groups of
 * the same character.
 * 
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx",
 * "z" and "yy".
 * 
 * Call a group large if it has 3 or more characters. We would like the starting
 * and ending positions of every large group.
 * 
 * The final answer should be in lexicographic order.
 * 
 * @author Jack Tsang
 */

public class PositionOfLargeGroups {

	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> listOfLists = new ArrayList<List<Integer>>(); // Arraylists preserve order
		int counter = 1;
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) == S.charAt(i - 1)) {
				counter++;
			} else {
				if (counter >= 3) {
					listOfLists.add(Arrays.asList(i - counter, i - 1));
				}
				counter = 1;
			}
		}
		// Checks if trail end is a large group
		if (counter >= 3) {
			listOfLists.add(Arrays.asList(S.length() - counter, S.length() - 1));
		}
		return listOfLists;
	}
}
