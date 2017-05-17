package ArraysTag;

import java.util.Arrays;

/*
 * 删除数列中的某个元素value,并返回新数组的长度
 */
public class RemoveElement {

	public int removeElement(int[] nums, int val) {

		int start = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[start] = nums[i];
				start++;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		RemoveElement test = new RemoveElement();
		int[] nums = { 2 };
		int a = test.removeElement(nums, 2);
		System.out.println(Arrays.toString(nums));
		System.out.println(a);
	}
}
