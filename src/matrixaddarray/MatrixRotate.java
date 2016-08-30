
package matrixaddarray;
/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月30日下午4:35:26
 * @version 1.0
 * @since 
 **/
public class MatrixRotate {

	/**
	 * 将矩阵旋转90度
	 * @param m
	 */
	public static void rotate(int[][] m) {
		if (!isVaild(m)) {
			return;
		}
	
		if (m.length != m[0].length) {
			return;
		}

		int tR = 0;
		int tC = 0;
		int dR = m.length - 1;
		int dC = m[0].length - 1;
	
		while (tR < dR) {
			rotateEdge(m, tR++, tC++, dR--, dC--);
		}
	}
	
	/**
	 * 打印边界值
	 * @param m 矩阵
	 * @param tR 左边行数
	 * @param tC 左边列数
	 * @param dR 右边行数
	 * @param dC 左边列数
	 */
	private static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		// 调整的总组数
		int times = dC - tC;
		int tmp = 0;
		for (int i = 0; i != times; i++) {
			//调整
			tmp = m[tR][tC + i];
			m[tR][tC + i] = m[dR - i][tC];
			m[dR - i][tC] = m[dR][dC - i];
			m[dR][dC - i] = m[tR + i][dC];
			m[tR + i][dC] = tmp;
		}
	}

	private static boolean isVaild(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return false;
		}
		return true;
	}
}
