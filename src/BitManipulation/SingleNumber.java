package BitManipulation;

/*
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 */

public class SingleNumber {

	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++)
			res ^= nums[i];
		return res;

	}

	public static void main(String[] args) {
		SingleNumber test = new SingleNumber();
		int[] nums = { 1, 2, 3, 4, 2, 3, 4 };
		System.out.println(test.singleNumber(nums));
	}
}
