package ArraysTag;

import java.util.Arrays;

/*
 * 快速排序,当最后剩余数组大小<= 10时，采用冒泡排序
 */

public class QuickSort {

	public void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	
	public void quickSort(int[] nums, int left, int right) {
		if (right - left <= 10) {
			maoPao(nums, left, right);
			return;
		}
		int mid = (nums[left] + nums[right]) / 2;
		int i = left, j = right;
		while (i < j) {
			while (nums[i] < mid)
				i++;
			while (nums[j] >= mid)
				j--;
			if (i < j)
				swap(nums, i, j);
			else
				break;
		}
		quickSort(nums, left, i - 1);
		quickSort(nums, i, right);	
	}

	private void swap(int[] nums, int i, int j) {
		int temp = 0;
		temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// 单元采用冒泡排序
	public void maoPao(int[] nums, int left, int right) {
		for (int i = left; i < right; i++) {
			int min = nums[i], index = i;
			for (int j = i + 1; j <= right; j++) {
				if (nums[j] < min) {
					min = nums[j];
					index = j;
				}
			}
			swap(nums, i, index);
		}
	}

	public static void main(String[] args) {
		QuickSort test = new QuickSort();
		int[] nums = new int[1000];
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int) (Math.random() * 10000);
		System.out.println("排序前：");
		System.out.println(Arrays.toString(nums));
		System.out.println("排序后：");
		test.quickSort(nums);
		System.out.println(Arrays.toString(nums));
		
		
	}
}
