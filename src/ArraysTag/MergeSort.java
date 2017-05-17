package ArraysTag;

import java.util.Arrays;
/*
 * ��ϰ�鲢����
 * �鲢����Merge Sort���Ƿ��η���Divided and Conquer����һ�־���Ӧ��
 */

public class MergeSort {

	public void mergeSort(int[] nums){
		sort(nums, 0, nums.length - 1);
	}
	private void sort(int[] nums, int left, int right){
		
		int mid = left + (right - left) / 2;
		if(left < right){
			
			//��벿������
			sort(nums, left, mid);
			//�Ұ벿������
			sort(nums, mid + 1, right);
			//���Һϲ�
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
		//���ǰ�벿�ֻ���Ԫ��ʣ��
		while(i <= mid){
			temp[k++] = nums[i++];
		}
		//�����벿�ֻ���Ԫ��ʣ��
		while(j <= right){
			temp[k++] = nums[j++];
		}
		//������ʱ�����е�Ԫ�ظ��Ƶ�ԭ����Ķ�Ӧλ��
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
