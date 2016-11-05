
package other;
/**
 * @fun 问题描述：给定一个非负整数N，如果用二进制数表达N!的结果，返回最低位的1在哪个位置上，规定最右的位置为位置0。<br/>
 * @author shadow 
 * @Date 2016年9月12日下午7:05:47
 * @version 1.0
 * @since 
 **/
public class FactrialLastOnePos {
	public static void main(String[] args) {
		FactrialLastOnePos onePos = new FactrialLastOnePos();
		System.out.println("right one 1 : " + onePos.rightOne1(1000000000));
		System.out.println("right one 2 : " + onePos.rightOne2(1000000000));
	}
	/**
	 * 只要出现一个2就会向左移一位，统计2出现的个数。
	 * 根据观察可得出这样的公式：
	 * Z = N/(2^1) + N/(2^2) + N/(2^3) + ... + N/(2^i) (2 ^ i < N),其中Z为最低位出现的位置，N为阶乘数。
	 * @param num
	 * @return
	 * 时间复杂度：LogN
	 */
	public int rightOne1(int num){
		if(num < 1){
			return -1;
		}
		
		int res = 0;
		
		while(num != 0){
			num = num >>> 1;
			System.out.println(num);
			res += num;
		}
		
		return res;
	}
	/**
	 * 公式：Z = N - M，其中Z为所求的最低位出现的位置，N为阶乘数，M为N转换成二进制数表达式中1的个数。<br/>
	 * @param num
	 * @return
	 * 时间复杂度LogN
	 */
	public int rightOne2(int num){
		if(num < 1){
			return -1;
		}
		
		int ones = 0;
		int tmp = num;
		while(tmp != 0){
			ones += (tmp & 1) != 0 ? 1 : 0;
			System.out.println("tmp & 1 : " + (tmp & 1));
			tmp >>>= 1;
		}
		return num - ones;
	}
}
