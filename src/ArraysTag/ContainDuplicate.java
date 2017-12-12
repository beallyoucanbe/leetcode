package ArraysTag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 判断数组是否有重复的元素，可以用哈希表
 */

public class ContainDuplicate {

	public boolean containsDuplicate(int[] nums) {

		if (nums.length <= 1)
			return false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]))
				return true;
			else
				map.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		ContainDuplicate test = new ContainDuplicate();
		int[] nums = { 1, 2 };
		if (test.containsDuplicate(nums))
			System.out.println("true");
		else
			System.out.println("false");

	}

}
