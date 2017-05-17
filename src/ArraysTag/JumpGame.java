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
 * ���ǰ���ֵ��ʵ�ԭ���½�һ��boolean����������, ���ǣ����ַ�����Ȼ��ʱ��
 * ˼·����̰���㷨�������ĳ�㿪ʼ������ǰ��Ծ�Ķ������룬
 * ��ÿһ��������붼 < length, �򷵻�boolean��
 * ����һ�����length�� �򷵻�true
 */
public class JumpGame {

	public boolean canJump1(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int len = nums.length;
		boolean[] isReach = new boolean[len];
		isReach[0] = true; // Ԥ������ʼλ���ڵ�һ��
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
