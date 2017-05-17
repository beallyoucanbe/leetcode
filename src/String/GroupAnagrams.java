package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat","tea","tan","ate","nat","bat"], Return:
 * 
 * [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * @author shuoyi.zhao
 *
 */
public class GroupAnagrams {

	 public List<List<String>> groupAnagrams(String[] strs) {
		 if(strs == null || strs.length == 0)
			 return null;
		 Map<String, List<String>> map = new HashMap<String, List<String>>();
		 for(String str: strs){
			 char[] chars = str.toCharArray();
			 Arrays.sort(chars);
			 String tmp = new String(chars);
			 List<String> list = map.get(tmp);
			 if(list == null)
				 list = new LinkedList<String>();
			 list.add(str);
			 map.put(tmp, list);
		 }
		 List<List<String>> res = new ArrayList<List<String>>(); 
		 for(String str: map.keySet()){
			 List<String> words = map.get(str);
			 Collections.sort(words);
			 res.add(words);
		 }
		 return res;
	 }
}
