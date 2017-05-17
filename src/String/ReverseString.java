package String;
/**
 * Write a function that takes a string as input and returns the string reversed.
	Example:
	Given s = "hello", return "olleh".
 * @author shuoyi.zhao
 *
 */
public class ReverseString {

	public String reverseString(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--){
			stringBuilder.append(s.charAt(i));
		}
        return stringBuilder.toString();
	}
	public static void main(String[] args) {
		ReverseString test = new ReverseString();
		String string  = "hello";
		System.out.println(test.reverseString(string));
	}
}
