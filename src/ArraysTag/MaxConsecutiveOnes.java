package ArraysTag;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 Note:
 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000
 */

/**
 * Created by zhaosy-c on 2017/8/19.
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for(int n: nums)
            max = Math.max(max, cur = (n == 1 ? (cur + 1): 0));
//        for(int i = 0; i < nums.length; i++){
//            if( nums[i] == 1)
//                cur++;
//            else{
//                max = Math.max(cur, max);
//                cur = 0;
//            }
//            if(i == nums.length - 1)
//                max = Math.max(cur, max);
//        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes test = new MaxConsecutiveOnes();
        int[] nums = {1,1,0,1,1,1};
        System.out.println(test.findMaxConsecutiveOnes(nums));
    }
}
