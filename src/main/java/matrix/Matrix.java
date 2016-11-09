/*************************************************************************
	> File Name: src/main/java/matrix/Matrix
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Mon 07 Nov 2016 07:12:29 AM CST
 ************************************************************************/

package matrix;

import base.IOperate;
import java.math.BigDecimal;

/**
 * The basic of Matrix and some util operation
 * */
public class Matrix<T extends Number> {
    private Object[][] datas;
    private String message;
    public final int DEFAULT = 10;

    /*
    public Matrix() {
        this.datas = new Object[DEFAULT][DEFAULT];
        this.message = " Default Matrix";
    }
    */

    public Matrix(int m, int n) {
        this.datas = new Object[m][n];
        this.message = " " + m + "*" + n + " Matrix";
    }

    public Matrix(int n) {
        this(n, n);
    }

    public Matrix(T[][] datas) {
        this.datas = (Object[][]) datas;
        this.message = " " + this.datas.length + " * " + this.datas[0].length + " Matrix";
    }

    public Matrix<T> multiply(Matrix<T> m, IOperate<T> ope) throws Exception {
        if (this.getRowCount() != m.getColumnCount()) { 
            throw new Exception("The illegal Matrix multiply");
        }

        Matrix product = new Matrix(this.getRowCount(), m.getColumnCount());
        for(int row = 0; row < this.getRowCount(); row++) {
            for (int col = 0; col < m.getColumnCount(); col++) {
                 T sum = null;
                 for(int r = 0; r < m.getColumnCount(); r++) {
                    T a = this.get(row, r);
                    T b = m.get(r, col);
                    sum = ope.plus(ope.operate(a, b), sum); 
                    //System.out.println("Sum : " + sum);
                 }
                 product.add(row, col, sum);
            }
        }

        //System.out.println(this.getRowCount() + " : " + m.getColumnCount());

        return product;
    }

    public Matrix<T> plus(Matrix<T> m) throws Exception {
        return operate(m, new IOperate<T>(){});
    }

    public Matrix<T> reduce(Matrix<T> m) throws Exception {
        return operate(m, new IOperate<T>() {
            public T plus(T elem1, T elem2) {

                T sum = null;
                if(elem1 == null) {
                    return elem2;
                }else if(elem2 == null) {
                    return elem1;
                }

                BigDecimal bigdec1 = new BigDecimal(elem1.toString());
                BigDecimal bigdec2 = new BigDecimal(elem2.toString());
                BigDecimal bigdec3 = bigdec1.subtract(bigdec2);
                sum = (T)bigdec3;

                return sum;
            }
        });
    }

    private Matrix<T> operate(Matrix<T> m, IOperate<T> ope) throws Exception {
        if(this.getRowCount() != m.getRowCount() || this.getColumnCount() !=  m.getColumnCount()) {
            throw new Exception("The illegal Matrix multiply");
        }

        Matrix<T> res = new Matrix<>(this.getRowCount(), this.getColumnCount());
        for (int row = 0; row < this.getRowCount(); row++) {
            for (int col = 0; col < this.getColumnCount(); col++) {
                res.add(row, col, ope.plus(this.get(row, col), m.get(row, col)));
            }

        }

        return res;
    }

    /**
     * Matrix Common Multiply Algorithm
     * */
    public Matrix<T> multiply(Matrix<T> m) throws Exception {
        return multiply(m,new IOperate<T>() {});
    }

    @Override
    public boolean equals(Object object) {
        Matrix m = (Matrix) object;
        if(this.getRowCount() != m.getRowCount() || this.getColumnCount() != m.getColumnCount()) {
            return false;
        }

        for (int row = 0; row < this.getRowCount(); row++) {
            for (int col = 0; col < this.getColumnCount(); col++) {
                if (!this.get(row, col).toString().equals(m.get(row, col).toString())){
                    System.out.print("row : " + row + " , col : " + col);
                    return false;
                }
            }
        }

        return true;

    }

    public Matrix getSub(int srow,int rlen, int scol, int clen) {
        Matrix m = new Matrix(rlen, clen);
        int r = 0;

        for (int row = srow; row < srow + rlen; row++) {
            int c = 0;
            for (int col = scol; col < scol + clen; col++) {
                m.add(r, c++, this.get(row, col));
            }
            r++;
        }

        return m;
    }

    public int getRowCount() {
        return this.datas.length;
    }

    public int getColumnCount() {
        return this.datas[0].length;
    }

    public void addAll(T ...elems) {
        int col = 0;
        int row = 0;
        for (T elem : elems) {
           if (col == this.datas[0].length) { 
               col = 0;
               row++;
           }

           this.datas[row][col++] = elem;
        }
    }

    public void add(int row, int col, T elem) {
        this.datas[row][col] = elem;
    }

    public T get(int row, int col) {
        if (row > datas.length || col > datas[0].length) {
            return null;
        }

        return (T)this.datas[row][col];
    }

    public T[][] toArray() {
        return (T[][]) this.datas;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.message + "\n");

        for (int row = 0; row < this.getRowCount(); row++) {
            sb.append("[ ");
            for (int col = 0; col < this.getColumnCount(); col++) {
                sb.append(this.datas[row][col] == null ? "null" : this.datas[row][col].toString());
                sb.append(",");
            }
            sb.append(" ] \n");
        }

        return sb.toString();
    }
}

