package String;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * Ѱ���ַ�������������ǰ׺
 * ˼�룺���ҵ�ǰ�����ַ����Ĺ���ǰ׺������������Ĺ���ǰ׺һ��������ǰ׺
 */

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		// Ԥ����û��Ԫ�ػ���ֻ��һ��Ԫ��
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

	//�����ַ����Ĺ���ǰ׺
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
