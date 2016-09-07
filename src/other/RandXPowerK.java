
package other;
import java.util.*;
/**
 * @fun ����[0,x)�����ϵ������ֵĸ���<br/>
 *      ��������������һ������0������k�����ҿ���ʹ��Math.random()������<br/>
 *      ��ʵ��һ��������Ȼ������[0,1)��Χ�ϵ�����������[0,x)�����ϵ������ֵĸ���Ϊx^k(0<x<=1)<br/>
 * @author shadow 
 * @Date 2016��9��7������8:12:55
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
