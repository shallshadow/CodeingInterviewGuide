
package arrays;

/**
 *
 * @author shadow
 * @Date 2016年9月25日下午8:21:18
 * @version 1.0
 * @since
 **/
public class MaxSumSub {

	public static void main(String[] args) {
		int[] A = new int[] {0,1,4,5,-10,-5,7,8,9};
		System.out.println(fenzhi(A, 0, A.length - 1));
	}

	static int fenzhi(int A[], int left, int right) {
		if (left == right) {
			return A[left] > 0 ? A[left] : 0;
		}

		int mid = (left + right) / 2;
		int themaxleft = fenzhi(A, left, mid);
		int themaxright = fenzhi(A, mid + 1, right);		
		
		int maxleft = 0;
		int sumleft = 0;
		for (int i = mid; i >= left; i--) {
			sumleft = sumleft + A[i];
			if (sumleft > maxleft) {
				maxleft = sumleft;
			}
		}
		int maxright = 0;
		int sumright = 0;
		for (int i = mid + 1; i <= right; i++) {
			sumright = sumright + A[i];
			if (sumright > maxright) {
				maxright = sumright;
			}
		}
		
		int sum = maxleft + maxright;
		System.out.println("sum : " + sum);
		System.out.println("maxright : " + maxright);
		System.out.println("maxleft : " + maxleft);
		return Math.max(sum, Math.max(themaxleft, themaxright));
	}

	static int max(int a, int b, int c) {
		if (a < b) {
			a = b;
		} 
		if (a < c) {
			a = c;
		}
		return a;
	}
}
