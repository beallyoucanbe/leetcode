package BitManipulation;

/*
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
 * where the two words do not share common letters. 
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 */
/*
 * �ؼ�������ж������ַ�����û����ͬ���ַ�����ĸ�����ǿ�����һ��intֵ��26λ����ʾһ���ַ������ֵ�26����ĸ��������ȥ���ĳ��ֵĴ�����
 * �ж������ַ����Ƿ����ظ�����ĸ��ֻ��Ҫ��&���룩�������ɡ�
 */
public class MaximumProductofWordLengths {

	public int maxProduct(String[] words) {
		if (words == null || words.length <= 1)
			return 0;
		// Ԥ����
		int[] stringBit = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				stringBit[i] |= (1 << (words[i].charAt(j) - 'a'));
			}
		}
		// �жϽ��
		int res = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((stringBit[i] & stringBit[j]) == 0) {
					int temp = words[i].length() * words[j].length();
					if (res < temp)
						res = temp;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaximumProductofWordLengths test = new MaximumProductofWordLengths();
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(test.maxProduct(words));
	}

}
