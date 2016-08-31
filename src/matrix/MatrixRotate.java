
package matrix;
/**
 * @fun ����˳ʱ�� ��ת90��
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��30������4:35:26
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
	 * ��������ת90��
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
			//�������м�����
			rotateEdge(m, tR++, tC++, dR--, dC--);
		}
	}
	
	/**
	 * ��ӡ�߽�ֵ
	 * @param m ����
	 * @param tR �������
	 * @param tC �������
	 * @param dR �ұ�����
	 * @param dC �������
	 */
	private void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		// ������������
		int times = dC - tC;
		int tmp = 0;
		for (int i = 0; i != times; i++) {
			//����
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
