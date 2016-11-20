/*************************************************************************
	> File Name: src/main/java/arrays/FindKMinNum.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Sat 19 Nov 2016 07:44:38 PM CST
 ************************************************************************/

package arrays;

import base.Util;
import java.util.Random;


public class FindKMinNum {
    
    public static int findKMinNum(int[] datas, int p, int r, int k) {
        if (p == r) {
            return datas[p];
        }

        int q = randomized_partition(datas, p, r);
        int t = q - p + 1;
        if (t == k) {
            return datas[q];
        } else if (k < t) {
            return findKMinNum(datas, p, q - 1, k);
        } else {
            return findKMinNum(datas, q + 1 , r, k - t);
        }
    }

    public static int partition(int[] datas, int p, int r) {
        int temp = datas[r];
        int i = p - 1;
        for (int j = p; j < r - 1; j++) {
            if (datas[j] < temp || datas[j] == temp) {
                i = i + 1;
                Util.swap(datas, i, j);
            }
        }

        Util.swap(datas, i + 1, r);

        return i + 1;
    }

    public static int randomized_partition(int[] datas, int p, int r) {
        int i = new Random().nextInt(r - p) + p;
        Util.swap(datas, r, i);
        return partition(datas, p, r);
    }
}
