package String;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * @author shuoyi.zhao
 *
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {

		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		// 数据预处理
		for (int i = 0; i < t.length(); i++) {
			if (dict.containsKey(t.charAt(i)))
				dict.put(t.charAt(i), dict.get(t.charAt(i)) + 1);
			else
				dict.put(t.charAt(i), 1);
		}
		int count = 0;
		int start = 0;
		int end = 0;
		HashMap<Character, Integer> found = new HashMap<Character, Integer>();
		int min = Integer.MAX_VALUE;
		String minWindow = "";
		while (end < s.length()) {
			char ch = s.charAt(end);
			if (dict.containsKey(ch)) {
				if (found.containsKey(ch)) {
					if (found.get(ch) < dict.get(ch))
						count++;
					found.put(ch, found.get(ch) + 1);
				} else {
					found.put(ch, 1);
					count++;
				}
			}
			if (count == t.length()) { // //When foundCounter equals to
										// T.length(), in other words, found all
										// characters.
				char sc = s.charAt(start);
				//两种方式来判断，一种，当前字符在t中不存在，或者是存在但是found中已经有多余的字符
				while (!found.containsKey(sc) || found.get(sc) > dict.get(sc)) {
					if (found.containsKey(sc) && found.get(sc) > dict.get(sc))
						found.put(sc, found.get(sc) - 1);
					start++;
					sc = s.charAt(start);
				}
				if (end - start + 1 < min) {
					min = end - start + 1;
					minWindow = s.substring(start, end + 1);
				}
			}
			end++;
		}
		return minWindow;
	}
}
