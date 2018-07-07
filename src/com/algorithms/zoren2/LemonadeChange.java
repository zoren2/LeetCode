package com.algorithms.zoren2;

/*
 * 860. Lemonade Change
 * 
 * At a lemonade stand, each lemonade costs $5.
 * 
 * Customers are standing in a queue to buy from you, and order one at a time
 * (in the order specified by bills).
 * 
 * Each customer will only buy one lemonade and pay with either a $5, $10, or
 * $20 bill. You must provide the correct change to each customer, so that the
 * net transaction is that the customer pays $5.
 * 
 * Note that you don't have any change in hand at first.
 * 
 * Return true if and only if you can provide every customer with correct
 * change.
 * 
 * @author Jack Tsang
 */

public class LemonadeChange {

	public boolean lemonadeChange(int[] bills) {
		int five = 0, ten = 0;
		for (int bill : bills) {
			if (bill == 5) // If you get a five, you don't return change
				five++;
			else if (bill == 10) { // If you get a ten dollar bill, you must give a $5 bill
				if (five == 0)
					return false;
				five--;
				ten++;
			} else { // If you get a $20 bill
				if (five > 0 && ten > 0) { // Have at least one ten and one five
					five--;
					ten--;
				} else if (five >= 3) { // Have 5 fives
					five -= 3;
				} else { // Don't have enough/correct bills for change
					return false;
				}
			}
		}
		return true;
	}
}
