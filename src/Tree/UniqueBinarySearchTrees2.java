package Tree;

import java.util.ArrayList;
import java.util.List;
/*
 *  Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *  难点是要存储并输出所有的二叉树
 */

public class UniqueBinarySearchTrees2 {
	public List<TreeNode> generateTrees(int n) {
		return generateTree(1, n);
	}
	
	private ArrayList<TreeNode> generateTree(int start, int end){
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if(start > end){
			res.add(null);
			return res;
		}
		ArrayList<TreeNode> leftTree = new ArrayList<TreeNode>();
		ArrayList<TreeNode> rightTree = new ArrayList<TreeNode>();
		for(int i = start; i <= end; i++){
			leftTree = generateTree(start, i - 1);
			rightTree = generateTree(i + 1, end);
			for(int j = 0; j < leftTree.size(); j++){
				for(int k = 0; k < rightTree.size(); k++){
					TreeNode n = new TreeNode(i + 1);
					n.left = leftTree.get(i);
					n.right = rightTree.get(k);
					res.add(n);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
