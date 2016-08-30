
package matrixaddarray;


/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月30日下午4:50:13
 * @version 1.0
 * @since
 **/
public class MatrixCirclePrint extends MatrixProblem {

	private int[] result;
	
	public MatrixCirclePrint(int[][] datas) {
		// TODO Auto-generated constructor stub
		super(datas);
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if (!super.solve()) {
			return false;
		}
		result = spiralOrderPrint();
		return true;
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return this.result;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + "CirclePrint ";
	}
	
	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + " Result : ");
		for(int i = 0; i < result.length; i++){
			System.out.print(" " + result[i]);
		}
	}
	
	private int[] spiralOrderPrint() {
		int tR = 0;
		int tC = 0;
		int dR = datas.length - 1;
		int dC = datas[0].length - 1;
		int[] tmp = new int[datas.length * datas[0].length];
		int count = 0;
		while (tR <= dR && tC <= dC) {
			count = printEdge(tmp, tR++, tC++, dR--, dC--, count);
		}
		return tmp;
	}

	private int printEdge(int[] tmp, int tR, int tC, int dR, int dC, int count) {
		if (tR == dR) {
			for (int i = tC; i <= dC; i++) {
				tmp[count++] = datas[tR][i];
			}
		}else if(tC == dC){
			for(int i = tR; i <= dR; i++){
				tmp[count++] = datas[i][tC];
			}
		}else{
			int curC = tC;
			int curR = tR;
			
			while(curC != dC){
				tmp[count++] = datas[tR][curC++];
			}
			
			while(curR != dR){
				tmp[count++] = datas[curR++][dC];
			}
			
			while(curC != tC){
				tmp[count++] = datas[dR][curC--];
			}
			
			while(curR != tR){
				tmp[count++] = datas[curR--][tC];
			}
		}
		
		return count;
	}
}
