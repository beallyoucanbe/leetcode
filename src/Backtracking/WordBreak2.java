package Backtracking;

import java.util.HashSet;
import java.util.Set;
/*
 * 这里给出的是别人的算法，非常的精简，也采用了递归，
 * 其中第二个方法应用了动态规划，使后一次扫描能够利用前面扫描的结果，
 * 因此建立了判断数组boolean t[]
 * t[i] = true.表示从0到当前位置i, 存在一个或几个单词 使 word1 + word2 = wordi
 * 即F[0, end] = F[0, i] + F[i, j] + F[j, end];
 */

public class WordBreak2 {


	 public boolean wordBreak(String s, Set<String> wordDict) {
		 return wordBreak(s, wordDict, 0);        
	    }
	 public boolean wordBreak(String s, Set<String> wordDict, int start){
		 if(start == s.length())
			 return true;
		 for(String word: wordDict){
			 int len = word.length();
			 int end = start + len;
			 
			 if(end > s.length())
				 continue;
			 
			 if(s.substring(start, end).equals(word))
				 if(wordBreak(s, wordDict, end))
					 return true;
		 }
		 return false;
	 }
	 //应用动态规划的思想
	 public boolean wordBreak2(String s, Set<String> wordDict) {
		 boolean[] t = new boolean[s.length() + 1];
		 t[0] = true; // 设定起点
		 for(int i = 0; i < s.length(); i++){
			 if(!t[i])
				 continue; //当前值为false,说明从0到此位置不存在前缀的单词
			 for(String word: wordDict){ //对每一个可能的起点搜索所有的单词
				 int len = word.length();
				 int end = i + len;
				 
				 if(end > s.length() || t[end])
					 continue;
				 if(s.substring(i, end).equals(word))
					 t[end] = true;
			 }
		 }
		 return t[s.length()];
	 }
	 public static void main(String[] args) {
			WordBreak2 test = new WordBreak2();
			String s = "leetcode";
			Set<String> wordDict = new HashSet<String>();
			String[] words = { "leet", "code", "what", "your", "name" };
			for (String word : words)
				wordDict.add(word);
			if (test.wordBreak2(s, wordDict))
				System.out.println("true");
			else
				System.out.println("false");
		}
}
