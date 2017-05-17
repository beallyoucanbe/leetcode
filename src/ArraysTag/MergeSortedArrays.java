package ArraysTag;

import java.util.Arrays;
/*
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 */

public class MergeSortedArrays {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
	
		int i,j,k;
		for(i = m -1, j = n - 1, k = m + n - 1; k >= 0; k--){
			if(j < 0 || (i >= 0 && nums1[i] >= nums2[j]))
				nums1[k] = nums1[i--];
			else
				nums1[k] = nums2[j--];
		}
	}
	
	public static void main(String[] args) {
		MergeSortedArrays test = new MergeSortedArrays();
		int[] nums1 = new int[4];
		nums1[0] = 2;
		int[] nums2 = {1};
		test.merge(nums1, 1, nums2, 1);
		System.out.println(Arrays.toString(nums1));
	}
}
