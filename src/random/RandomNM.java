
package random;

/**
 * @fun ��������������һ���ȸ����������1~M���������rand1ToMʵ�ֵȸ����������1~N���������rand1ToN��
 * @author shadow 
 * @Date 2016��9��11������7:00:55
 * @version 1.0
 * @since 
 * 
 * @description
 * 1.�Ƚ�����ת��M���Ƶ�int����
 * 2.ͳ������λ������λ����������֣�����int������Խ����顣
 * 3.���������������ת��ʮ�������֡�
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
	 * ��valueת��m������
	 * @param value
	 * @param m
	 * @return m���Ƶ�����
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
	 * �ȸ����������һ��0~nMsys��Χ������ֻ��������m���Ʊ��
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
		//ÿ���������һλ
		while(index != nMSys.length){
			res[index] = rand1ToM(m) - 1;
			//�ж��Ƿ�Խ�磬ͨ���Աȵ�һλ���Ĵ�С
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
	 * ��m���Ƶ���ת��ʮ���Ƶ���
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
