
package arrays;

import java.util.ArrayList;
/**
 *
 * @author shadow
 * @Date 2016年9月25日下午8:21:18
 * @version 1.0
 * @since
 **/
public class MaxSumSub {

	public static int fenzhi(ArrayList<Integer> list, int left, int right) {
		if (left == right) {
			return list.get(left) > 0 ? list.get(left) : 0;
		}

		int mid = (left + right) / 2;
		int themaxleft = fenzhi(list, left, mid);
		int themaxright = fenzhi(list, mid + 1, right);		
		
        int midMax = getMidMax(list, mid, left, right);
		return Math.max(midMax, Math.max(themaxleft, themaxright));
	}

    static int getMidMax(ArrayList<Integer> list, int mid, int left, int right) {
		int maxleft = 0;
		int sumleft = 0;
		for (int i = mid; i >= left; i--) {
			sumleft = sumleft + list.get(i);
			if (sumleft > maxleft) {
				maxleft = sumleft;
			}
		}
		int maxright = 0;
		int sumright = 0;
		for (int i = mid + 1; i <= right; i++) {
			sumright = sumright + list.get(i);
			if (sumright > maxright) {
				maxright = sumright;
			}
		}
		
		return maxleft + maxright;
    }

	static int max(int a, int b, int c) {
        a = a > b ? a : b;
        return a > c ? a : c;
	}
}
