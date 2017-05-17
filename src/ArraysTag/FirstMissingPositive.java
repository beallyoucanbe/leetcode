package ArraysTag;

import java.math.BigInteger;
import java.util.Arrays;

import LinkedList.SwapNodes;

/*
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
/*
 * ��FindtheDuplicateNumber��Ŀ�����ˣ�������������һ���ģ�
 * ֻ���������ҵ����ظ����Ǹ��� ���������ҵ�ȱʧ���Ǹ��������ǵ�һ���������Ƕ�������Բ���ʹ���������
 * ����������Ŀռ䣬���ǿ�����ԭ���������Ͻ��в��������ƶ�Ԫ�ء�
 * o��n��ʱ�临�ӶȲ�����ֻ����һ�Σ�ֻҪ�ڳ�����Χ�ڶ��ǿ��Ե�
 */

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {

		if (nums == null || nums.length == 0)
			return 1;
		int i = 0;
		while(i < nums.length){
			if(nums[i] == i + 1){
				i++;
				continue;
			}
			if(nums[i] > 0 && nums[i] < nums.length){
				if(nums[nums[i] - 1] != nums[i])
					swap(nums, i, nums[i] - 1);
				else {
					i++;
				}
			}
			else {
				i++;
			}
		}
		for(int j = 0; j < nums.length; j++)
			if(nums[j] != j + 1)
				return j + 1;
		return nums.length + 1; 
	}
	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	public static void main(String[] args) {
		FirstMissingPositive test = new FirstMissingPositive();
		int[] nums = {2,2,2,2,2};
		System.out.println(test.firstMissingPositive(nums));
		char a = 'a';
//		a = (char)(a + 1);
		System.out.println(a + 1);
	}
}
