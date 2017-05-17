package Backtracking;

import java.util.HashSet;
import java.util.Set;
/*
 * ����������Ǳ��˵��㷨���ǳ��ľ���Ҳ�����˵ݹ飬
 * ���еڶ�������Ӧ���˶�̬�滮��ʹ��һ��ɨ���ܹ�����ǰ��ɨ��Ľ����
 * ��˽������ж�����boolean t[]
 * t[i] = true.��ʾ��0����ǰλ��i, ����һ���򼸸����� ʹ word1 + word2 = wordi
 * ��F[0, end] = F[0, i] + F[i, j] + F[j, end];
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
	 //Ӧ�ö�̬�滮��˼��
	 public boolean wordBreak2(String s, Set<String> wordDict) {
		 boolean[] t = new boolean[s.length() + 1];
		 t[0] = true; // �趨���
		 for(int i = 0; i < s.length(); i++){
			 if(!t[i])
				 continue; //��ǰֵΪfalse,˵����0����λ�ò�����ǰ׺�ĵ���
			 for(String word: wordDict){ //��ÿһ�����ܵ�����������еĵ���
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
