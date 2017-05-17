package Tree;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 */

public class SumRoottoLeafNumbers {

	public int sumNumbers(TreeNode root) {

		if(root == null)
			return 0;
		int res = 0;
		StringBuilder str = new StringBuilder();
		List<String> list = new ArrayList<String>();
		sumNumbers(root, list, str);
	
		for(String item: list)
			res += Integer.parseInt(item);
		return res;
	}
	private void sumNumbers(TreeNode root, List<String> list, StringBuilder str){
		if(root == null)
			return;
		str.append(root.val);
		if(root.left == null && root.right == null){
			String nums = str.toString();
			list.add(nums);
			str.deleteCharAt(str.length() - 1);
		}	
		sumNumbers(root.left, list, str);
		sumNumbers(root.right, list, str);
	}
	
	
	/*
	 * 另外一种方法，不用存储每个路径的中间数，直接把它们加在总和上，可以省去很多中间过程，
	 * 这是， 只需要一个全局变量即可
	 */
	
	int sum = 0 ;
	public int sumNumbers2(TreeNode root){
		if(root == null)
			 return sum;	
		sumNumbers2(root, 0);
		return sum;
	}
	//这样值传递的迭代不会出现回溯修改的问题，因为每次都会记录当前的值
	private void sumNumbers2(TreeNode root, int num){
		num = num * 10 + root.val;
		if(root.left == null && root.right == null)
			sum += num;
		if(root.left != null)
			sumNumbers2(root.left, num);
		if(root.right != null)
			sumNumbers2(root.right, num);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
