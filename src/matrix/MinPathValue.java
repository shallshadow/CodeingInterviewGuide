
package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @fun 问题描述：用一个整型矩阵matrix表示一个网络，1代表有路，0代表无路，每一个位置只要不越界，都有上下左右4个方向，求从最左上角到最右下角的最短通路值。
 * @author shadow
 * @Date 2016年9月21日上午9:49:19
 * @version 1.0
 * @since
 **/
public class MinPathValue {
	public static void main(String[] args) {
		int[][] m = {{1,0,1,1,1},{1,1,1,0,1},{1,1,1,1,1},{0,0,1,1,1}};
		System.out.println("min path value is : " + new MinPathValue().minPathValue(m));
	}
	
	/**
	 * 使用图论中的宽度优先遍历的方法。时间复杂度为O(N*M),额外空间复杂度为O(N*M)。
	 * @param m
	 * @return
	 */
	public int minPathValue(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}

		int res = 0;
		int[][] map = new int[m.length][m[0].length];
		map[0][0] = 1;
		Queue<Integer> rQ = new LinkedList<>();
		Queue<Integer> cQ = new LinkedList<>();
		rQ.add(0);
		cQ.add(0);
		int r = 0;
		int c = 0;
		while (!rQ.isEmpty()) {
			r = rQ.poll();
			c = cQ.poll();
			if (r == m.length - 1 && c == m[0].length - 1) {
				MainTest.showMatrix(map);
				return map[r][c];
			}
			// up
			walkTo(map[r][c], r - 1, c, m, map, rQ, cQ);
			// down
			walkTo(map[r][c], r + 1, c, m, map, rQ, cQ);
			// left
			walkTo(map[r][c], r, c - 1, m, map, rQ, cQ);
			// right
			walkTo(map[r][c], r, c + 1, m, map, rQ, cQ);
		}

		return res;
	}

	public void walkTo(int pre, int toR, int toC, int[][] m, int[][] map, Queue<Integer> rQ, Queue<Integer> cQ) {
		if (toR < 0 || toR == m.length || toC < 0 || toC == m[0].length || m[toR][toC] != 1 || map[toR][toC] != 0) {
			return;
		}

		map[toR][toC] = pre + 1;
	
		rQ.add(toR);
		cQ.add(toC);
	}
}
