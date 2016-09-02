
package matrix;

import base.Problem;

/**
 * @fun 矩阵问题的基类
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月30日下午4:59:16
 * @version 1.0
 * @since
 **/
public class MatrixProblem extends Problem {
	protected int[][] datas;

	public MatrixProblem(int[][] datas) {
		// TODO Auto-generated constructor stub
		this.datas = datas;
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		super.solve();
		return isVaild(datas);
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "MatrixProblem.";
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return datas;
	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		if (!isVaild(datas)) {
			return;
		}
		System.out.println("\n" + getDesc());
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[0].length; j++) {
				System.out.print("   " + datas[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean isVaild(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return false;
		}
		return true;
	}
}
