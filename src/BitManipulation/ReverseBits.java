package BitManipulation;

import java.util.Arrays;

/*
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
*/
/*
 * 先假设都是正整数，写出相应的算法，在考虑负数的问题
 * 可以用32位byte来存储相应的数字
 */
public class ReverseBits {

	 public int reverseBits(int n) {
	        int[] bitVal = new int[32];
	        int res = 0;
	        for(int i = 0; i < 32; i++)
	        	bitVal[i] = (n >> i) & 1;
	        //数组中第i位存储第i位bit值，在把数组反过来表示
	        for(int i = 0; i < 32; i++)
	        	res = (res << 1) | bitVal[i];
	        return res;
	       
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseBits test = new ReverseBits();
		int n = 43261596;
		System.out.println(test.reverseBits(n));
		
	}

}
