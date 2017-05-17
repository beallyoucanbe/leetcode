package HashMap;
/*
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * ��֮ǰ two sum �� fllow up question, ���������given an array is already sorted in ascending order. �볢�� O(log n)��ʱ������������ʼ�������������д������뷨��
 */
public class Twosum2 {

	public int[] twoSum(int[] nums, int target){
		if(nums == null || nums.length < 1)
			return null;
		int left = 0, right = nums.length - 1;
		int[] index = new int[2];
		while(left <= right){
			if(nums[left] + nums[right] < target)
				left++;
			else if(nums[left] + nums[right] > target)
				right--;
			else{
				index[0] = left;
				index[1] = right;
				return index;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
