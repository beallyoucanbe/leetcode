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
 * Ҫע����ǣ�candidate�е�Ԫ�ؿ������ظ��ģ���{1,1,2,3}���������Ҫ��֤Ψһ�ԡ�
 * ��1�еļ������õ�set���洢��ÿ��Ԫ�ض���Ψһ�ģ��ʲ����ڽ�����ظ��������
 * ����ʱ���ü��ϣ������ظ���Ԫ��
 * �ȿ���
 * 
 * set��Ϊ�������ж�set�ڵ�Ԫ����ͬʱ�ǰ���ʲôζ��׼��  (hashcode)
 * ��int��ֵ��
 * ��ôList<Integer>���ڴ��ַ���ǽ�����List�е�Ԫ��
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
			path.remove(path.size() - 1);  //������Ҫɾ����·��path�е����һ��Ԫ��
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
