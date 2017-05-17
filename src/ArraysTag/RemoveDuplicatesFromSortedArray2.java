package ArraysTag;

import java.util.Arrays;

/*
 * 这次每个元素最多可以出现两次，即允许1,1,2,2,的形式
 * 增加一个标志位flag来表示元素是否重复
 * 
 * if()
 * if() 语句的特点和
 * 
 * if()
 * else if()
 * else if()
 * 的区别
 * 如果只想让每次选择只进入一个选择语句就该用下面的
 * 上面的当第一个if执行完之后继续判断下面的额if语句是否符合条件，如果符合则继续进入if语句继续执行
 */
public class RemoveDuplicatesFromSortedArray2 {

	public int removeDuplicates(int[] nums) {

		if (nums.length <= 2)
			return nums.length;
		int left = 0;
		int i = 1;
		boolean flag = false;
		while (i < nums.length) {
			if (nums[i] != nums[left]) {
				nums[++left] = nums[i++];
				flag = false;
			}
			else if (nums[i] == nums[left] && flag == false) {
				nums[++left] = nums[i++];
				flag = true;
			}
			else if (nums[i] == nums[left] && flag == true)
				i++;
		}
		return left + 1;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray2 test = new RemoveDuplicatesFromSortedArray2();
		int[] nums = { 1,2,2};
		int a = test.removeDuplicates(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(a);
	}
}
