package ArraysTag;
/*
 * A peak element is an element that is greater than its neighbors.
 * For example, in array [1, 2, 3, 1], 3 is a peak element 
 * and your function should return the index number 2.
 */

public class FindPeakElement {

	public int findPeakElement(int[] nums) {

		if(nums == null || nums.length == 0)
			return -1;
		int ln = nums.length;
		if(ln == 1)
			return 0;
		if(nums[0] > nums[1])
			return 0;
		if(nums[ln - 1] > nums[ln - 2])
			return ln - 1;
		for(int i = 1; i < ln - 1; i++){
			if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
				return i;
		}	
		return -1;
	}
	public static void main(String[] args){
		FindPeakElement test = new FindPeakElement();
		int[] nums = {1, 2, 3, 1};
		System.out.println(test.findPeakElement(nums));
	}
	
}
