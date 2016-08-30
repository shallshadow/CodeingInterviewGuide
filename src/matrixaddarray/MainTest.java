
package matrixaddarray;

import base.IProblem;

/**
 * @fun 测试类
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月30日下午4:37:14
 * @version 1.0
 * @since 
 **/
public class MainTest {
	public static void main(String[] args) {
		int[][] datas = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		showMatrix(datas);
		
		IProblem[] problems = {new MatrixMinPathSum(datas),new MatrixCirclePrint(datas), new MatrixRotate(datas)};
		for(int i = 0; i < problems.length; i++){
			problems[i].solve();
			problems[i].showResult();
		}
	}
	
	public static void showMatrix(int[][] m) {
		System.out.println("Origin Matrix:");
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return;
		}

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print("   " + m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
