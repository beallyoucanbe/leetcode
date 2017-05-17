package ArraysTag;

import java.util.HashMap;
import java.util.Map;

/*
 * ����k + 1Ϊ��С�ľ��ο���Ƿ���������ͬ��Ԫ��
 * a[i] = a[j], i,j������Ϊk���ʾ��δ�СΪk + 1
 */

public class ContainDuplicate2 {

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		if(nums.length <= 1 || k <= 0)
			return false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i <= Math.min(k, nums.length - 1); i++){
			if(map.containsKey(nums[i]))
				return true;
			else
				map.put(nums[i], i);
		}
		
		int left = 0, right = k;
		while(right < nums.length - 1){
			map.remove(nums[left++]);
			if(map.containsKey(nums[++right]))
				return true;
			else
				map.put(nums[right], right);
		}
		return false;
	}
	
	public static void main(String[] args) {
		ContainDuplicate2 test = new ContainDuplicate2();
		int[] nums = { 1, 1 };
		if (test.containsNearbyDuplicate(nums, 1))
			System.out.println("true");
		else
			System.out.println("false");

	}
}
