package ArraysTag;

import java.util.Arrays;
/*
 * Rotate an array of n elements to the right by k steps. 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */

public class RotateArray {

	public void rotate(int[] nums, int k) {

		int len = nums.length;
		if(nums == null || len == 0)
			return;
		k = k % len;
		if(k == 0)
			return;
		rotate(nums, 0, len - 1);
		rotate(nums, 0, k - 1);
		rotate(nums, k, len - 1);
		
	}
	
	protected void rotate(int[] nums, int left, int right){
		if(nums == null || nums.length == 0 || right <= left)
			return;
		while(right > left){
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args){

		RotateArray test = new RotateArray();
		int[] nums = new int[10];
		
		test.rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
}
