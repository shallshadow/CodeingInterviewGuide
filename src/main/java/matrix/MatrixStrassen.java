package matrix;

/**
 * @fun Matrix product by Stassen
 * @author shall E-mail:zyydqpi@163.com 
 * @date  
 **/
public class MatrixStrassen {
    public <T extends Number>  Matrix<T> multiply(Matrix<T> ma, Matrix<T> mb) throws Exception {
        if (ma.getRowCount() != mb.getRowCount() || ma.getColumnCount() != mb.getColumnCount()) {
            throw new Exception("Illegal Matrix Multiply");
        }

        int rows = ma.getRowCount();
        int cols = ma.getColumnCount();

        if (rows == 1 && cols == 1) {
            return ma.multiply(mb);
        }
       
        int rmid = rows / 2;
        int cmid = cols / 2; 
        Matrix<T> ma11 = ma.getSub(0, rmid, 0, cmid);
        Matrix<T> ma12 = ma.getSub(0, rmid, cmid, cmid);
        Matrix<T> ma21 = ma.getSub(rmid, rmid, 0, rmid);
        Matrix<T> ma22 = ma.getSub(rmid, rmid, cmid, rmid);

//        System.out.println("ma11 : " + ma11);
//        System.out.println("ma12 : " + ma12);
//        System.out.println("ma21 : " + ma21);
//        System.out.println("ma22 : " + ma22);
        

        Matrix<T> mb11 = mb.getSub(0, rmid, 0, cmid);
        Matrix<T> mb12 = mb.getSub(0, rmid, cmid, cmid);
        Matrix<T> mb21 = mb.getSub(rmid, rmid,  0, cmid);
        Matrix<T> mb22 = mb.getSub(rmid, rmid, cmid, cmid);
/*
        System.out.println("mb11 : " + mb11);
        System.out.println("mb12 : " + mb12);
        System.out.println("mb21 : " + mb21);
        System.out.println("mb22 : " + mb22);
*/
        //Matrix<T> mc11 = ma11.multiply(mb11).plus(ma12.multiply(mb21));
        //Matrix<T> mc12 = ma11.multiply(mb12).plus(ma12.multiply(mb22));
        //Matrix<T> mc21 = ma21.multiply(mb11).plus(ma22.multiply(mb21));
        //Matrix<T> mc22 = ma21.multiply(mb12).plus(ma22.multiply(mb22));
        Matrix<T> mc11 = multiply(ma11, mb11).plus(multiply(ma12, mb21));
        Matrix<T> mc12 = multiply(ma11, mb12).plus(multiply(ma12, mb22));
        Matrix<T> mc21 = multiply(ma21, mb11).plus(multiply(ma22, mb21));
        Matrix<T> mc22 = multiply(ma21, mb12).plus(multiply(ma22, mb22));
/*      System.out.println("mc11 : " + mc11);
        System.out.println("mc12 : " + mc12);
        System.out.println("mc21 : " + mc21);
        System.out.println("mc22 : " + mc22);
*/
        int crow = 0;
        int ccol = 0;

        
        Matrix<T> mc = new Matrix<>(rows, cols);
//        System.out.println("CCOL : " + (ccol + mc11.getColumnCount() / 2));
        merge(mc, mc11, crow, ccol);
        merge(mc, mc12, crow, ccol + cmid);
        merge(mc, mc21, crow + rmid, ccol);
        merge(mc, mc22, crow + rmid, ccol + cmid);

        return mc;
    }

    private <T extends Number> void merge(Matrix<T> mc, Matrix<T> m, int curRow, int curCol) {
        for (int row = 0; row < m.getRowCount(); row++) {
            for (int col = 0; col < m.getColumnCount(); col++) {
                mc.add(curRow + row, curCol + col, m.get(row, col));
            }
        }

    }
    
}
