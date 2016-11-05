
package other;
import java.util.*;
/**
 * @fun 调整[0,x)区间上的数出现的概率<br/>
 *      问题描述：给定一个大于0的整数k，并且可以使用Math.random()函数，<br/>
 *      请实现一个函数依然返回在[0,1)范围上的数，但是在[0,x)区间上的数出现的概率为x^k(0<x<=1)<br/>
 * @author shadow 
 * @Date 2016年9月7日下午8:12:55
 * @version 1.0
 * @since 
 **/
public class RandXPowerK {
	
	public static void main(String[] args) {
		RandXPowerK powerK = new RandXPowerK();
		System.out.println("X : " +  powerK.randXPower(100));
	}
	
	
	public double randXPower(int k){
		if(k < 1){
			return 0;
		}
		double res = 0;
		for(int i = 0; i != k;i++){
			Random random = new Random();
			double d = random.nextDouble();
			System.out.println("Double " + i+ ": " + d);
			res = Math.max(res, d);
		}
		
		return res;
	}
}
