
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
		int[] datas = {1,3,4,6};
		int[] datas2 = {2,5,7,9, 10};
		testTwoSortArrayFindMedian(datas, datas2);
		//testMaxLength(datas, datas2);
	}
	
	
	public static void testTwoSortArrayFindMedian(int[] datas, int[] datas2){
		IProblem problem = new TwoSortArrayFindMedian(datas, datas2);
		problem.solve();
		problem.showResult();
	}
	
	public static void testMaxLength(int[] datas, int[] datas2){
		int k = 6;
		IProblem[] problems = {new PosIntSubMaxLength(datas, k), new IntSubMaxLength(datas2, k)};
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
	
	public static void testAll(){
		int[] datas = {5,3,4,1,2,6,7};
		String string = "absbw";
		String str1 = "1AB2345CD";
		String str2 = "123456EF";
		IProblem[] problems = {new MinLengthNeedSort(datas), new Palindrome(null, string), new MaxAscSubsequence(datas),
				new MaxComSubsequence(null, str1, str2)};
		for(int i = 0; i < problems.length; i++){
			problems[i].solve();
			problems[i].showResult();
		}
	}
}
