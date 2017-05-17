package BitManipulation;

import java.util.Arrays;
/*
 * Given an array of integers, every element appears three times except for one.
 *  Find that single one.
 */
/*
 * ����int���͵Ĵ洢��ʽ����4���ֽڹ�32��bitλ����ʾ��
 * ������ǰ�ÿһλ��ֵ����ӣ���ÿ������˵��������0��������1�����Ƕ�3ȡ�඼Ϊ0��
 * ʣ�µļ�ΪΨһ���Ǹ���
 * ���ǿ�����һ��32λ���������洢
 */

public class SingleNumber2 {

	 public int singleNumber2(int[] nums) {
		 int[] count = new int[32];
		 int res = 0;
		 for(int i = 0; i < 32; i++){
			 for(int j = 0; j < nums.length; j++)
				 count[i] += ((nums[j] >> i) & 1);
		 }
		 System.out.println(Arrays.toString(count));
		 for(int i = 31; i >= 0; i--)
			 res = (res << 1) | (count[i] % 3);
		 return res;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingleNumber2 test = new SingleNumber2();
		int[] nums = {2,3,3,3};
		System.out.println(test.singleNumber2(nums));
		
	}

}
