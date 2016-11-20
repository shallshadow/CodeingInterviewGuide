/*************************************************************************
	> File Name: src/test/java/arrays/FindKMinNumTest.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Sun 20 Nov 2016 09:46:02 AM CST
 ************************************************************************/

package arrays.test;

import org.junit.Test;

import arrays.FindKMinNum;
import base.test.Final;

/**
 * Find the kth min number
 * */
public class FindKMinNumTest {
    @Test
    public void testFind() {
        for (int i = 0; i < Final.DATAS.length; i++) {
            for(int r = 0; r < Final.DATAS[i].length; r++) {
                System.out.print(Final.DATAS[i][r] + ",");
            }
            System.out.println();

            int k = FindKMinNum.findKMinNum(Final.DATAS[i], 0, Final.DATAS[i].length - 1, i + 1);
            System.out.println((i + 1) + "th : " + k);
        }
    }
}
