package ArraysTag;

import java.util.Arrays;

/*
 * 数组是已经排好序的
 */

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return nums.length;

		int left = 0;
		int i = 1;
		while( i < nums.length ) {
			if (nums[i] != nums[left])
				nums[++left] = nums[i++];
			else
				i++;
		}
		return left + 1;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();
		int[] nums = { 1,2,2,3,3,3,4,4,4,4,4 };
		int a = test.removeDuplicates(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(a);
	}
}
