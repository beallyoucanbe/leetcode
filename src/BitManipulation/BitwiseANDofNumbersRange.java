package BitManipulation;

public class BitwiseANDofNumbersRange {
	// ���ֱ�ӵذ취���������˺ܶ����ù�����ÿһλֻҪ��һ��0���־Ͷ���0
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
