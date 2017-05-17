package DepthFirstSearch;
/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * ��void�����У����
 * return��
 * ��ʾֱ�ӽ������з���������
 * object.clone()������ʹ��
 * ���ȣ�Ҫ�ø÷�������Ҫ�������ʵ��Cloneable�ӿڣ�����ͻᱨ��
 * ��Σ�����clone�������ص���Object������ˣ�һ��Ҫ����ָ�����͡�
 * Ҳ���Բ�ʹ��clone����������ÿ�ζ�Ҫ��new new Stack<Integer>(path),������
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

import Tree.TreeNode;

/*
 * ���Ҫ�ҵ����з���������·���������������
 * Ҫ����������洢·���ϵ�����
 * ͨ��������ͬ��ʵ�ַ���������
 * return ��void �����о���Ҫ�˳�����
 */

public class PathSum_2 {

	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		Stack <Integer> path = new Stack<Integer>();
		pathSum(root, sum, path, results);
		return results;
	}
	
	private void pathSum(TreeNode root, int sum, Stack path, List<List<Integer>> result){
		if(root == null)
			return;
		path.push(root.val);
		if(root.left == null && root.right == null){
			if(sum == root.val)
				result.add((Stack<Integer>)(path.clone()));
		}
		pathSum(root.left, sum - root.val, path, result);
		pathSum(root.right, sum - root.val, path, result);
		path.pop();
	}
}
