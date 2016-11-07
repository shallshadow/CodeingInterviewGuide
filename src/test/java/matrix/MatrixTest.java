/*************************************************************************
  > File Name: src/test/java/matrix/MatrixTest.java
  > Author: shall
  > Mail: zyydqpi@163.com
  > Created Time: Mon 07 Nov 2016 07:52:45 AM CST
 ************************************************************************/

package matrix.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import matrix.*;

public class MatrixTest {
    private Matrix m;

    @Before
    public void init() {
        m = new Matrix<Integer>(4, 4);
    }
    @Test
    public void test() {
        m.addAll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        System.out.println(m.toString());

        Matrix m2 = m.getSub(1, 2, 1, 2);
        System.out.println(m2.toString());

        Matrix m3 = m.getSub(0, 1, 0, 1);
        System.out.println(m3.toString());

        try {
            Matrix m4 = m3.multiply(m2);
            System.out.println(m4.toString());
        }catch(Exception exp) {
            System.out.println(exp.getMessage());
        }
    }
}

