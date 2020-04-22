package BinarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 You are given a target value to search. If found in the array return true, otherwise return false.
 Example 1:
 Input: nums = [2,5,6,0,0,1,2], target = 0
 Output: true
 Example 2:
 Input: nums = [2,5,6,0,0,1,2], target = 3
 Output: false
 */
public class SearchinRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {

        if(null == nums || nums.length == 0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        if (map.containsKey(target)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        SearchinRotatedSortedArray2 test = new SearchinRotatedSortedArray2();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(test.search(nums, target));
    }
}
