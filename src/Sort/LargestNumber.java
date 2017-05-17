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
		
		Arrays.sort(strs, new Com()); //Ĭ�ϵ�����˳��Ϊ��������
			
		for(int i = nums.length - 1; i >= 0; i--)
			str.append(strs[i]);
		// ������˰���000�������
		while(str.charAt(0) == '0' && str.length() > 1)
			str.deleteCharAt(0);
		
		return str.toString();
		
		
		
	}
	
	class Com implements Comparator<String>{
		
		public int compare(String str1, String str2){  
			String leftright = str1 + str2;
			String rightleft = str2 + str1;
			//��һ���ıȽϸ����ȥ����
			//˼�����������ַ������ܳ�ʱ�����޷�ʹ������ֱ�Ӱ��ַ���ת����Ϊint�ķ���
			//������ṩ����αȽ������ܴ�����ַ�����ɵ������Ĵ�С�����ȣ������Ȳ�ͬʱ���϶��ǳ��ȳ��Ĵ�
			//��������ͬʱ���Ϳ��԰��ձȽ��ַ����ķ�ʽȥ�Ƚ�
			//Ҫע������ַ��Ƚ�ʱ 1 > 2, ���ֱȽ�ʱ�պ��෴
			return leftright.compareTo(rightleft);
		}
	}

	public static void main(String[] args) {

		LargestNumber test = new LargestNumber();
		int[] nums = {1,2};
		System.out.println(test.largestNumber(nums));
	}

}
