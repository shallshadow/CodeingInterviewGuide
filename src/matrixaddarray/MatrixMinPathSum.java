
package matrixaddarray;

/**
 * @fun �������С·��
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��27������8:12:17
 * @version 1.0
 * @since 
 **/
public class MatrixMinPathSum extends MatrixProblem {
	
	private int sum;
	
	public MatrixMinPathSum(int[][] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if(!super.solve()){
			return false;
		}
		
		sum = minPathSum(datas);
		
		return true;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + " MinPathSum ";
	}
	
	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + " Result : " + this.sum);
	}
	
	/**
	 * ��ȡ��С·��
	 * 
	 * @param m
	 * @return
	 */
	public static int minPathSum(int[][] m) {
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = 1;
		// �����һ������
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		//showMatrix(dp);
		// �����һ������
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + m[0][i];
		}
		//showMatrix(dp);
		// ���μ���ÿһ������
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}

		//showMatrix(dp);
		return dp[row - 1][col - 1];
	}

}
