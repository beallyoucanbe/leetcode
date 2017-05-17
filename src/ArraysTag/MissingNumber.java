package ArraysTag;
/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 *  find the one that is missing from the array.
 * For example, Given nums = [0, 1, 3] return 2.
 */

public class MissingNumber {

	 public int missingNumber(int[] nums) {
	        int n = nums.length + 1;
	        int res = 0;
	        for(int i = 0; i < nums.length; i++)
	        	res = res ^ nums[i];
	        for(int i = 0; i < n; i++ )
	        	res = res ^ i;
	        return res;
	    }
	 
	 public static void main(String[] args){
		 MissingNumber test = new MissingNumber();
		 int[] nums = {1,0,2,3,4,6};
		 System.out.println(test.missingNumber(nums));
	 }
}
