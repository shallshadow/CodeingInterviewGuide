
package other;
/**
 * @fun ��������������һ���Ǹ�����N������N!�����ĩβΪ0��������<br/>
 * @author shadow 
 * @Date 2016��9��12������12:21:00
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
	 * ͨ�������׳�ÿ�������г���5�Ĵ������ó�ĩβ0�Ĵ���
	 * @param num 
	 * @return
	 * @description ʱ�临�Ӷ�:NLogN
	 */
	public int zeroNum1(int num){
		if(num < 0){
			return 0;
		}
		//����ͳ��
		int res = 0;
		//��ǰ�˵�����
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
	 * ͨ���۲�ó���ʽ��Z = N/5 + N/(5^2) + N/(5^3) + ... + N/(5^i) (5^i < N),����ZΪ�����N����ĩβΪ0������
	 * @param num
	 * @return
	 * @description ʱ�临�Ӷȣ�LogN
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
