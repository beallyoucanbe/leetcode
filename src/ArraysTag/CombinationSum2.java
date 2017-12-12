package ArraysTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination. 
 * 要注意的是，candidate中的元素可能有重复的，如{1,1,2,3}，考虑如何要保证唯一性。
 * 在1中的集合是用的set来存储，每个元素都是唯一的，故不存在结果集重复的情况，
 * 但此时是用集合，会有重复的元素
 * 先考虑
 * 
 * set作为集合来判断set内的元素相同时是按照什么味标准的  (hashcode)
 * 如int是值，
 * 那么List<Integer>是内存地址还是仅仅是List中的元素
 */

public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return res;
		List<Integer> path = new ArrayList<Integer>();
		Arrays.sort(candidates);

		combinationSum2(candidates, target, -1, path, res);
		Set<List<Integer>> set = new HashSet<List<Integer>>(res);
		
		res.clear();
		res.addAll(set);
		return res;
	}

	public void combinationSum2(int[] candidates, int target, int j,
			List<Integer> path, List<List<Integer>> res) {
		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>(path);
			res.add(temp);
			return;
		}

		for (int i = j + 1; i < candidates.length; i++) {
			if (target < candidates[i])
				return;
			path.add(candidates[i]);
			combinationSum2(candidates, target - candidates[i], i, path, res);
			path.remove(path.size() - 1);  //在这里要删除掉路径path中的最后一个元素
		}
	}

	public static void main(String[] args) {
		CombinationSum2 test = new CombinationSum2();
		int[] candidates = {  1, 1, 2,3,5 };
		List<List<Integer>> res = test.combinationSum2(candidates, 2);
		System.out.println(Arrays.toString(candidates));

		for (List<Integer> item : res) {
			for (Integer k : item)
				System.out.print(k + " ");
			System.out.println();
		}
	}

}
