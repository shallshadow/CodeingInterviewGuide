
package dp;

import java.io.BufferedWriter;
import java.util.Queue;

/**
 * @fun 问题描述：在N*N的棋牌上要摆N个皇后，要求任何两个皇后不同行，不同列，也不在同一个斜线上。<br/>
 * 		给定一个整数n，返回n皇后的摆法有多少种。<br/>
 * @author shadow 
 * @Date 2016年9月17日下午7:03:23
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
