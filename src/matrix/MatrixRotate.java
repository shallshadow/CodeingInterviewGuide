
package matrix;
/**
 * @fun 矩阵顺时针 旋转90度
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月30日下午4:35:26
 * @version 1.0
 * @since 
 **/
public class MatrixRotate extends MatrixProblem {

	public MatrixRotate(int[][] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if(!super.solve()){
			return false;
		}
		
		rotate(datas);
		return true;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + "Rotate 90 degree";
	}
	
	/**
	 * 将矩阵旋转90度
	 * @param m
	 */
	public void rotate(int[][] m) {
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
			//行列向中间收缩
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
	private void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
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

	private boolean isVaild(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return false;
		}
		return true;
	}
}
