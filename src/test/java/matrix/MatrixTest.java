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
        m = new Matrix<Number>(4, 4);
    }

    @Test
    public void testInt() throws Exception {
        m.addAll(1, 2, 3, 4, 5, -1, 2, -12, 10, 11, -11, -21, 31, 4, 21, -11);
        System.out.println("Matrix m \n" + m.toString());

        Matrix m2 = m.getSub(1, 2, 1, 2);
        System.out.println("Matrix m2 : \n" + m2.toString());

        Matrix m3 = m.getSub(0, 1, 0, 1);
        System.out.println("Matrix m3 : \n" + m3.toString());
        Matrix m4 = m2.multiply(m3);
        System.out.println("Matrix m2 * m3 :\n " + m4.toString());
    }

    @Test
    public void testDouble() throws Exception {
        m.addAll(1.1, 1.3, 1.4, 1.5, 1.9, -1.1, -2.2, -1.3, -1.4, -1.5, 1.7, 1.8, 2.9, 1.2, 1.5, -0.4);
        System.out.println("Matrix m \n" + m.toString());

        Matrix m2 = m.getSub(1, 2, 1, 2);
        System.out.println("Matrix m2 : \n" + m2.toString());

        Matrix m3 = m.getSub(0, 1, 0, 1);
        System.out.println("Matrix m3 : \n" + m3.toString());
        Matrix m4 = m2.multiply(m3);
        System.out.println("Matrix m2 * m3 :\n " + m4.toString());
    }
}

