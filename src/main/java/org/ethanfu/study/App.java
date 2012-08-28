package org.ethanfu.study;

import java.util.LinkedList;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println(permutation("AABCDDE"));
	}

	public static LinkedList<String> permutation(String str) {

		LinkedList<String> linkedString = new LinkedList<String>();
		if (str.length() <= 1) {
			linkedString.add(str);
			return linkedString;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// consider the case in which the characters may be duplicated.
			if (i > 0 && ch == str.charAt(i - 1)) {
				continue;
			}
			String newStr = remove(str, i);
			LinkedList<String> newStrList = permutation(newStr);
			for (int j = 0; j < newStrList.size(); j++) {
				linkedString.add(ch + newStrList.get(j));
			}
		}
		return linkedString;
	}

	// remove the ith character from the string
	public static String remove(String str, int i) {
		if (i == 0)
			return str.substring(1, str.length());
		if (i == str.length() - 1)
			return str.substring(0, i);
		return str.substring(0, i) + str.substring(i + 1, str.length());
	}
}
