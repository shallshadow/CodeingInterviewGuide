
package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @fun ������������һ�����;���matrix��ʾһ�����磬1������·��0������·��ÿһ��λ��ֻҪ��Խ�磬������������4��������������Ͻǵ������½ǵ����ͨ·ֵ��
 * @author shadow
 * @Date 2016��9��21������9:49:19
 * @version 1.0
 * @since
 **/
public class MinPathValue {
	public static void main(String[] args) {
		int[][] m = {{1,0,1,1,1},{1,1,1,0,1},{1,1,1,1,1},{0,0,1,1,1}};
		System.out.println("min path value is : " + new MinPathValue().minPathValue(m));
	}
	
	/**
	 * ʹ��ͼ���еĿ�����ȱ����ķ�����ʱ�临�Ӷ�ΪO(N*M),����ռ临�Ӷ�ΪO(N*M)��
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
