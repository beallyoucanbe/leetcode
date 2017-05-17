package ArraysTag;

import java.util.Arrays;

public class MoveZeros {

	public void moveZeroes(int[] nums) {

		int first = 0;
		int next = first + 1;
		
		while(first < nums.length){
			if(nums[first] != 0)
				first++;
			else{
				next = first + 1;
				while(next < nums.length && nums[next] == 0)
					next++;
				nums[first] = nums[first] ^ nums[next];
				nums[next] = nums[first] ^ nums[next];
				nums[first] = nums[first] ^ nums[next];			
				}
		}
	}
	
	public static void main(String[] args){
		MoveZeros test = new MoveZeros();
		int[] nums = {1,0,2,3,4};
		System.out.println(Arrays.toString(nums));
		test.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));

	}
}
