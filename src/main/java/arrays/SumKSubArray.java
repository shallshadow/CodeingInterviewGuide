/*************************************************************************
  > File Name: src/main/java/arrays/SumKSubArray.java
  > Author: shall
  > Mail: zyydqpi@163.com
  > Created Time: Mon 14 Nov 2016 06:44:08 PM CST
 ************************************************************************/

package arrays;

/**
 * the array is sorted by asc.
 * list all the sub arrays that summary is K.
 * */
public class SumKSubArray {
    public static void list(int[] datas, int next, int k) {
        for (int i = next; i < datas.length ; i++) {
            if (k - datas[i] > 0 ) {
                list(datas, i + 1, k - datas[i]);
            } else if (k - datas[i] == 0) {
                System.out.print(i + ",");
            } 
        }
    }
}
