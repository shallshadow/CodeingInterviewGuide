
package arrays;

import base.IProblem;

/**
 * @fun ����������㷨����
 * @author shadow 
 * @Date 2016��8��31������7:43:15
 * @version 1.0
 * @since 
 **/
public class MainTest {
	public static void main(String[] args) {
		int[] datas = {5,3,4,1,2,6,7};
		IProblem[] problems = {new MinLengthNeedSort(datas)};
		for(int i = 0; i < problems.length; i++){
			problems[i].solve();
			problems[i].showResult();
		}
	}
}
