/*************************************************************************
	> File Name: src/main/java/matrix/Matrix
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Mon 07 Nov 2016 07:12:29 AM CST
 ************************************************************************/

package matrix;

/**
 * The basic of Matrix and some util operation
 * */
public class Matrix<T> {
    private T[][] datas;
    private String message;
    public final int DEFAULT = 10;

    public Matrix() {
        this.datas = (T[][]) new Object[DEFAULT][DEFAULT];
        this.message = " Default Matrix";
    }

    public Matrix(int m, int n) {
        this.datas = (T[][]) new Object[m][n];
        this.message = " " + m + "*" + n + " Matrix";
    }

    public Matrix(int n) {
        this(n, n);
    }

    public Matrix(T[][] datas) {
        this.datas = datas;
        this.message = " " + this.datas.length + " * " + this.datas[0].length + " Matrix";
    }

    public Matrix multiply(Matrix m) throws Exception {
        if (this.getRowCount() != m.getColumnCount()) { 
            throw new Exception("The illegal Matrix multiply");
        }

        Matrix product = new Matrix(this.getRowCount(), m.getColumnCount());
        for(int row = 0; row < this.getRowCount(); row++) {
            for (int col = 0; col < m.getColumnCount(); col++) {
                 int sum = 0;
                 for(int r = 0; r < m.getColumnCount(); r++) {
                    Number a = (Integer)this.get(row, r);
                    Number b = (Integer)m.get(r, col);
                    sum += a.intValue() * b.intValue();
                 }

                 product.add(row, col, sum);

            }
        }

        return product;
    }


    public Matrix getSub(int srow,int erow, int scol, int ecol) {
        Matrix m = new Matrix(erow - srow + 1, ecol - scol + 1);
        int r = 0;

        for (int row = srow; row < erow + 1; row++) {
            int c = 0;
            for (int col = scol; col < erow + 1; col++) {
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

        return this.datas[row][col];
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.message + "\n");

        for (int row = 0; row < this.datas.length; row++) {
            sb.append("[ ");
            for (int col = 0; col < this.datas[0].length; col++) {

                sb.append(this.datas[row][col].toString());
                sb.append(",");
            }
            sb.append(" ] \n");
        }

        return sb.toString();
    }
}

