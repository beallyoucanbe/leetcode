package String;

/**
 * 寻找给定字符串的最长回文字符串
 * 	a	b	c	g	d	e	d	g	f
 a	TRUE
 b		TRUE
 c			TRUE
 g				TRUE				TRUE
 d					TRUE		TRUE
 e						TRUE
 d							TRUE
 g								TRUE
 f									TRUE
 */

public class LongestPalindrome {

	// 方法一：暴力法。找到母串的每一个子串， 然后判断是否为回文串
	public String longestPalindromeString(String s) {
		if (s == null || s.length() == 0)
			return "";
		int n = s.length();
		String longestString = "";
		int longest = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++) {
				String str = s.substring(i, j);
				if (isPalindrome(str)) {
					if (str.length() > longest) {
						longest = str.length();
						longestString = str;
					}
				}
			}
		return longestString;
	}

	private boolean isPalindrome(String s) { // 判断一个字符串是否为回文串
		if (s == null || s.length() == 0)
			return false;
		int n = s.length();
		for (int i = 0, j = n - 1; i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	// 方法二： 动态规划法，
	public String longestPalindromeString2(String s) {
		if (s == null || s.length() == 0)
			return "";
		int n = s.length();
		int longestBegin = 0;
		int maxLen = 1;
		boolean[][] table = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			table[i][i] = true; // 数据预处理，单字母为回文字符串
		}
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				longestBegin = i;
				maxLen = 2;
			}
		}
		for(int len = 3; len < n; len++){
			for(int i = 0; i < n - len + 1; i++){
				int j = i + len - 1;
				if(s.charAt(i) == s.charAt(j) && table[i + 1][j - 1] == true){
					table[i][j] = true;
					longestBegin = i;
					maxLen = len;
			}}
		}
		return s.substring(longestBegin, longestBegin + maxLen); 
	}

	//方法三： 中心扩展法
	private String centerArround(String s, int a, int b){
		int n = s.length();
		while(a >= 0 && b <n){
			if(s.charAt(a) == s.charAt(b)){
				a--;
				b++;
			}
			else
				break;
		}
		return s.substring(a + 1, b);
	}
	public String longestPalindromeString3(String s){
		if (s == null || s.length() == 0)
			return "";
		int n = s.length();
		int maxLen = 1;
		String longestString = s.substring(0, 1); //至少要有一个字符
		for(int i = 0; i < n; i++){
			String s1 = centerArround(s, i, i);
			if(s1.length() > maxLen){
				maxLen = s1.length();
				longestString = s1;
			}
			String s2 = centerArround(s, i, i + 1);
			if(s2.length() > maxLen){
				maxLen = s2.length();
				longestString = s2;
			}	
		}
		return longestString;
	}
	public static void main(String[] args) {
		LongestPalindrome test = new LongestPalindrome();
		String s = "abcgdedgf";
		System.out.println(test.longestPalindromeString2(s));
	}

}
