package ArraysTag;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 *  prove that at least one duplicate number must exist. 
 *  Assume that there is only one duplicate number, find the duplicate one.
 */

public class FindtheDuplicateNumber {

	public int findDuplicate(int[] nums) { // ���ַ�������һЩ���ֿ��ܲ����ڣ����ظ������ֿ����ظ����
		if (nums == null || nums.length == 0)
			return -1;
		int ln = nums.length;
		int res = 0;
		for (int i = 0; i < ln; i++)
			res ^= nums[i];
		for (int i = 1; i < ln; i++)
			res ^= i;
		return res;
	}

	public int findDuplicate2(int[] nums) { // ���Կ����ù�ϣ�����ǻ��������Ĵ洢�ռ�
		if (nums == null || nums.length == 0)
			return -1;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return nums[i];
			set.add(nums[i]);
		}
		return -1;
	}

	public int findDuplicate3(int[] nums){  // ����Ҫ�ö���Ŀռ䣬���ַ���ÿ����Сһ��ķ�Χ
		if (nums == null || nums.length == 0)
			return -1;
		int ln = nums.length;  // ���鳤��
		int left = 1, right = ln - 1;
		int mid = 0;
		while(left <= right){
			mid = (left + right) / 2;
			int count = 0;
			for(int i = 0; i < ln; i++)
				if(nums[i] <= mid)
					count++;
			if(count <= mid)
				right = mid + 1;
			else
				left = mid;
		}
		return mid;
	}
	public static void main(String[] args) {
		FindtheDuplicateNumber test = new FindtheDuplicateNumber();
		int[] nums = { 1, 2, 3, 4, 4, 5 };
		System.out.println(test.findDuplicate3(nums));
	}
}
/*
 * public class Solution {
    public int findDuplicate(int[] nums) {
        int min = 0, max = nums.length - 1;
        while(min <= max){
            // �ҵ��м��Ǹ���
            int mid = min + (max - min) / 2;
            int cnt = 0;
            // �������������ж��ٸ���С�ڵ����м���
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    cnt++;
                }
            }
            // ���С�ڵ����м��������������м�����˵��ǰ�벿�ֱ����ظ�
            if(cnt > mid){
                max = mid - 1;
            // �����벿�ֱ����ظ�
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}

 public int findDuplicate(int[] nums) {  
        int n = nums.length-1;  
        int low = 1, high= n;  
        int mid = 0;  
        while(low<high) {  
            mid = low + (high-low)/2;  
            int c= count(nums, mid); //count #numbers less than mid.  
            if(c<=mid) {  
                low = mid+1;  
            } else {  
                high = mid;  
            }  
        }  
        return low;  
    }  
      
*/
