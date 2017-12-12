package ArraysTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 * 审题：每一个组合都是一个集合，故所有的数字不能重复
 */
public class CombinationSum3 {

	public List<List<Integer>> combinationSum3(int k, int n) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		int j = 1;
		combinationSum3(k, n, j, path, res);
		
		List<List<Integer>> newres = new ArrayList<List<Integer>>();
		for(List<Integer> item: res){
			if(item.size() == k)
				newres.add(item);
		}
		return newres;
	}
	
	public void combinationSum3(int k, int n, int j, List<Integer> path, List<List<Integer>> res){
		if(n == 0){
			ArrayList<Integer> temp = new ArrayList<Integer>(path);
			res.add(temp);
			return;
		}
		for(int i = j; i < 10; i++){
			if(n < i)
				return;
			path.add(i);
			combinationSum3(k, n - i, i + 1, path, res);
			path.remove(path.size() - 1);
		}	
	}
	
	public static void main(String[] args) {
		CombinationSum3 test = new CombinationSum3();
		List<List<Integer>> res = test.combinationSum3(3, 9);

		for (List<Integer> item : res) {
			for (Integer k : item)
				System.out.print(k + " ");
			System.out.println();
		}
	}
}
