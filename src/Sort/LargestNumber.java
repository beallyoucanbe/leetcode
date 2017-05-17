package Sort;

import java.util.Arrays;
import java.util.Comparator;
/*
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 */

public class LargestNumber {
	public String largestNumber(int[] nums) {

		StringBuilder str = new StringBuilder();
		if(nums == null || nums.length == 0)
			return str.toString();
		
		String[] strs= new String[nums.length];
		for(int i = 0; i < nums.length; i++)	
			strs[i] = Integer.toString(nums[i]);
		
		Arrays.sort(strs, new Com()); //默认的排列顺序为升序排列
			
		for(int i = nums.length - 1; i >= 0; i--)
			str.append(strs[i]);
		// 避免出此案“000”的情况
		while(str.charAt(0) == '0' && str.length() > 1)
			str.deleteCharAt(0);
		
		return str.toString();
		
		
		
	}
	
	class Com implements Comparator<String>{
		
		public int compare(String str1, String str2){  
			String leftright = str1 + str2;
			String rightleft = str2 + str1;
			//这一步的比较该如何去做，
			//思考，当两个字符串都很长时，就无法使用这种直接把字符串转换成为int的方法
			//这里就提供了如何比较两个很大的由字符串组成的整数的大小，首先，当长度不同时，肯定是长度长的大
			//当长度相同时，就可以按照比较字符串的方式去比较
			//要注意的是字符比较时 1 > 2, 数字比较时刚好相反
			return leftright.compareTo(rightleft);
		}
	}

	public static void main(String[] args) {

		LargestNumber test = new LargestNumber();
		int[] nums = {1,2};
		System.out.println(test.largestNumber(nums));
	}

}
