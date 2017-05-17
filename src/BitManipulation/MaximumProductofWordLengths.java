package BitManipulation;

/*
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
 * where the two words do not share common letters. 
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 */
/*
 * 关键是如何判断两个字符串有没有相同的字符和字母，我们可以用一个int值得26位来表示一个字符串出现的26个字母，而不用去担心出现的次数，
 * 判断两个字符串是否有重复的字母，只需要用&（与）操作即可。
 */
public class MaximumProductofWordLengths {

	public int maxProduct(String[] words) {
		if (words == null || words.length <= 1)
			return 0;
		// 预处理
		int[] stringBit = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				stringBit[i] |= (1 << (words[i].charAt(j) - 'a'));
			}
		}
		// 判断结果
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
