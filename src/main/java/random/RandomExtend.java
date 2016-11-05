
package random;

/**
 * @fun 问题描述：
 * 		1.给定一个等概率随机产生1~5的随机函数rand1To5，求产生1~7的随机函数。<br/>
 * 		2.给定一个以p概率产生0，以1-p概率产生1的随机函数rand01p，求1~6的随机函数。<br>
 *      3.给定一个等概率随机产生1~M的随机函数rand1ToM，求1~n的随机函数。<br/>
 * @author shadow 
 * @Date 2016年9月11日上午11:56:51
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
	 * 问题3
	 * @param m
	 * @return 1...m的等概率随机数
	 */
	public int rand1ToM(int m){
		return (int)(Math.random() * m) + 1;
	}	

	/**
	 * 问题三算法，目前不兼容(m * m - 1) / n * n == 0的情况，需要再多考虑。
	 * @param n
	 * @param m
	 * @return
	 */
	public int rand1ToN(int n, int m){
		if(n <= 1 || m <= 1){
			return 1;
		}
		int res = 0;
		int critical = (m * m - 1) / n * n;
		if(critical == 0){
			return -1;
		}
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
	 * 问题1
	 * 基础随机函数 1...5
	 * @return
	 */
	public int rand1To5(){
		return (int)(Math.random() * 5) + 1;
	}
	
	/**
	 * 问题1
	 * @return 1...7的等概率随机函数
	 */
	public int rand1To7(){
		int num = 0;
		while(true){
			//插空儿,构造0...24的随机数
			num = (rand1To5() -1) * 5 + rand1To5() - 1;
			//截断到0...20的随机数
			if(num < 21){
				break;
			}
		}		
		return num % 7;
	}
	
	/**
	 * 问题2
	 * 按照p或1-p的概率产生1或0
	 * @return
	 */
	public int rand01p(){
		double p = 0.83;
		return Math.random() < p ? 0 : 1;
	}
	
	/**
	 * 问题2
	 * 等概率产生0或1
	 * @return
	 */
	public int rand01(){
		int n;
		do{
			n = rand01p();
			//截取0,1使概率相等
		}while(n == rand01p());
		return n;
	}
	
	/**
	 * 问题2
	 * 等概率产生0...3
	 * @return
	 */
	public int rand0To3(){
		//插空法
		return rand01() * 2 + rand01();
	}
	
	/**
	 * 问题2
	 * 等概率产生1...6
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
