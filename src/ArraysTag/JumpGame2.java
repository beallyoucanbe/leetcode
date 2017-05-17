package ArraysTag;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Your goal is to reach the last index in the minimum number of jumps.
 * return the minimum steps
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2.


 * 比之前的题目多了一个条件，要求在最少的步数内走到最后
 * 思路，思考每走一步所能到达的最远距离
 */
public class JumpGame2 {
	public int jump(int[] nums) {

		if(nums == null || nums.length == 0)
			return 0;
		if(nums[0] == 0)
			return -1;
		//记录两个中间变量，一个记录当前所等达到的最远距离，一个记录实际到达的最远距离
		int stepCur = 0;
		int stepmax = 0;  //当前步数所能达到的最大距离
		int step = nums[0];
		int pointMax = nums[0];  //当前节点所能达到的最大距离
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
