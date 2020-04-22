package TwoPointers;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 Example:

 Input: [2,3,1,2,4,3], s = 7
 Output: 2
 Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Created by zhaosy-c on 2018/5/4.
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        if(nums == null || nums.length <= 0)
            return 0;

        int start = 0;
        int end = 1;
        int sum = nums[start];
        int minLength = 0;

        for(;end < nums.length; end++){
            if (sum >= s){
                while(sum >= s){
                    minLength = (minLength == 0) ? (end - start) : Math.min(minLength, end - start);
                    sum = sum - nums[start];
                    start++;
                }
            }
            sum = sum + nums[end];
        }

        while(sum >= s){
            minLength = (minLength == 0) ? (end - start) : Math.min(minLength, end - start);
            sum = sum - nums[start];
            start++;
        }
        return minLength;
    }

    public static void main(String[] args){
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        System.out.println(test.minSubArrayLen(167, new int[]{84,-37,32,40,95}));
    }
}
