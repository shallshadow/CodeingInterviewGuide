/*************************************************************************
	> File Name: src/test/java/matrix/MatrixStrassenTest
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Wed 09 Nov 2016 08:43:00 AM CST
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
public class MatrixStrassenTest {
    private Matrix<Number> mInt;
    private Matrix<Number> mDouble;
    private Matrix<Number> expected;
    private MatrixStrassen strassen;

    private static Object[][][] datas = { 
        {
            {1, 2, 4, 1},
            {1, 3, 5, 2},
            {1, 2, 3, 3},
            {1, 1, 1, 1}
        },
        {
            {-1, -2, 5, 1},
            {2, 3, 6, 2},
            {1, 2, 3, 1},
            {1, 1, 1, 3}
        },
        {
            {3, 4, 1, 1},
            {5, 7, 2, 1},
            {1, 2, 3, 2},
            {1, 1, 1, 3}
        }
    };

    public MatrixStrassenTest(Matrix mInt, Matrix mDouble, Matrix expected) {
        this.mInt = mInt;
        this.mDouble = mDouble;
        this.expected = expected;
        this.strassen = new MatrixStrassen();
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

    /**
     * That's wrong,every elem in the list stands for a test example.
    @Parameterized.Parameters
    public static List<Object> getMatrixDatas() {
        Matrix<Number> m = null;
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < datas.length; i++) {
            for (int row = 0; row < datas[0].length; row++) {
                for (int col = 0; col < datas[0][0].length; col++) {
                    m = new Matrix();
                    m.add(row, col, (Number)datas[i][row][col]);
                    list.add(m);
                }
            }
        }

        return list;
    }
    **/

    @Test
    public void testshow() throws Exception {
        System.out.println("MatrixInt : " + mInt.toString());
        System.out.println("MatrixDouble: " + mDouble.toString());
        Matrix result2 = mInt.multiply(mDouble);
        Matrix result = this.strassen.multiply(mInt, mDouble);
        System.out.println("Matrix Result : " + result.toString());
        System.out.println("Matrix Result2 : " + result2.toString());
        assertTrue(result.equals(result2));
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
