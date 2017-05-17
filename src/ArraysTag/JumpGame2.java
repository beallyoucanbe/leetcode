package ArraysTag;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Your goal is to reach the last index in the minimum number of jumps.
 * return the minimum steps
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2.


 * ��֮ǰ����Ŀ����һ��������Ҫ�������ٵĲ������ߵ����
 * ˼·��˼��ÿ��һ�����ܵ������Զ����
 */
public class JumpGame2 {
	public int jump(int[] nums) {

		if(nums == null || nums.length == 0)
			return 0;
		if(nums[0] == 0)
			return -1;
		//��¼�����м������һ����¼��ǰ���ȴﵽ����Զ���룬һ����¼ʵ�ʵ������Զ����
		int stepCur = 0;
		int stepmax = 0;  //��ǰ�������ܴﵽ��������
		int step = nums[0];
		int pointMax = nums[0];  //��ǰ�ڵ����ܴﵽ��������
		for(int i = 0; i < nums.length; i++){
			step = Math.max(--step, nums[i]);
			if(step == 0)
				return -1;
			pointMax = i + step;
			if(pointMax > stepmax){
				stepCur++;
				stepmax = pointMax;
			}
		}
		return stepCur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next 
station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 */
	}

}
