package DepthFirstSearch;
/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 在递归的过程中，如何控制好变量的作用域。
 * 比如说本过程中的root,
 * 在递归的过程中会产生new TreeNode,
 * 引用类型和基本数据类型的使用方法
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Tree.TreeNode;

public class ArrayToBinary {

	public TreeNode sortedArrayToBST(int[] nums){
		if(nums == null || nums.length < 1)
			return null;
		return sortedArrayToBSTnums(nums, 0, nums.length - 1);
	}
	
	private TreeNode sortedArrayToBSTnums(int[] nums, int left, int right){
		if(left > right)
			return null;
		
		if(left == right)
			return new TreeNode(nums[left]);
		
		int mid = (left + right) / 2;	
		TreeNode root = new TreeNode(nums[mid]);		
		root.left = sortedArrayToBSTnums(nums, left, mid - 1);
		root.right = sortedArrayToBSTnums(nums, mid + 1, right);
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayToBinary test = new ArrayToBinary();
		int[] nums = { 1, 2, 3, 4, 5 };
		TreeNode root = test.sortedArrayToBST(nums);

		BinaryTreePaths test1 = new BinaryTreePaths();
		List<String> result = new ArrayList<String>();
		result = test1.binaryTreePaths(root);
		for (Iterator<String> i = result.iterator(); i.hasNext();) {
			String strs = (String) i.next();
			System.out.println(strs);
		}
	}
}
