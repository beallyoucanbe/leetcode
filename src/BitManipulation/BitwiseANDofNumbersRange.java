package BitManipulation;

public class BitwiseANDofNumbersRange {
	// 最简单直接地办法，但是做了很多无用功，在每一位只要有一个0出现就都是0
	public int rangeBitwiseAnd(int m, int n) {

		int res = m;
		for(int i = m + 1; i <= n; i++)
			res &= i;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BitwiseANDofNumbersRange test = new BitwiseANDofNumbersRange();
		System.out.println(test.rangeBitwiseAnd(0, 
				2147483647));
		
	}

}
