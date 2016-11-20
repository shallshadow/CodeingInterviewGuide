/*************************************************************************
	> File Name: src/test/java/arrays/FindMaxMinTest.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Sat 19 Nov 2016 03:56:25 PM CST
 ************************************************************************/

package arrays.test;

import org.junit.Test;
import base.test.Final;
import arrays.FindMaxMin;

public class FindMaxMinTest {
    @Test
    public void testFindMaxMin() {
    
        for (int i = 0; i < Final.DATAS.length; i++) {
           FindMaxMin.findMaxMin(Final.DATAS[i]);
        }
    }
}
