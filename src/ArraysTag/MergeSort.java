package ArraysTag;

import java.util.Arrays;
/*
 * 练习归并排序
 * 归并排序（Merge Sort）是分治法（Divided and Conquer）的一种具体应用
 */

public class MergeSort {

	public void mergeSort(int[] nums){
		sort(nums, 0, nums.length - 1);
	}
	private void sort(int[] nums, int left, int right){
		
		int mid = left + (right - left) / 2;
		if(left < right){
			
			//左半部分排序
			sort(nums, left, mid);
			//右半部分排序
			sort(nums, mid + 1, right);
			//左右合并
			merge(nums, left, mid, right);
		}
	}
	private void merge(int[] nums, int left, int mid, int right){
		int[] temp = new int[right - left + 1];
		int i = left, j = mid + 1, k = 0;
		
		while(i <= mid && j <= right){
			if(nums[i] < nums[j])
				temp[k++] = nums[i++];
			else
				temp[k++] = nums[j++];
		}
		//如果前半部分还有元素剩余
		while(i <= mid){
			temp[k++] = nums[i++];
		}
		//如果后半部分还有元素剩余
		while(j <= right){
			temp[k++] = nums[j++];
		}
		//最后把临时数组中的元素复制到原数组的对应位置
		for (int k2 = 0; k2 < temp.length; k2++) {  
            nums[k2 + left] = temp[k2];  
        }  	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort test = new MergeSort(); 
		int[] nums = {4, 3, 2};
//		int[] nums = new int[10];
//		for(int i = 0; i < nums.length; i++)
//			nums[i] = (int)(Math.random() * 10);
		test.mergeSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
