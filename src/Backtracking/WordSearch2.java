package Backtracking;

import java.util.Arrays;

/*
 * 单词搜索，每个节点的4个方向均可以搜索，可以用一个数组来控制方向
 * 本算法超时。Time Limited Exceeded
 * 但至少实现了功能
 * 回溯，深度优先
 */

public class WordSearch2 {

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;

		boolean res = false;
		if (board == null || m == 0 || n == 0 || word.length() == 0)
			return false;
		
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (exist(board, i, j, 0, word))
					res = true;
			}
		return res;
	}

	public boolean exist(char[][] board, int i, int j, int count, String word) {
		int m = board.length;
		int n = board[0].length;
		int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		
		if (i < 0 || i >= m || j < 0 || j >= n)
			return false;
		if (board[i][j] == word.charAt(count)) {
			char temp = word.charAt(count);
			board[i][j] = '#';  //不用另外开辟空间维护一个boolean类型数组
			if (count == word.length() - 1)
				return true;	
			for (int k = 0; k < 4; k++) {
				int newi = i + direction[k][0];
				int newj = j + direction[k][1];
				if (exist(board, newi, newj, count + 1, word))
					return true;
			}
			board[i][j] = temp;
		}
		return false;
	}

	public static void main(String[] args) {
		WordSearch2 test = new WordSearch2();
		// String[] strs =
		// {"FYCENRD","KLNFINU","AAARAHR","NDKLPNE","ALANSAP","OOGOTPN","HPOLANO",
		// "POLAND"};
		// char[][] board = new char[strs.length][strs[0].length()];
		// for(int i = 0; i < strs.length; i++){
		// board[i] = strs[i].toCharArray();
		// }
		// for(char[] chars: board)
		// System.out.println(Arrays.toString(chars));
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		for (char[] chars : board)
			System.out.println(Arrays.toString(chars));
		String word1 = "BCCED";
		String word2 = "ASADEE";
		String word3 = "ABCB";
		if (test.exist(board, word1))
			System.out.println("word1 为true");
		if (test.exist(board, word2))
			System.out.println("word2 为true");
		if (test.exist(board, word3))
			System.out.println("word3 为true");
	}
}
