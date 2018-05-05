package TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string.
 * If there are more than one possible results, return the longest word with the smallest lexicographical order.
 * If there is no possible result, return the empty string.

 Example 1:
 Input:
 s = "abpcplea", d = ["ale","apple","monkey","plea"]

 Output:
 "apple"
 Example 2:
 Input:
 s = "abpcplea", d = ["a","b","c"]

 Output:
 "a"
 Note:
 All the strings in the input will only contain lower-case letters.
 The size of the dictionary won't exceed 1,000.
 The length of all the strings in the input won't exceed 1,000.
 * Created by zhaosy-c on 2018/5/4.
 */
public class LongestWordinDictionarythroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        List<String> allFitStr = new ArrayList<>();
        for (String str : d){
            if(isSub(s, str))
                allFitStr.add(str);
        }
        if(allFitStr.size() == 0)
            return "";
        for (String str: allFitStr){
            if(str.length() > res.length() || (str.length() == res.length() && res.compareTo(str) > 0))
                res = str;
            }
        return res;
    }

    public boolean isSub(String par, String sub){
        int index = 0;
        int j = 0;
        while(j < sub.length()){
            char ch = sub.charAt(j);
            index = par.indexOf(ch, index);
            if(index == -1)
                return false;
            j++;
            index++;
        }
        return true;
    }

    public static void main(String[] args){
        LongestWordinDictionarythroughDeleting test = new LongestWordinDictionarythroughDeleting();

        String[] array = new String[]{"ale","apple","monkey","plea"};
        String parent = "abpcplea";

        List<String> stringList = new ArrayList<>();
        for(String str : array)
                stringList.add(str);

        System.out.println(test.findLongestWord(parent, stringList));
    }

}
