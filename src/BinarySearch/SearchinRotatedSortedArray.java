package BinarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Created by zhaosy-c on 2019/5/17.
 */
public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {

        if(null == nums || nums.length == 0)
            return -1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        return -1;
    }

    public static void main(String[] args) {

        SearchinRotatedSortedArray test = new SearchinRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(test.search(nums, target));
    }
}
