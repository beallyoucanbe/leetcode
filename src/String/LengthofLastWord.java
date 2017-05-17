package String;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string. If the last word does not exist, return 0.
 */
public class LengthofLastWord {

	public int lengthOfLastWord(String s) {

		if(s == null || s.length() == 0)
			return 0;
		String[] strs = s.split(" ");
		if(strs.length == 0)
			return 0;
		return strs[strs.length - 1].length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LengthofLastWord test = new LengthofLastWord();
		String s = " ";
		System.out.println(test.lengthOfLastWord(s));
	}

}
