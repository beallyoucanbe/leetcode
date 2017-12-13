package HashMap;
/*
 * Data structure design Total Accepted: 311 Total Submissions: 1345
 * Design and implement a TwoSum class. It should support the following operations:add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 */
import java.util.HashMap;
import java.util.Map;

public class TwoSum3 {

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public void addNumber(int num){
		if(map.containsKey(num))
			map.put(num, map.get(num) + 1);
		else
			map.put(num, 1);
	}
	//这里要考虑到重复的额情况，即一个数可以出现多次
	public boolean isFind(int target){
		for(Integer num: map.keySet()){
			int another = target - num;
			if(another == num && map.get(num) > 1) //出现相同的结果，此时要保证这个数至少出现两次
				return true;
			if(another != num && map.containsKey(another))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
