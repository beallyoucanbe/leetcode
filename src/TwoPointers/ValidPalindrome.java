package TwoPointers;

/*
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 * For example, "A man, a plan, a canal: Panama" is a palindrome. 
 * "race a car" is not a palindrome.
 */

public class ValidPalindrome {

	public boolean isPalindrome(String s) {

		if (s == null || s.length() == 0)
			return true;
		StringBuilder tempStr = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
				tempStr.append(c);
		}
		String newStr = tempStr.toString();
		String lowStr = newStr.toLowerCase();
		System.out.println(lowStr);
		for(int i = 0, j = lowStr.length() - 1; i <= j; i++, j--)
			if(lowStr.charAt(i) != lowStr.charAt(j))
				return false;
		return true;
	}
//	public boolean isPalindrome2(String s) {
//
//		if (s == null || s.length() == 0)
//			return false;
//		for(int i = 0, j = s.length() - 1; i <= j; i++, j--){
//			while(s.charAt(i))
//				i++;
//			while(s.charAt(j))
//				j++;
//			if(s.charAt(i) != s.charAt(j) && s.charAt(i) != s.charAt(j))
//		
//				return false; 
//				}
//		return true;
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome test = new ValidPalindrome();
		String s = "0P";
		System.out.println(test.isPalindrome(s));
	}

}
