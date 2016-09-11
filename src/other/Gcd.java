
package other;

/**
 * @fun 问题描述：<br/>
 * 		给定两个不等于0的整数M和N，求M和N的最大公约数。<br/>
 * 		欧几里得算法，又称辗转相除法。公式为：m = nq + r;<br/>
 * @author shadow
 * @Date 2016年9月11日上午11:50:34
 * @version 1.0
 * @since
 **/
public class Gcd {
	public static int gcd(int m, int n) {
		return n == 0 ? m : gcd(n, m % n);
	}
}
