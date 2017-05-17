package ArraysTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times. 
 * Ԫ���ڼ����е�˳���ǵ�����
 * DFS����
 * 
 */

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0) 
			return res;
		List<Integer> path = new ArrayList<Integer>();
		Arrays.sort(candidates); //�������������
		
		combinationSum(candidates, target, 0, path, res);
		
		return res;	
	}
	
	public void combinationSum(int[] candidates, int target, int j, List<Integer> path, List<List<Integer>> res){
		if(target == 0){
			ArrayList<Integer> temp = new ArrayList<Integer>(path);//�½���һ��List���õ�ǰ��list��ֵ��
			res.add(temp);
			return;       //  ��ϸ�������������return�����ã�������������������ֵʱ����ʱ������ǰ��ѭ�������ݵ�ǰһ�����һ��ѭ��
		}
		
		for(int i = j; i < candidates.length; i++){
			if(target < candidates[i])
				return;  //��ϸ�������������return�����ã�������������������ֵʱ����ʱ������ǰ��ѭ�������ݵ�ǰһ�����һ��ѭ��
			path.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, path, res);
			path.remove(path.size() - 1);
		}
	}
	
	public static void main(String[] args){ 
		CombinationSum test = new CombinationSum();
		int[] candidates = {1,1,2,3,6,7};
		List<List<Integer>> res = test.combinationSum(candidates, 3);
		
		for(List<Integer> item: res){
			for(Integer k: item)
				System.out.print(k + " ");
			System.out.println();
		}
	}
}
