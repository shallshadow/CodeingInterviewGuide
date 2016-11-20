/*************************************************************************
	> File Name: src/main/java/arrays/FindMaxMin.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Sat 19 Nov 2016 03:40:45 PM CST
 ************************************************************************/

package arrays;

public class FindMaxMin {
    // Find the max and the min number in arrays with 3*n/2.
    public static void findMaxMin(int[] datas) {
        if (datas == null) {
            return;
        }

        int n = datas.length;
        int max, min, beginIndex;

        if (n % 2 == 0) {
            max = getBigger(datas[0], datas[1]);
            min = getSmaller(datas[0], datas[1]);

            beginIndex = 2;
        } else {
            max = min = datas[0];

            beginIndex = 1;
        }


        for (int i = beginIndex; i < datas.length; i += 2) {
            if (datas[i] < datas[i + 1]) {
                max = getBigger(max, datas[i + 1]);
                min = getSmaller(min, datas[i]);
            } else {
                max = getBigger(max, datas[i]);
                min = getSmaller(min, datas[i + 1]);
            }
        }

        System.out.println("Max : " + max + "     Min : " + min);
    }

    public static int getBigger(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    public static int getSmaller(int num1, int num2) {
        return num1 > num2 ? num2 : num1;
    }
}
