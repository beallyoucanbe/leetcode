package ArraysTag;
/*
 * 目的是把连续的整数写成诸如“1->5”的形式来表示1,2,3,4,5
 */

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		int begin = 0;
		for(int i = 1; i < nums.length; i++){
			if(i == nums.length || nums[i] > nums[i - 1] + 1){
				StringBuilder sb = new StringBuilder();
				sb.append(nums[begin]);
				if(i > begin + 1){
					sb.append("->");
					sb.append(nums[i - 1]);
				}
				res.add(sb.toString());
				begin = i;
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		SummaryRanges test = new SummaryRanges();
		int[] nums = {1};
		List<String> res = new ArrayList<String>();
		res = test.summaryRanges(nums);
//		res.add("123");
//		res.add("234");
//		res.add("567");
		System.out.print("[");
		for(String str: res){
			System.out.print(str + ", ");
		}
		System.out.println("]");
	}
}
