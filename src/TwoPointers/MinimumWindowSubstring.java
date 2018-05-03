package TwoPointers;


import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 Example:
 Input: S = "ADOBECODEBANC", T = "ABC"
 Output: "BANC"
 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".
 If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * Created by zhaosy-c on 2018/5/3.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if(s.length() < t.length())
            return "";

        int start = 0;
        int end = t.length();

        HashMap<Character, Integer> par = new HashMap<>();
        HashMap<Character, Integer> sub = new HashMap<>();

        for(char ch: s.substring(start, end).toCharArray()){
            if(par.containsKey(ch))
                par.put(ch, par.get(ch) + 1);
            else
                par.put(ch, 1);
        }

        for(char ch: t.toCharArray()){
            if(sub.containsKey(ch))
                sub.put(ch, sub.get(ch) + 1);
            else
                sub.put(ch, 1);
        }

        String result = "";

        while(end <= s.length() && start < end){
            String subStr = s.substring(start, end);
            if(isContain(par, sub)){
                if(result.equals("") || subStr.length() < result.length()){
                    result = subStr;
                }
                remove(par, s.charAt(start));
                start++;
            } else {
                if(end < s.length()){
                    add(par, s.charAt(end));
                    end += 1;
                }
                else{
                    remove(par, s.charAt(start));
                    start += 1;
                }
            }
        }

        return result;

    }

    private boolean isContain( HashMap<Character, Integer> par,  HashMap<Character, Integer> sub){

        boolean result = true;
        for(char ch: sub.keySet()){
            if(!par.containsKey(ch) || (par.get(ch).intValue() < sub.get(ch).intValue())){
                result = false;
                break;
            }
        }
        return result;
    }

    private void add(HashMap<Character, Integer> map, Character ch){
        if(map.containsKey(ch))
            map.put(ch, map.get(ch) + 1);
        else
            map.put(ch, 1);
    }

    private void remove(HashMap<Character, Integer> map, Character ch){
        if(map.get(ch).intValue() > 1)
            map.put(ch, map.get(ch) - 1);
        else
            map.remove(ch);
    }

    public static void main(String[] args){
        MinimumWindowSubstring test = new MinimumWindowSubstring();

        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(test.minWindow("aa", "aa"));
        System.out.println(test.minWindow("a", "aa"));
    }

}
