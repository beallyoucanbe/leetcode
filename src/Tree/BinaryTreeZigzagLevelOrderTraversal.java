package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
/*
 * 方法：先按照层序遍历一边，把值存储在数据结构中，最后统一控制输出
 */

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null)
			return res;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> numList = new ArrayList<Integer>();
			for(int i = 0; i < size; i++){
				TreeNode temp = queue.remove();
				numList.add(temp.val);
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}
			res.add(numList);
		}
		for(int i = 0; i < res.size(); i++){
			if(i % 2 == 1)
				reverseValue(res.get(i));
		}
		return res;
	}
	private void reverseValue(List<Integer> list){  //改方法用来将链表中的值前后交换
		if(list == null || list.size() <= 1)
			return;
		int i = 0, j = list.size() - 1;
		while(i < j){
			int temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
