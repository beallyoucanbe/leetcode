package Backtracking;

import java.util.ArrayList;

/*
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0, 01 - 1, 11 - 3, 10 - 2
 */

public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> grayCode(int n) {
		if (n == 0) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}
		ArrayList<Integer> result = grayCode(n - 1);

		int addNumber = 1 << (n - 1);
		int originalsize = result.size();
		for (int i = originalsize - 1; i >= 0; i--) {
			result.add(addNumber + result.get(i));
		}
		return result;
	}
}
