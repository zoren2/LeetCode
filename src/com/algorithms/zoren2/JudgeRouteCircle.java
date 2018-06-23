package com.algorithms.zoren2;

/*
 * Problem 657
 * 
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it 
 * moves back to the original place. The move sequence is represented by a string. And each move is 
 * represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The 
 * output should be true or false representing whether the robot makes a circle.
 * 
 * @author Jack Tsang
 */

public class JudgeRouteCircle {
	public boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < moves.length(); i++) {
			char c = moves.charAt(i);
			if (c == 'U')
				y += 1;
			else if (c == 'D')
				y -= 1;
			else if (c == 'R')
				x += 1;
			else if (c == 'L')
				x -= 1;
		}
		return (x == 0 && y == 0);
	}
}
