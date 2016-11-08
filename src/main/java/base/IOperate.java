/*************************************************************************

	> File Name: src/main/java/base/IOperate.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Tue 08 Nov 2016 03:59:14 PM CST
 ************************************************************************/
package base;
import java.math.BigDecimal; 

public interface IOperate<T extends Number> {

    default T operate(T elem1, T elem2) {
        if(elem1 == null) {
            return elem2;
        }else if(elem2 == null) {
            return elem1;
        }

        BigDecimal bigdec1 = new BigDecimal(elem1.toString());
        BigDecimal bigdec2 = new BigDecimal(elem2.toString());
        BigDecimal bigdec3 = bigdec1.multiply(bigdec2);
        //        System.out.println("BigDec3 : " + bigdec3);
        return (T)bigdec3; 
    }

    default T plus(T elem1, T elem2) {
        if(elem1 == null) {
            return elem2;
        }else if(elem2 == null) {
            return elem1;
        }

        BigDecimal bigdec1 = new BigDecimal(elem1.toString());
        BigDecimal bigdec2 = new BigDecimal(elem2.toString());
        BigDecimal bigdec3 = bigdec1.add(bigdec2);
        //        System.out.println("BigDec3 : " + bigdec3);
        return (T)bigdec3;
    }
}
