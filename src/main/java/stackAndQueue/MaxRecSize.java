package stackAndQueue;

import java.util.Stack;

/**
 * @Date 2016年7月27日21:58:47
 * @Fun The size of the maximum sub matrix
 * @author shadow
 *
 */
public class MaxRecSize {
	public static void main(String[] args) {
		int[][] map = { 
				{ 1, 0, 1, 1 }, 
				{ 1, 1, 1, 1 }, 
				{ 1, 0, 1, 1 }, };
		System.err.println(new MaxRecSize().maxRecSize(map));
	}

	public int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}

		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			
			for (int j = 0; j < map[0].length; j++) {
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			//一层一层计算
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}

		return maxArea;
	}

	/**
	 * 从低到最高层的最大矩阵大小
	 * @param height
	 * @return
	 */
	public int maxRecFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(curArea, maxArea);
		}

		return maxArea;
	}

}
