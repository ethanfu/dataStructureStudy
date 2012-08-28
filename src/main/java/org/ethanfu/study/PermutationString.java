package org.ethanfu.study;

import java.util.Stack;

public class PermutationString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "abccd";
		char[] ssCh = ss.toCharArray();
		combiantion(ssCh);
	}

	public static void combiantion(char chs[]) {
		if (chs.length == 0)
			return;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 1; i <= chs.length; i++) {
			combine(chs, 0, i, stack);
		}
	}

	// 从字符数组中第begin个字符开始挑选number个字符加入list中
	public static void combine(char[] chs, int begin, int number,
			Stack<Character> stack) {
		if (number == 0) {
			System.out.println(stack.toString());
			return;
		}
		if (begin == chs.length) {
			return;
		}
		stack.push(chs[begin]);
		combine(chs, begin + 1, number - 1, stack);
		stack.pop();
		combine(chs, begin + 1, number, stack);
	}

}
