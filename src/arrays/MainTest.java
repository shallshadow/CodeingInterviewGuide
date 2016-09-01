
package arrays;

import base.IProblem;

/**
 * @fun 关于数组的算法测试
 * @author shadow 
 * @Date 2016年8月31日下午7:43:15
 * @version 1.0
 * @since 
 **/
public class MainTest {
	public static void main(String[] args) {
		int[] datas = {5,3,4,1,2,6,7};
		String string = "absbw";
		IProblem[] problems = {new MinLengthNeedSort(datas), new Palindrome(null, string), new MaxAscSubsequence(datas)};
		for(int i = 0; i < problems.length; i++){
			problems[i].solve();
			problems[i].showResult();
		}
	}
	public static void showArrays(int[] arr){
		System.out.println("Arrays : ");
		for(int i = 0; i < arr.length; i++){
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}
}
