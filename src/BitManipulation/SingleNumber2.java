package BitManipulation;

import java.util.Arrays;
/*
 * Given an array of integers, every element appears three times except for one.
 *  Find that single one.
 */
/*
 * 考虑int类型的存储方式，用4个字节共32个bit位来表示，
 * 如果我们把每一位的值都相加，对每个数来说都有三个0或是三个1，他们对3取余都为0，
 * 剩下的即为唯一的那个数
 * 我们可以用一个32位的数组来存储
 */

public class SingleNumber2 {

	 public int singleNumber2(int[] nums) {
		 int[] count = new int[32];
		 int res = 0;
		 for(int i = 0; i < 32; i++){
			 for(int j = 0; j < nums.length; j++)
				 count[i] += ((nums[j] >> i) & 1);
		 }
		 System.out.println(Arrays.toString(count));
		 for(int i = 31; i >= 0; i--)
			 res = (res << 1) | (count[i] % 3);
		 return res;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingleNumber2 test = new SingleNumber2();
		int[] nums = {2,3,3,3};
		System.out.println(test.singleNumber2(nums));
		
	}

}
