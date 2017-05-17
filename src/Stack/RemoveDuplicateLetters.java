package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given a string which contains only lowercase letters, 
 * remove duplicate letters so that every letter appear once and only once. 
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * �ѵ������������밴���ֵ�˳����������ȿ��Կ�����һ��26λ�������洢
 * ���ǣ�����ȻҪ��֤���е��ַ���ԭ���ַ����е�λ���ǲ���ġ�
 */

public class RemoveDuplicateLetters {

	public String removeDuplicateLetters(String s) {

		if (s == null || s.length() <= 1)
			return s;
		Map<Character, Integer> lastPosMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++)
			lastPosMap.put(s.charAt(i), i);
		// map�ı��������������Լ�ֵ�Ա�����Ҳ���Ե�������
		for (Map.Entry<Character, Integer> entry : lastPosMap.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}

		char[] result = new char[lastPosMap.size()]; // ��Ž��������
		int begin = 0, end = findMinLastPos(lastPosMap);
		for (int i = 0; i < result.length; i++) {
			char minChar = 'z' + 1;
			for (int k = begin; k <= end; k++) {
				//������Ҫ��һ���жϣ�����֤ѡ����ַ���֮ǰû��ѡ����ģ�
				//����ÿѡ��һ�ξͰѸ��ַ��Լ���Ӧ�ļ�ֵ�Դ�map��ɾ������ֻ��Ҫÿ�ζ���map�е�������һ�αȽϼ���
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

	private int findMinLastPos(Map<Character, Integer> lastPosMap) { // ���ص�ǰmap��������С���ַ���λ��
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
