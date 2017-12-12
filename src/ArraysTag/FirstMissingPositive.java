package ArraysTag;

import java.math.BigInteger;
import java.util.Arrays;

import LinkedList.SwapNodes;

/*
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
/*
 * 把FindtheDuplicateNumber题目理解好了，这道题跟上面是一样的，
 * 只是上面是找到多重复的那个， 而这里是找到缺失的那个，而且是第一个，可以是多个，所以不能使用异或运算
 * 不开辟另外的空间，但是可以在原来的数组上进行操作，如移动元素。
 * o（n）时间复杂度不代表只遍历一次，只要在常数范围内都是可以的
 */

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {

		if (nums == null || nums.length == 0)
			return 1;
		int i = 0;
		while(i < nums.length){
			if(nums[i] == i + 1){
				i++;
				continue;
			}
			if(nums[i] > 0 && nums[i] < nums.length){
				if(nums[nums[i] - 1] != nums[i])
					swap(nums, i, nums[i] - 1);
				else {
					i++;
				}
			}
			else {
				i++;
			}
		}
		for(int j = 0; j < nums.length; j++)
			if(nums[j] != j + 1)
				return j + 1;
		return nums.length + 1; 
	}
	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	public static void main(String[] args) {
		FirstMissingPositive test = new FirstMissingPositive();
		int[] nums = {2,2,2,2,2};
		System.out.println(test.firstMissingPositive(nums));
		char a = 'a';
//		a = (char)(a + 1);
		System.out.println(a + 1);
	}
}
