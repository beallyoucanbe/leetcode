package BitManipulation;

/*
 * Given an integer, write a function to determine if it is a power of two.
 * 如果从整数直接对2取余很容易，但是如何从二进制bit操作来判断,1也是2的零次幂
 */

public class PowerofTwo {

	public boolean isPowerOfTwo(int n) {

		if (n <= 0)
			return false;
		int count = 0;
		for (int i = 0; i < 32; i++)
			if (((n >> i) & 1) == 1)
				count++;
		if(count == 1)
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PowerofTwo test  = new PowerofTwo();
		System.out.println(test.isPowerOfTwo(9));
		
	}

}
