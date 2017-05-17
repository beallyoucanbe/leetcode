package ArraysTag;

import java.util.Arrays;

/*
 * ���ÿ��Ԫ�������Գ������Σ�������1,1,2,2,����ʽ
 * ����һ����־λflag����ʾԪ���Ƿ��ظ�
 * 
 * if()
 * if() �����ص��
 * 
 * if()
 * else if()
 * else if()
 * ������
 * ���ֻ����ÿ��ѡ��ֻ����һ��ѡ�����͸��������
 * ����ĵ���һ��ifִ����֮������ж�����Ķ�if����Ƿ��������������������������if������ִ��
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
