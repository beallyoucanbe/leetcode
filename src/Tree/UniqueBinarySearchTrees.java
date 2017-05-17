package Tree;

/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 从1到n有多少不同的二叉搜索树
 */
public class UniqueBinarySearchTrees {

	public int numTrees(int n) {

		if(n < 0)
			return 0;
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for(int i = 2; i <= n; i++){
			for(int j = 0; j < i; j++){
				res[i] += res[j] * res[i - 1 - j];
			}
		}
		return res[n];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
