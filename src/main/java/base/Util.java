/*************************************************************************
	> File Name: src/main/java/base/Util.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Sat 19 Nov 2016 07:49:08 PM CST
 ************************************************************************/

package base;

public class Util {
    public static void swap(int[] datas, int num1, int num2) {
        int temp = datas[num1];
        datas[num1] = datas[num2];
        datas[num2] = temp;
    }
}
