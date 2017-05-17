package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters. For example, Given s = ¡°eceba¡±, is "ece" which
 * its length is 3.
 * 
 * @author shuoyi.zhao
 *
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() <= 2)
			return s.length();
		int i = 0;
		int j = 0;
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (j < s.length()) {
			char c = s.charAt(j);
			if (map.containsKey(c)) {
				map.put(c, j++);
			} else if (!map.containsKey(c) && map.size() < 2) {
				map.put(c, j++);
			} else {
				maxLen = Math.max(maxLen, j - i);
				int index = Integer.MAX_VALUE;
				char ch = ' ';
				for (Entry<Character, Integer> item : map.entrySet()) {
					if (item.getValue() < index) {
						index = item.getValue();
						ch = item.getKey();
					}
				}
				map.remove(ch);
				map.put(c, j++);
				i = index + 1;
			}
		}
		return Math.max(maxLen, s.length() - i);
	}

	public static void main(String[] args) {
		LongestSubstringwithAtMostTwoDistinctCharacters test = new LongestSubstringwithAtMostTwoDistinctCharacters();
		String s = "eceba";
		System.out.println(test.lengthOfLongestSubstringTwoDistinct(s));
	}
}
