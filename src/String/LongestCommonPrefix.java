package String;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 寻找字符串数组的最长公共前缀
 * 思想：先找到前两个字符串的公共前缀，而整个数组的公共前缀一定是他的前缀
 */

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		// 预处理，没有元素或是只有一个元素
		if(strs == null || strs.length == 0)
			return "";
		int len = strs.length;
		if(len == 1)
			return strs[0];
		String res = longestCommonPrefix(strs[0], strs[1]);
		for(int i = 2; i < strs.length; i++){
			res = longestCommonPrefix(res, strs[i]);
		}
		return res;
	}

	//两个字符串的公共前缀
	private String longestCommonPrefix(String str1, String str2){
		if(str1 == null || str2 == null)
			return null;
		StringBuilder res = new StringBuilder();
		int i = 0;
		while(i < str1.length() && i < str2.length()){
			if(str1.charAt(i) == str2.charAt(i)){
				res.append(str1.charAt(i));
				i++;
			}else
				break;
		}
		return res.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestCommonPrefix test = new LongestCommonPrefix();
		String[] strs = {"abcdedg", "abcd", "abc"};
		String res = test.longestCommonPrefix(strs);
		System.out.println(res);
	}

}
