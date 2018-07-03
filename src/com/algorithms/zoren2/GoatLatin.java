package com.algorithms.zoren2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 824. Goat Latin
 * 
 * A sentence S is given, composed of words separated by spaces. Each word
 * consists of lowercase and uppercase letters only.
 * 
 * We would like to convert the sentence to "Goat Latin" (a made-up language
 * similar to Pig Latin.)
 * 
 * The rules of Goat Latin are as follows:
 * 
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of
 * the word. For example, the word 'apple' becomes 'applema'.
 * 
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter
 * and append it to the end, then add "ma". For example, the word "goat" becomes
 * "oatgma".
 * 
 * Add one letter 'a' to the end of each word per its word index in the
 * sentence, starting with 1. For example, the first word gets "a" added to the
 * end, the second word gets "aa" added to the end and so on. Return the final
 * sentence representing the conversion from S to Goat Latin.
 * 
 * @author Jack Tsang
 */

public class GoatLatin {
	public String toGoatLatin(String S) {
		Character[] charList = new Character[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		Set<Character> vowels = new HashSet<Character>(Arrays.asList(charList));

		StringBuilder sb = new StringBuilder();
		String[] stringArray = S.split(" "); // One space to separate input

		if (S.length() == 0) {
			return "";
		}

		for (int i = 0; i < stringArray.length; i++) {
			char firstCharacter = stringArray[i].charAt(0);

			if (vowels.contains(firstCharacter)) // If the strings first character is a vowel
				sb.append(stringArray[i]);
			else {
				sb.append(stringArray[i].substring(1));
				sb.append(firstCharacter);
			}
			sb.append("ma");
			for (int j = 0; j <= i; j++)
				sb.append('a');
			if (i != stringArray.length - 1)
				sb.append(' ');
		}
		return sb.toString();
	}
}
