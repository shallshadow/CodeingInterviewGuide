
package random;

/**
 * @fun 问题描述：给定一个等概率随机产生1~M的随机函数rand1ToM实现等概率随机产生1~N的随机函数rand1ToN。
 * @author shadow 
 * @Date 2016年9月11日下午7:00:55
 * @version 1.0
 * @since 
 * 
 * @description
 * 1.先将数字转成M进制的int数组
 * 2.统计数组位数，按位随机生成数字，并对int数组做越界检验。
 * 3.将生产的随机数组转成十进制数字。
 * 
 **/
public class RandomNM {
	
	public static void main(String[] args) {
		RandomNM nm = new RandomNM();
		int n = 10;
		int m = 11;
		int[] datas = new int[n]; 
		for(int i = 0; i < n * 10000; i++){
			datas[nm.rand1ToN(n, m)]++;
		}
		
		for(int i = 0; i < datas.length; i++){
			System.out.println(i + "  " + datas[i]);
		}
	}
	
	public int rand1ToM(int m){
		return (int)(Math.random() * m) + 1;
	}
	
	public int rand1ToN(int n, int m){
		int[] nMsys = getMSysNum(n - 1, m);		
		int[] random = getRanMSysNumLessN(nMsys, m);
		return getNumForMSysNum(random, m);
	}
	
	/**
	 * 把value转成m进制数
	 * @param value
	 * @param m
	 * @return m进制的数组
	 */
	public int[] getMSysNum(int value, int m){
		int[] res = new int[32];
		int index = res.length - 1;
		while(value != 0){
			res[index--] = value % m;
			value = value / m;
		}
		return res;
	}
	/**
	 * 等概率随机产生一个0~nMsys范围的数，只不过是用m进制表达
	 * @param nMSys
	 * @param m
	 * @return
	 */
	public int[] getRanMSysNumLessN(int[] nMSys, int m){
		int[] res = new int[nMSys.length];
		int start = 0;
		while(nMSys[start] == 0){
			start++;
		}
		int index = start;
		boolean lastEqual = true;
		//每次随机产生一位
		while(index != nMSys.length){
			res[index] = rand1ToM(m) - 1;
			//判断是否越界，通过对比第一位数的大小
			if(lastEqual){
				if(res[index] > nMSys[index]){
					index = start;
					lastEqual = true;
					continue;
				}else{
					lastEqual = res[index] == nMSys[index];
				}
			}
			index++;
		}
		
		return res;
	}
	
	/**
	 * 将m进制的数转成十进制的数
	 * @param mSysNum
	 * @param m
	 * @return
	 */
	public int getNumForMSysNum(int[] mSysNum, int m){
		int res = 0;
		for(int i = 0; i!=mSysNum.length; i++){
			res = res * m + mSysNum[i];
		}
		
		return res;
	}
}
