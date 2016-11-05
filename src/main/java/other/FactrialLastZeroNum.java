
package other;
/**
 * @fun 问题描述：给定一个非负整数N，返回N!结果的末尾为0的数量。<br/>
 * @author shadow 
 * @Date 2016年9月12日下午12:21:00
 * @version 1.0
 * @since 
 **/ 
public class FactrialLastZeroNum {
	
	public static void main(String[] args) {
		FactrialLastZeroNum num = new FactrialLastZeroNum();
		System.err.println("zero num 1 : " + num.zeroNum1(1000000000));
		System.err.println("zero num 2 : " + num.zeroNum2(1000000000));
	}
	
	/**
	 * 通过遍历阶乘每个乘数中出现5的次数来得出末尾0的次数
	 * @param num 
	 * @return
	 * @description 时间复杂度:NLogN
	 */
	public int zeroNum1(int num){
		if(num < 0){
			return 0;
		}
		//零数统计
		int res = 0;
		//当前乘的数字
		int cur = 0;
		for(int i = 5; i < num + 1; i += 5){
			cur = i;
			while(cur % 5 == 0){
				res++;
				cur /= 5;
			}
		}		
		return res;
	}
	
	/**
	 * 通过观察得出公式：Z = N/5 + N/(5^2) + N/(5^3) + ... + N/(5^i) (5^i < N),其中Z为所求的N！的末尾为0的数量
	 * @param num
	 * @return
	 * @description 时间复杂度：LogN
	 */
	public int zeroNum2(int num){
		if(num < 0){
			return 0;
		}
		
		int res = 0;
		while(num != 0){
			res += num / 5;
			num /= 5;
		}
		return res;
	}
}
