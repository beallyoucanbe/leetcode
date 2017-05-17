package ArraysTag;

/*
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
/*
 * 解决办法，动态规划，做好转移函数
 * 由于在数组中同时存在正数和负数，所以可以使用更为优化
 */

public class MaximumSubarray {

	public int maxSubArray(int[] nums) { // 算法超时
		if (nums == null || nums.length == 0)
			return Integer.MIN_VALUE;
		int ln = nums.length;
		int sumStart = nums[ln - 1], sumAll = nums[ln - 1];
		for (int i = ln - 2; i >= 0; i--) {
			sumStart = Math.max(nums[i] + sumStart, nums[i]);
			sumAll = Math.max(sumStart, sumAll);
		}
		return sumAll;
	}
	public int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0)
			return Integer.MIN_VALUE;
		int ln = nums.length;
		int sum = nums[0], sumAll = nums[0];
		for (int i = 1; i < ln; i++) {
			if (sum < 0)
				sum = 0;
			sum += nums[i];
			sumAll = Math.max(sum, sumAll);
		}
		return sumAll;
	}
	
	/*
	 *  int maxSubArray(int A[], int n) {
    int sum = A[0] , maxSum = A[0];
    for(int i = 1; i < n; i++){
      if(sum < 0) sum = 0;   //先判断之前的sum能否被这次利用（小于0则抛弃）
      sum += A[i];
      maxSum = max(maxSum, sum); 
    }
    return maxSum;
  }
	 */
	public static void main(String[] args) {
		MaximumSubarray test = new MaximumSubarray();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(test.maxSubArray2(nums));
	}
}
