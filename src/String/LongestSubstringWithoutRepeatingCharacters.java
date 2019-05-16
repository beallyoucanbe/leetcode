package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. Examples: Given "abcabcbb", the answer is "abc", which the length
 * is 3. Given "bbbbb", the answer is "b", with the length of 1. Given "pwwkew",
 * the answer is "wke", with the length of 3. Note that the answer must be a
 * substring, "pwke" is a subsequence and not a substring.
 * 
 * @author shuoyi.zhao
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int j = i;
		int curLen = 0;
		int maxLen = 0;
		while(j < s.length()){
			char c = s.charAt(j);
			if(!map.containsKey(c)){
				map.put(c, j++);
				curLen++;
			}
			else{
				maxLen = Math.max(maxLen, curLen);
				int k = map.get(c);
				for(;i <= k; i++)
					map.remove(s.charAt(i));
				curLen = j - k;
				map.put(c, j++);
			}
		}
		return Math.max(curLen, maxLen);

	}
	//官方给出的答案，简单到了极致，1用boolean数组代替map，2， 省去curLen变量
	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int i = 0;
		int j = 0;
		int maxLen = 0;
		boolean[] exist= new boolean[256];
		while(j < s.length()){
			if(!exist[s.charAt(j)]){
				exist[s.charAt(j++)] = true;
			}
			else{
				maxLen = Math.max(maxLen, j - i);
				while(s.charAt(i) != s.charAt(j)){
					exist[s.charAt(i++)] = false;
				}
				i++; 
				j++;
			}
		}
		return Math.max(maxLen, s.length() - i);
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		String s = "pwwkew";
		System.out.println(test.lengthOfLongestSubstring(s));
	}
}
