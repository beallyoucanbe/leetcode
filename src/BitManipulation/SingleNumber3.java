package BitManipulation;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * Given an array of numbers nums, in which exactly two elements appear only once 
 * and all the other elements appear exactly twice. Find the two elements that appear only once.
 */
public class SingleNumber3 {

	 public int[] singleNumber3(int[] nums) {
		 int[] res = new int[2];
		 if(nums == null || nums.length == 0)
			 return res;
		 int a = 0;
		 for(int i = 0; i < nums.length; i++){
			 a ^= nums[i];
		 }
		 int k = 0;
	     for(k = 0; k < 32; k++){
	    	 if(((a >> k) & 1) == 1)
	    		 break;
	     }
	     for(int i = 0; i < nums.length; i++){
	    	 if(((nums[i] >> k) & 1) == 1)
	    		res[0] ^= nums[i];
	    	 else 
	    		res[1] ^= nums[i];
	     }
	     return res;
	 }
	 
	public static void main(String[] args) {
		SingleNumber3 test = new SingleNumber3();
		int[] nums = {1,1,2,2,3,4,5,4};
		int[] res = test.singleNumber3(nums);
		System.out.println(Arrays.toString(res));
	}
}
