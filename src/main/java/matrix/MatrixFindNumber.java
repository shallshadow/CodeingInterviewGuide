
package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @fun 给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一列都是排好序的。实现一个函数，判断K是否在matrix中。
 * @author shadow
 * @Date 2016年8月31日下午8:08:49
 * @version 1.0
 * @since
 **/
public class MatrixFindNumber extends MatrixProblem {

	private int mK;
	private List<Integer> result;

	public MatrixFindNumber(int[][] datas, int k) {
		super(datas);
		this.mK = k;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if (!super.solve()) {
			return false;
		}
		result = new ArrayList<>();
		isContain(datas, mK, result);
		return true;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + "MatrixFindNumber ";
	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		if (result == null ) {
			return;
		}
		System.out.println(getDesc() + " Result :");
		for(int i = 0; i < result.size(); i+=2){
			System.out.println("Row : " + result.get(i) + ",Col : " + result.get(i+1));
		}

	}

	private void isContain(int[][] matrix, int k, List<Integer> point) {
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (datas[row][col] == k) {
				point.add(row);
				point.add(col);
				break;
			} else if (datas[row][col] > k) {
				col--;
			} else if (datas[row][col] < k) {
				row++;
			}
		}
	}

}
