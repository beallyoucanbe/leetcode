package String;

import java.util.Arrays;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 二维动态规划
 * 
 * @author shuoyi.zhao
 *
 */
public class InterleavingString {
	
	public boolean isInterleave(String s1, String s2, String s3) {

		if(s1.length() + s2.length() != s3.length())
			return false;
		int m = s1.length();
		int n = s2.length();
		boolean[][] isreach = new boolean[m + 1][n + 1];
		for(int i = 0; i <= m; i++ ){
			for(int j = 0; j <= n; j++){
				if(i == 0 && j == 0)
					isreach[i][j] = true;
				else if(i == 0)
					isreach[i][j] = isreach[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
				else if(j == 0)
					isreach[i][j] = isreach[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
				else {
					isreach[i][j] = (isreach[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))) || (isreach[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)));
				}
			}
		}
		return isreach[m][n];
	}
	public static void main(String[] args) {
		InterleavingString test = new InterleavingString();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(test.isInterleave(s1, s2, s3));
	}
}
