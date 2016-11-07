/*************************************************************************
  > File Name: src/main/java/base/Operate.java
  > Author: shall
  > Mail: zyydqpi@163.com
  > Created Time: Mon 07 Nov 2016 01:53:14 PM CST
 ************************************************************************/

package base;

import java.math.BigDecimal;

@FunctionalInterface
public interface IOperate<T extends Number> {
    public T operate(T elem1, T elem2);

    public default T plus(T elem1, T elem2) {
        T sum = null;
        if(elem1 == null) {
            return elem2;
        }else if(elem2 == null) {
            return elem1;
        }

        BigDecimal bigdec1 = new BigDecimal(elem1.toString());
        BigDecimal bigdec2 = new BigDecimal(elem2.toString());
        BigDecimal bigdec3 = bigdec1.add(bigdec2);
//        System.out.println("BigDec3 : " + bigdec3);
        sum = (T)bigdec3;

        return sum;
    }
}
