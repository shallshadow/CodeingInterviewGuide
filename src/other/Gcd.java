
package other;

/**
 * @fun ����������<br/>
 * 		��������������0������M��N����M��N�����Լ����<br/>
 * 		ŷ������㷨���ֳ�շת���������ʽΪ��m = nq + r;<br/>
 * @author shadow
 * @Date 2016��9��11������11:50:34
 * @version 1.0
 * @since
 **/
public class Gcd {
	public static int gcd(int m, int n) {
		return n == 0 ? m : gcd(n, m % n);
	}
}
