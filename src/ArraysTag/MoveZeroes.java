package ArraysTag;

import java.util.Arrays;

/*
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
/*
 * 思路，用双指针，一个记录当前0，一个记录当前非0
 * count用来计数，共有多少个0
 */

public class MoveZeroes {

	public void moveZeroes(int[] nums) {

		if(nums.length == 0)
			return;
		int ln = nums.length;
		int i = 0, j = 0;
		while(true){	
			if(nums[j] == 0){
				j++;
				if(j == ln)
					break;	
				continue;
			} 
			System.out.println("j=  " + j);
			nums[i++] = nums[j++];	
			if(j > ln - 1)
				break;		
		}
		for(; i < ln; i++)
			nums[i] = 0;
	}

	public static void main(String[] args){
		MoveZeroes test = new MoveZeroes();
		int[] nums = {0,0,3,0,8,0,9};
		test.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}
