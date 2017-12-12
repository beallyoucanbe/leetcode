package ArraysTag;

import java.util.Arrays;

/*
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */

public class KthLargestArray {

	public int findKthLargest(int[] nums, int k) {

		if(nums == null || nums.length <= k || k < 0)
			return Integer.MIN_VALUE;
		return quickSearch(nums, k, 0, nums.length - 1);
	}
	
	private int quickSearch(int[] nums, int k, int left, int right){
		int mid = (nums[left] + nums[right]) / 2;
		int i = left, j = right;
		while(i < j){
			while(nums[i] < mid)
				i++;
			while(nums[j] >= mid)
				j--;
			if(i < j)
				swap(nums, i, j);
			else
				break;
		}
		System.out.println("i = " + i + "  " + Arrays.toString(nums));
		if(right - i + 1 > k)
			quickSearch(nums, k, i, right);
		else if (right - i + 1 < k)
			quickSearch(nums, k - right + i - 1, left, i - 1);
		else
			return minVal(nums, i, right);
		return Integer.MIN_VALUE;
	}
	
	private int minVal(int[] nums, int left, int right){
		int minVal = nums[left];
		for(int i = left + 1; i <= right; i++)
			if(nums[i] > minVal)
				minVal = nums[i];
		return minVal;
	}
	private void swap(int[] nums, int i , int j){
		int temp = 0;
		temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args){
		KthLargestArray test =  new KthLargestArray();
		int[] nums = {8, 38, 31, 4, 16, 36, 71, 55, 98, 85};
//		for(int i = 0; i < nums.length; i++)
//			nums[i] = (int)(Math.random() * 100);
		System.out.println("排序前：" + Arrays.toString(nums));
		System.out.println(test.findKthLargest(nums, 3));
		
	}
}
