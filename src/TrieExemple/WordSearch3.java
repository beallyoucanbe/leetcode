package TrieExemple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 这里采用搜索树，字典树的数据结构
 * 先用给出的字符串来建造搜索树，然后再在给定的字符矩阵中用前缀的方式来寻找
 */
public class WordSearch3 {
	public List<String> findWord(char[][] board, String[] words) {
		Set<String> res = new HashSet<String>();
		if (board == null && words == null || board.length == 0
				|| words.length == 0)
			return new ArrayList<String>(res);
		boolean[][] visited = new boolean[board.length][board[0].length];

		HashMapTrie trie = new HashMapTrie();
		for (String word : words)
			trie.insert(word);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				search(board, visited, trie, i, j, new StringBuilder(), res);
		}
		return new ArrayList<String>(res);
	}

	private void search(char[][] board, boolean[][] visited,
			HashMapTrie trie, int i, int j, StringBuilder sb, Set res) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| visited[i][j])
			return;
		sb.append(board[i][j]);
		String s = sb.toString();
		visited[i][j] = true;
		if (trie.startsWith(s)) {
			if (trie.search(s))
				res.add(s);
			search(board, visited, trie, i, j + 1, sb, res);
			search(board, visited, trie, i, j - 1, sb, res);
			search(board, visited, trie, i + 1, j, sb, res);
			search(board, visited, trie, i - 1, j, sb, res);
		}
		sb.deleteCharAt(sb.length() - 1);
		visited[i][j] = false;
	}
	
	public static void main(String[] args){
		WordSearch3 test = new WordSearch3();
		
		String[] words = {"NAKANS", "EFRLPNE", "OOPOLA", "ASDFGG", "IJNMJKL" };
		 String[] strings ={"FYCENRD","KLNFINU","AAARAHR","NDKLPNE","ALANSAP","OOGOTPN","HPOLANO",
				"POLANDF"};
		 char[][] board = new char[strings.length][strings[0].length()];
		for (int i = 0; i < strings.length; i++)
			board[i] = strings[i].toCharArray();
		for(char[] chars: board)
			System.out.println(Arrays.toString(chars));
		List<String> res = test.findWord(board, words);
		for(String str: res)
			System.out.println(str);
	}
}
