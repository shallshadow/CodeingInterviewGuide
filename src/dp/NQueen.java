
package dp;

import java.io.BufferedWriter;
import java.util.Queue;

/**
 * @fun ������������N*N��������Ҫ��N���ʺ�Ҫ���κ������ʺ�ͬ�У���ͬ�У�Ҳ����ͬһ��б���ϡ�<br/>
 * 		����һ������n������n�ʺ�İڷ��ж����֡�<br/>
 * @author shadow 
 * @Date 2016��9��17������7:03:23
 * @version 1.0
 * @since 
 **/
public class NQueen {
	
	public static void main(String[] args) {
		int n = 8;
		System.out.println("N Queen's Result : n = " + n + " Kinds = " + new NQueen().getKinds(n));
	}
	
	public int getKinds2(int n){
		return -1;
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public int getKinds(int n){
		if(n < 1){
			return 0;
		}
		
		int[] record = new int[n];
		return process(0, record, n);
	}
	
	private int process(int i, int[] record, int n){
		if(i == n){
			return 1;
		}
		
		int res = 0;
		for(int j = 0; j < n; j++){
			if(isValid(record, i, j)){
				record[i] = j;
				res += process(i + 1, record, n);
//				for(int k = 0; k < record.length; k++){
//					System.out.print(k + ",");
//				}
//				System.out.println();
			}
		}
		
		return res;
	}
	
 	private boolean isValid(int[] record, int i, int j){
		for(int k = 0; k < i; k++){
			if(j == record[k] || Math.abs(record[k] - i) == Math.abs(i - k)){
				return false;
			}
		}
		return true;
	}
}
