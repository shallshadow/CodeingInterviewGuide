
package matrixaddarray;
/**
 * @fun ������
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��30������4:37:14
 * @version 1.0
 * @since 
 **/
public class MainTest {
	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		Matrix.showMatrix(m);
		//ѡ��Ҫ���Ե���
		int num = 1;
		switch (num) {
		case 0:
			System.out.println("minPathSum : " + Matrix.minPathSum(m));
			break;
		case 1:
			MatrixRotate.rotate(m);
			Matrix.showMatrix(m);
			break;

		default:
			break;
		}

	}
}
