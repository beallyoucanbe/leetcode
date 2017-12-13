package Backtracking;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if 
 * s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"]. 
 * Return true because "leetcode" can be segmented as "leet code". 
 */
/*
 * 好吧，自己写的程序右TLE
 */
public class WordBreak {

	public boolean wordBreak(String s, Set<String> wordDict) {

		if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
			return false;
		StringBuilder cur = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			cur.append(s.charAt(i));
			if (wordDict.contains(cur.toString())) {
				System.out.println(cur);
				if (wordBreak(s, cur, wordDict))
					return true;
			}
		}
		return false;
	}

	public boolean wordBreak(String s, StringBuilder cur, Set<String> wordDict) {
		System.out.println("s = " + s + ", cur = " + cur);
		if (s.equals(cur.toString()))
			return true;
		StringBuilder sub = new StringBuilder();
		for (int i = cur.length(); i < s.length(); i++) {
			sub.append(s.charAt(i));
			if (wordDict.contains(sub.toString())) {
				cur.append(sub);
				int subLength = sub.length();
				if (wordBreak(s, cur, wordDict))
					return true;
				cur.delete(cur.length() - subLength, cur.length());
			}
		}
		return false;
	}

	public static void main(String[] args) {
		WordBreak test = new WordBreak();
		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>();
		String[] words = { "leet", "coode", "what", "your", "name" };
		for (String word : words)
			wordDict.add(word);
		if (test.wordBreak(s, wordDict))
			System.out.println("true");
		else
			System.out.println("false");
	}
}
