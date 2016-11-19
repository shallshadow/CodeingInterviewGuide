/*************************************************************************
	> File Name: src/test/java/arrays/SumKSubArrayTest.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Mon 14 Nov 2016 06:59:21 PM CST
 ************************************************************************/

package arrays.test;

import arrays.SumKSubArray;

import org.junit.Test;

public class SumKSubArrayTest {
    @Test
    public void test() {
        int[] datas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + ", ");
        }
        System.out.println();
        //int[] rec = new int[datas.length];
        //for (int i = 0; i < rec.length; i++) {
        //    rec[i] = -1;
        //}
        SumKSubArray.list(datas, 0, 10);
    }
}
