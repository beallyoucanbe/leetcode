package DepthFirstSearch;
/**
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

 

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Tree.TreeNode;

public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {

		List<String> result = new ArrayList<String>();
		List<Integer> path = new ArrayList<Integer>(); //用来记录在路径上的数字
		treePath(root, path, result);
		return result;
	}
	
	private void treePath(TreeNode root, List<Integer> path, List<String> result) {
		if (root == null) {
			return;
		}
		path.add(root.getVal());
		if (root.getLeft() == null && root.getRight() == null) {
			StringBuilder buffer = new StringBuilder();
			for (Iterator<Integer> i = path.iterator(); i.hasNext();) {
				Integer a = (Integer) i.next();
				buffer.append(a + "->");
			}
			buffer.delete(buffer.length() - 2, buffer.length());
			result.add(new String(buffer));
		}
		treePath(root.getLeft(), path, result);
		treePath(root.getRight(), path, result);
		path.remove(path.size() - 1);
	}
	
	public static void main(String[] str){
		
		BinaryTreePaths test = new BinaryTreePaths();
		
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(5);
		TreeNode node10 = new TreeNode(1);
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		node3.setLeft(node5);
		node3.setRight(node6);
		node4.setLeft(node7);
		node4.setRight(node8);
		node6.setLeft(node9);
		node6.setRight(node10);
		
	    List<String> result = new ArrayList<String>();
		result = test.binaryTreePaths(node1);
		for(Iterator<String> i = result.iterator(); i.hasNext();){
			String strs = (String) i.next();
			System.out.println(strs);
		}
	}
}
