package Backtracking;

import java.util.Arrays;

/*Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 单词搜索，每个节点的4个方向均可以搜索，可以用一个数组来控制方向
 * 本算法超时。Time Limited Exceeded
 * 但至少实现了功能
 */

public class WordSearch {

	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0 || board[0].length == 0
				|| word.length() == 0)
			return false;
		boolean[][] isTravel = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++) {
				if (exist(board, i, j, 0, word, isTravel))
					return true;
			}
		return false;
	}

	public boolean exist(char[][] board, int i, int j, int count, String word,
			boolean[][] isTravel) {
		int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		if (count == word.length())
			return true;
		if (board[i][j] == word.charAt(count)) {
			count++;
			isTravel[i][j] = true;
			for (int k = 0; k < 4; k++) {
				int newi = i + direction[k][0];
				int newj = j + direction[k][1];
				if (newi >= 0 && newi < board.length && newj >= 0
						&& newj < board[newi].length
						&& isTravel[newi][newj] == false) {
					if(exist(board, newi, newj, count, word, isTravel))
						return true;
				}
			}
			isTravel[i][j] = false;
		}
		return false;
	}

	public static void main(String[] args) {
		WordSearch test = new WordSearch();
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
		String word1 = "ABCCED";
		String word2 = "SEE";
		String word3 = "ABCB";
		if (test.exist(board, word1))
			System.out.println("word1 为true");
		if (test.exist(board, word2))
			System.out.println("word2 为true");
		if (test.exist(board, word3))
			System.out.println("word3 为true");
	}
}
