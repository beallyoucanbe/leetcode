package HashMap;
/*
 * Given a pattern and a string str, find if str follows the same pattern.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
Both pattern and str contains only lowercase alphabetical letters.
Both pattern and str do not have leading or trailing spaces.
Each word in str is separated by a single space.
Each letter in pattern must map to a word with length that is at least 1.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//����ֻ����һһƥ�䣬����Ҫͬʱ���һ��hashmap ��һ��set�����,����һ��set�����ã�һһ��Ӧ�����ܲ��ܳ���a-dog�� b-dog�����
public class WordPattern {

	public boolean WordPattern(String pattern, String str){
		
		if(pattern == null || str == null)
			return false;
		Map<Character, String> map = new HashMap<Character, String>();
		Set<String> set = new HashSet<String>();
		String[] strs = str.split(" ");
		char[] chars = pattern.toCharArray();
		
		if(strs.length != chars.length)
			return false;
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				if (!map.get(chars[i]).equals( strs[i]))   //�ַ��������һ����Ҫ��==��Ҫ��equals					
					return false;			
			} else {
				if (set.contains(strs[i])) 	
					return false;
				map.put(chars[i], strs[i]);
				set.add(strs[i]);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		WordPattern test = new WordPattern();
		String pattern = "abba";
		String str ="dog dog dog dog";
		if(test.WordPattern(pattern, str))
			System.out.println("true");
		else
			System.out.println("false");

	}

}
