/*************************************************************************
  > File Name: src/test/java/matrix/MatrixTest.java
  > Author: shall
  > Mail: zyydqpi@163.com
  > Created Time: Mon 07 Nov 2016 07:52:45 AM CST
 ************************************************************************/

package matrix.test;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import matrix.*;

@RunWith(Parameterized.class)
public class MatrixTest {
    private Matrix<Number> mInt;
    private Matrix<Number> mDouble;
    private Matrix<Number> expected;

    private static Object[][][] datas = { 
        {
            {1, 2},
            {1, 3}
        },
        {
            {-1, -2},
            {2, 3}
        },
        {
            {3, 4},
            {5, 7}
        }
    };

    public MatrixTest(Matrix mInt, Matrix mDouble, Matrix expected) {
        this.mInt = mInt;
        this.mDouble = mDouble;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]> getMatrixDatas() {
        Matrix<Number>[] ms = new Matrix[datas.length];    
        for(int i = 0; i< ms.length; i++) {
            ms[i] = new Matrix<>(datas[0].length, datas[0][0].length);
        }

        for (int i = 0; i < ms.length; i++) {
            for (int row = 0; row < datas[0].length; row++) {
                for (int col = 0; col < datas[0][0].length; col++) {
                    ms[i].add(row, col, (Number)datas[i][row][col]);
                }
            }
        }

        List<Object[]> list = new ArrayList<>();
        list.add(ms);
        return list;
        
    }

    @Test
    public void testshow() throws Exception {
        System.out.println("MatrixInt : " + mInt.toString());
        System.out.println("MatrixDouble: " + mDouble.toString());
        Matrix result = mInt.multiply(mDouble);
        System.out.println("Matrix Result : " + result.toString());
        System.out.println("Matrix Result2 : " + expected.toString());
        assertTrue(result.equals(expected));
    }
    /*
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
    */
}

