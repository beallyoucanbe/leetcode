package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

/*
 * ��Ϊһ����������
 * int leftdepth = root.left == null ? Integer.MAX_VALUE
					: minDepth(root.left);
	��������仰�������˼
	���ĳһ���ڵ�ֻ��һ����ڵ�����ҽڵ㣬��ô����������ɴ��ڵĽڵ�������
	���ֻд�� leftdepth = minDepth(root.left);
	������ڵ�Ϊnull�������᷵��0������ȵĶ�����һ��Ҫ��Ҷ�ӣ�
	��ʱ�ͻ����
	�����һ������ֻ��һ�����ӣ���������ɴ��ڵĺ��ӽڵ��������ʱ��Ҫ������һ������ΪMAX
 */

/*
 * ����һ�ַ���Ϊ�������
 * ���������ԭ�������������ҵ���һ��Ҷ�ӽڵ�ʱ�Ĳ�����Ϊ��С���
 * ��������һ������һ�����к�һ��int ��������¼ÿһ���Ľڵ�������仯
 */

public class MinimumDepthOfBinaryTree2 {

	//�ݹ�ķ���
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		else {
			int leftdepth = root.left == null ? Integer.MAX_VALUE
					: minDepth(root.left);
			int rightdepth = root.right == null ? Integer.MAX_VALUE
					: minDepth(root.right);
			return Math.min(leftdepth, rightdepth) + 1;
		}
	}
	//����BFS������ȵķ���
	public int minDepthBFS(TreeNode root) {
		if(root == null)
			return 0;
		int depth = 1;
		int currentlevel = 1; //���嵱ǰ��Ľڵ���
		int nextlevel = 0; //������һ��Ľڵ���
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.remove();
			currentlevel--;
			if(node.left == null & node.right == null)
				return depth;
			if(node.left != null){
				queue.add(node.left);
				nextlevel++;
			}
			if(node.right != null){
				queue.add(node.right);
				nextlevel++;
			}
			if(currentlevel == 0){
				if(nextlevel != 0)
					depth++;
				currentlevel = nextlevel;
				nextlevel = 0;
			}
		}
		return depth;
	}

	public static void main(String[] str) {

		MinimumDepthOfBinaryTree2 test = new MinimumDepthOfBinaryTree2();

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
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node6.left = node9;
		node6.right = node10;

		int result = test.minDepth(node1);
		System.out.println("============");
		System.out.println(result);
	}
}
