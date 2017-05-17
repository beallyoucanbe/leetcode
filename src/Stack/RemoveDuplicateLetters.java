package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given a string which contains only lowercase letters, 
 * remove duplicate letters so that every letter appear once and only once. 
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * 难点是输出结果必须按照字典顺序输出，首先可以考虑用一个26位数组来存储
 * 但是，你仍然要保证所有的字符在原来字符串中的位置是不变的。
 */

public class RemoveDuplicateLetters {

	public String removeDuplicateLetters(String s) {

		if (s == null || s.length() <= 1)
			return s;
		Map<Character, Integer> lastPosMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++)
			lastPosMap.put(s.charAt(i), i);
		// map的遍历方法，可以以键值对遍历，也可以单独遍历
		for (Map.Entry<Character, Integer> entry : lastPosMap.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}

		char[] result = new char[lastPosMap.size()]; // 存放结果的数组
		int begin = 0, end = findMinLastPos(lastPosMap);
		for (int i = 0; i < result.length; i++) {
			char minChar = 'z' + 1;
			for (int k = begin; k <= end; k++) {
				//在这里要做一次判断，包保证选择的字符是之前没有选择过的，
				//由于每选择一次就把该字符以及对应的键值对从map中删除，故只需要每次都与map中的内容做一次比较即可
				if (lastPosMap.containsKey(s.charAt(k)) 
						&& s.charAt(k) < minChar) {
					minChar = s.charAt(k);
					begin = k + 1;
				}
			}
			result[i] = minChar;
			if (i == result.length - 1)
				break;

			lastPosMap.remove(minChar);
			if (minChar == s.charAt(end))
				end = findMinLastPos(lastPosMap);
		}

		return new String(result);
	}

	private int findMinLastPos(Map<Character, Integer> lastPosMap) { // 返回当前map中索引最小的字符的位置
		if (lastPosMap == null || lastPosMap.isEmpty())
			return -1;
		int minIndex = Integer.MAX_VALUE;
		for (int temp : lastPosMap.values())
			minIndex = Math.min(minIndex, temp);
		return minIndex;
	}

	public static void main(String[] args) {
		RemoveDuplicateLetters test = new RemoveDuplicateLetters();
		String s = "cbacdcbc";
		String res = test.removeDuplicateLetters(s);
		System.out.println(res);
	}
}
