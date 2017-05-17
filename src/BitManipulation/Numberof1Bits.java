package BitManipulation;
/*
 * Write a function that takes an unsigned integer and 
 * returns the number of ¡¯1' bits it has (also known as the Hamming weight).
 */

public class Numberof1Bits {

	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++)
        	if(((n >> i) & 1) == 1)
        		res++;
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Numberof1Bits test = new Numberof1Bits();
		int n = 11;
		System.out.println(test.hammingWeight(n));
	}

}
