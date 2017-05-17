package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/*
 * 此时要求把所有满足条件的组合，这时，用一个List[] 来代替boolean[]
 * 练习如定义以及使用list[], 最后考虑能否使用List<List<String>>;
 * 先把
 */

public class WordBreak3 {

	public List<String> wordBreak(String s, Set<String> wordDict) {

		List<String>[] re = new ArrayList[s.length() + 1]; // 如何使用list[],
		re[0] = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) {
			if (re[i] == null)
				continue;
			for (String word : wordDict) {
				int len = word.length();
				int end = i + len;
				if (end > s.length())
					continue;
				if (s.substring(i, end).equals(word)) {
					if (re[end] == null)
						re[end] = new ArrayList<String>();
					re[end].add(word);
				}
			}
		}
		List<String> res = new LinkedList<String>();
		if (re[s.length()] == null)
			return res;

		ArrayList<String> temp = new ArrayList<String>();
		dfs(re, s.length(), res, temp);

		return res;
	}

	private void dfs(List<String>[] re, int end, List<String> res,
			List<String> temp) {
		if (end <= 0) {
			String path = temp.get(temp.size() - 1);
			for (int i = temp.size() - 2; i >= 0; i--)
				path += " " + temp.get(i);
			res.add(path);
			return;
		}
		for (String str : re[end]) {
			temp.add(str);
			dfs(re, end - str.length(), res, temp);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		WordBreak3 test = new WordBreak3();
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>();
		String[] words = { "cat", "cats", "and", "sand", "dog" };
		for (String word : words)
			wordDict.add(word);
		List<String> re = test.wordBreak(s, wordDict);

		for (String word : re)
				System.out.println(word + " ");
	}
}
