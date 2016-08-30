
package dynamicprogramming;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月27日下午8:12:17
 * @version 1.0
 * @since
 **/
public class Matrix {
	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		showMatrix(m);
		
		System.out.println("minPathSum : " + minPathSum(m));
	}

	public static int minPathSum(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}

		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = 1;
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		showMatrix(dp);
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + m[0][i];
		}
		showMatrix(dp);
		
		for(int i = 1; i < row; i++){
			for(int j = 1; j < col; j++){
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		
		showMatrix(dp);		
		return dp[row - 1][col - 1];
	}

	public static void showMatrix(int[][] m) {
		System.out.println("Matrix:");
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
