package BitManipulation;

/*
 * Given an integer, write a function to determine if it is a power of two.
 * ���������ֱ�Ӷ�2ȡ������ף�������δӶ�����bit�������ж�,1Ҳ��2�������
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
