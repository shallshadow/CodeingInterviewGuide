
package other;

/**
 * @fun ����������
 * 		1.����һ���ȸ����������1~5���������rand1To5�������1~7�����������<br/>
 * 		2.����һ����p���ʲ���0����1-p���ʲ���1���������rand01p����1~6�����������<br>
 *      3.����һ���ȸ����������1~M���������rand1ToM����1~n�����������<br/>
 * @author shadow 
 * @Date 2016��9��11������11:56:51
 * @version 1.0
 * @since 
 **/
public class RandomExtend {
	
	public static void main(String[] args) {
		RandomExtend extend = new RandomExtend();
		int[] count = new int[10];
		for(int i = 0; i < 1000000; i++){
			count[extend.rand1ToN(10,6) - 1]++;
		}
		
		for(int i = 0; i < count.length; i++){
			System.out.println(i + "  " + count[i]);
		}

	}
	
	/**
	 * ����3
	 * @param m
	 * @return 1...m�ĵȸ��������
	 */
	public int rand1ToM(int m){
		return (int)(Math.random() * m) + 1;
	}	

	public int rand1ToN(int n, int m){
		if(n <= 1 || m <= 1){
			return 1;
		}
		int res = 0;
		int critical = (m * m - 1) / n * n;
		if(n > m){
			do{
				res = (rand1ToM(m) - 1) * m + rand1ToM(m) - 1;
			}while(res > critical - 1 && critical != 0);
			return res % n + 1;
		}else{
			do{
				res = rand1ToM(m);
			}while(res > n);
		}
		
		return res;
	}
	
	/**
	 * ����1
	 * ����������� 1...5
	 * @return
	 */
	public int rand1To5(){
		return (int)(Math.random() * 5) + 1;
	}
	
	/**
	 * ����1
	 * @return 1...7�ĵȸ����������
	 */
	public int rand1To7(){
		int num = 0;
		while(true){
			//��ն�,����0...24�������
			num = (rand1To5() -1) * 5 + rand1To5() - 1;
			//�ضϵ�0...20�������
			if(num < 21){
				break;
			}
		}		
		return num % 7;
	}
	
	/**
	 * ����2
	 * ����p��1-p�ĸ��ʲ���1��0
	 * @return
	 */
	public int rand01p(){
		double p = 0.83;
		return Math.random() < p ? 0 : 1;
	}
	
	/**
	 * ����2
	 * �ȸ��ʲ���0��1
	 * @return
	 */
	public int rand01(){
		int n;
		do{
			n = rand01p();
			//��ȡ0,1ʹ�������
		}while(n == rand01p());
		return n;
	}
	
	/**
	 * ����2
	 * �ȸ��ʲ���0...3
	 * @return
	 */
	public int rand0To3(){
		//��շ�
		return rand01() * 2 + rand01();
	}
	
	/**
	 * ����2
	 * �ȸ��ʲ���1...6
	 * @return
	 */
	public int rand1To6(){
		int num = 0;
		do{
			num = rand0To3() * 4 + rand0To3();
		}while(num > 6);
		
		return num % 6 + 1;
	}
}
