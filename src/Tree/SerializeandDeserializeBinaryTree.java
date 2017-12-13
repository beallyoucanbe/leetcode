package Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work.
 *  You just need to ensure that a binary tree can be serialized to a string 
 *  and this string can be deserialized to the original tree structure.
 */
/*
 * 方法一：就用题目中经常给出的方法，层序遍历即可，空的地方用null或是*符号来代替
 */
public class SerializeandDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return null;
		StringBuilder resStr = new StringBuilder();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int queueLength = queue.size();
			for (int i = 0; i < queueLength; i++) {
				TreeNode node = queue.remove();
				if (node == null)   //要知道满二叉树第k层 有2^(k-1)个元素，而这里当出现一个null之后，后面就不会再有子节点了
					resStr.append("null,");
				else {
					resStr.append(node.val + ",");
					queue.add(node.left);
					queue.add(node.right);
				}
			}
		}
		return resStr.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		if(data == null || data.length() == 0)
			return null;
		String[] vals = data.split(",");
		int[] nums = new int[vals.length]; //数组用来记录第i个元素之前的null的个数
		TreeNode[] nodes = new TreeNode[vals.length];
		
		for(int i = 0; i < vals.length; i++){
			if(i > 0){
				nums[i] = nums[i - 1];
			}
			if(vals[i].equals("null")){
				nodes[i] = null;
				nums[i]++;
			} else{
				nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
			}
		}
		
		for(int i = 0; i < vals.length; i++){
			if(nodes[i] == null)
				continue;
			nodes[i].left = nodes[2 * (i - nums[i]) + 1];
			nodes[i].left = nodes[2 * (i - nums[i]) + 2];
		}
		return nodes[0];
	}

	public static void main(String[] args) {
		SerializeandDeserializeBinaryTree test = new SerializeandDeserializeBinaryTree();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		node1.left = node2;
		node1.right = node4;
		node2.left = node3;
		node3.right = node6;
		node4.left = node5;
		// System.out.println(node1.left.right == node6);
		System.out.println(test.serialize(node1));
		// System.out.println(ancesto.val);
	}

}
