package ArraysTag;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *For example:
 *A = [2,3,1,1,4], return true.
 *A = [3,2,1,0,4], return false.
 */
/*
 * 借鉴前面拆分单词的原理，新建一个boolean变量的数组, 但是，这种方法竟然超时了
 * 思路二，贪心算法，计算从某点开始所能向前跳跃的额最大距离，
 * 若每一点的最大距离都 < length, 则返回boolean；
 * 若有一点大于length， 则返回true
 */
public class JumpGame {

	public boolean canJump1(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int len = nums.length;
		boolean[] isReach = new boolean[len];
		isReach[0] = true; // 预处理，初始位置在第一点
		for (int i = 0; i < len; i++) {
			if (!isReach[i])
				continue;
			else {
				for (int j = i + 1; j <= i + nums[i] && j < len; j++)
					isReach[j] = true;
			}
			if (isReach[len - 1])
				return true;
		}
		return isReach[len - 1];
	}
	
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int len = nums.length;
		int step = nums[0];
		for(int i = 1; i < len; i++){
			if(step == 0)
				return false;
			step = Math.max(--step, nums[i]);
			if(step + i >= len - 1)
				return true;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
