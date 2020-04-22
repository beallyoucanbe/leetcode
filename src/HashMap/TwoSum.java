package HashMap;
/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input:numbers={2, 7, 11, 15}, target=9
 * Output:index1=1, index2=2
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] index = new int[2];
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], i);
		}
		//根据hashmap处理冲突的原理，在出现两个相同的值时，第二个会插在第一个前面，即取到的是第二个的index
		for(int i = 0; i < nums.length; i++){
			int another = target - nums[i];
			if(map.containsKey(another) && map.get(another) != i){
				 index[0] = i + 1;
				 index[1] = map.get(another) + 1;
				 break;
			}
			
		}
		return index;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum test = new TwoSum();
		int[] nums = {3,2,4,3};
		int[] index = test.twoSum(nums, 6);
		System.out.println(Arrays.toString(index));
	}
}
