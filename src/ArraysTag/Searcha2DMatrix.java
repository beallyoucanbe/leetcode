package ArraysTag;
/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */



public class Searcha2DMatrix {
	 public boolean searchMatrix(int[][] matrix, int target) {
		 if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			 return false;
		 int row = matrix.length;
		 int col = matrix[0].length;
		 int i;  //判断terget在那一列
		 if(target < matrix[0][0] || target > matrix[row - 1][col - 1])
			 return false;
		 if(target == matrix[0][0] || target == matrix[row - 1][col - 1])
			 return true;
		 for(i = 0; i < row; i++)
			 if(target < matrix[i][0])
				 break;
		 //target如果存在肯定在第i-1行，用二分法
		 return binarySearch(matrix[i - 1], target);
	    }
	 private boolean binarySearch(int[] nums, int target){
		 if(nums == null || nums.length == 0)
			 return false;
		 if(target < nums[0] || target > nums[nums.length - 1])
			 return false;
		 int left = 0, right = nums.length - 1;
		 while(left <= right && left <= nums.length - 1 && right <= nums.length - 1){
			 int mid = (right + left) / 2;
			 if(target == nums[mid])
				 return true;
			 else if(target < nums[mid])
				 right = mid - 1;
			 else 
				 left = mid + 1;
		 }
		 return false;
	 }
	 
	 public static void main(String[] args){
		 Searcha2DMatrix test = new Searcha2DMatrix();
		 int[][] nums = {{1},{3},{5}};
		 System.out.println(test.searchMatrix(nums, 3));
	 }
}
