package ArraysTag;

/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
/*
 * 首先，暴力搜索，i和j的话为(j-i)*Math.min(heighti, heightj);
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {

		if (height == null || height.length <= 1)
			return 0;
		int max = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			int temp = (j - i) * Math.min(height[i], height[j]);
			max = Math.max(max, temp);
			if (height[i] < height[j])
				i++;
			else
				j--;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
