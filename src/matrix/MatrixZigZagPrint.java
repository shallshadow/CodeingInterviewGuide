
package matrix;

/**
 * @fun 给定一个矩阵matrix，按照"之"字形的方式打印这个矩阵。
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月31日上午10:12:16
 * @version 1.0
 * @since
 **/
public class MatrixZigZagPrint extends MatrixProblem {

	private int[] result;

	public MatrixZigZagPrint(int[][] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if (!super.solve()) {
			return false;
		}
		result = printMatrixZigZag(datas);
		return true;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + "PrintZigZag ";
	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + " Result : ");
		if(result == null || result.length == 0){
			return;
		}
		
		for(int i = 0; i < result.length; i++){
			System.out.print(" " + result[i]);
		}
	}
	
	private int[] printMatrixZigZag(int[][] m) {
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		int endR = m.length - 1;
		int endC = m[0].length - 1;
		boolean fromUp = false;
		int[] result = new int[m.length * m[0].length];
		int count = 0;
		while (tR != endR + 1) {
			count = printLevel(datas, tR, tC, dR, dC, fromUp, result, count);			
			tR = tC == endC ? tR + 1 : tR;
			tC = tC == endC ? tC : tC + 1;
			dC = dR == endR ? dC + 1 : dC;
			dR = dR == endR ? dR : dR + 1;
			fromUp = !fromUp;
		}
		return result;
	}

	private int printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f, int[] result, int count) {
		if (f) {
			while (tR != dR + 1) {
				result[count++] = m[tR++][tC--];
			}
		} else {
			while (dR != tR - 1) {
				result[count++] = m[dR--][dC++];
			}
		}

		return count;
	}
}
