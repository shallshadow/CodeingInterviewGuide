/*************************************************************************
	> File Name: src/main/java/base/Operate.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Mon 07 Nov 2016 01:53:14 PM CST
 ************************************************************************/

@FunctionalInterface
public interface Operate<T> {
    T operate(T elem1, T elem2);
    
}
