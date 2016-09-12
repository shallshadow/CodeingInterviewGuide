
package other;
/**
 * @fun ��������������һ���Ǹ�����N������ö����������N!�Ľ�����������λ��1���ĸ�λ���ϣ��涨���ҵ�λ��Ϊλ��0��<br/>
 * @author shadow 
 * @Date 2016��9��12������7:05:47
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
	 * ֻҪ����һ��2�ͻ�������һλ��ͳ��2���ֵĸ�����
	 * ���ݹ۲�ɵó������Ĺ�ʽ��
	 * Z = N/(2^1) + N/(2^2) + N/(2^3) + ... + N/(2^i) (2 ^ i < N),����ZΪ���λ���ֵ�λ�ã�NΪ�׳�����
	 * @param num
	 * @return
	 * ʱ�临�Ӷȣ�LogN
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
	 * ��ʽ��Z = N - M������ZΪ��������λ���ֵ�λ�ã�NΪ�׳�����MΪNת���ɶ����������ʽ��1�ĸ���
	 * @param num
	 * @return
	 * ʱ�临�Ӷ�LogN
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
