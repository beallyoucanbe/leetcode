package String;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S. A subsequence of a string is a new string which is formed from the
 * original string by deleting some (can be none) of the characters without
 * disturbing the relative positions of the remaining characters. (ie, "ACE" is
 * a subsequence of "ABCDE" while "AEC" is not). Here is an example: S =
 * "rabbbit", T = "rabbit" Return 3.
 * 
 * @author shuoyi.zhao
 *
 */
public class DistinctSubsequences {

		 public int numDistinct(String s, String t) {
		        int n = s.length(), m = t.length();
		        int[][] dp = new int[m+1][n+1];
		        for(int j = 0; j < n; j++){
		            dp[0][j] = 1;
		        }
		        for(int i = 1; i < m+1; i++){
		            for(int j = 1; j < n+1; j++){
		                if(s.charAt(j-1)==t.charAt(i-1)){
		                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
		                } else {
		                    dp[i][j] = dp[i][j-1];
		                }
		            }
		        }
		        return dp[m][n];
		    }
	
	public static void main(String[] args) {
		DistinctSubsequences test = new DistinctSubsequences();
		String s = "ab";
		String t = "";
		System.out.println(test.numDistinct(s, t));
	}
}
