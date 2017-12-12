package ArraysTag;

import java.util.HashMap;
import java.util.Map;

/*
 * 在以k + 1为大小的矩形框里，是否有两个相同的元素
 * a[i] = a[j], i,j最多相差为k，故矩形大小为k + 1
 */

public class ContainDuplicate2 {

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		if(nums.length <= 1 || k <= 0)
			return false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i <= Math.min(k, nums.length - 1); i++){
			if(map.containsKey(nums[i]))
				return true;
			else
				map.put(nums[i], i);
		}
		
		int left = 0, right = k;
		while(right < nums.length - 1){
			map.remove(nums[left++]);
			if(map.containsKey(nums[++right]))
				return true;
			else
				map.put(nums[right], right);
		}
		return false;
	}
	
	public static void main(String[] args) {
		ContainDuplicate2 test = new ContainDuplicate2();
		int[] nums = { 1, 1 };
		if (test.containsNearbyDuplicate(nums, 1))
			System.out.println("true");
		else
			System.out.println("false");

	}
}
