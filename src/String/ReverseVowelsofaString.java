package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of
 * a string. Example 1: Given s = "hello", return "holle". Example 2: Given s =
 * "leetcode", return "leotcede". Note: The vowels does not include the letter
 * "y".
 * a，e，i，o，u
 * @author shuoyi.zhao
 *
 */
public class ReverseVowelsofaString {

	public String reverseVowels(String s) {

		char[] vowels = {'a', 'e','i', 'o','u'};
		Set<Character> chars = new HashSet<>();
		for(char ch : vowels){
			chars.add(ch);
		}
		char[] strings = s.toCharArray();
		int i = 0;
		int j = strings.length - 1;
		while(i > j){
			while(!chars.contains(strings[i])){
				i++;
			}
			while(!chars.contains(strings[j])){
				j--;
			}
			char temp = strings[i];
			strings[i] = strings[j];
			strings[j] = temp;
		}
		return Arrays.toString(strings);
	}

	public static void main(String[] args) {
		ReverseVowelsofaString test = new ReverseVowelsofaString();
		String string = "hello";
		System.out.println(test.reverseVowels(string));
	}
}
