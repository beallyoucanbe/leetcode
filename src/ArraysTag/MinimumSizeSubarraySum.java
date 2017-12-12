package ArraysTag;
/*
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 先找到一个和大于给定值的子集，然后根据这个子集去讨论
 */

public class MinimumSizeSubarraySum {
	 public int minSubArrayLen(int s, int[] nums) {
	 
		 int start = 0;
		 int end = 0;
		 int sum = 0;
		 int min = Integer.MAX_VALUE;
		 
		 while(end < nums.length && end < nums.length){
			 while(sum < s && end < nums.length)
				 sum += nums[end++];
			 while(sum >= s && start < end)
			 {
				 min = Math.min(min, end - start);
				 sum -= nums[start++];
			 }
		 }
		 return min;
	 }
	 private void mian() {

		 MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
		 
	}
}
