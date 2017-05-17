package DepthFirstSearch;
/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 在void方法中，语句
 * return；
 * 表示直接结束运行方法并返回
 * object.clone()方法的使用
 * 首先，要用该方法必须要对象的类实现Cloneable接口，否则就会报错；
 * 其次，由于clone方法返回的是Object对象，因此，一定要给他指定类型。
 * 也可以不使用clone方法，但是每次都要用new new Stack<Integer>(path),来代替
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

import Tree.TreeNode;

/*
 * 这次要找到所有符合条件的路径，并把它输出来
 * 要考虑如何来存储路径上的数字
 * 通过参数不同来实现方法的重载
 * return 在void 方法中就是要退出方法
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
