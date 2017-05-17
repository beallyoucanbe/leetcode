package HashMap;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordAbbreviation {

	Map<String, String> map = new HashMap<String, String>();
	
//	public UniqueWordAbbreviation(String dictionary){
//		
//	} 
	public String getAbbreviation(String str){
		if(str.length() <= 2)
			return str;
		return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueWordAbbreviation test = new UniqueWordAbbreviation();
		System.out.println(test.getAbbreviation("syuuutring"));
	}

}
