
package sort;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月28日下午7:35:06
 * @version 1.0
 * @since  1.0
 * @fun  直接插入排序(从后向前找到合适位置后插入)<br/>
 * 		   基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置(从后向前找到合适位置后)，直到全部插入排序完为止。<br/>
 *  	   文件初态不同时，直接插入排序所耗费的时间有很大差异。<br/>
 *  	        若文件初态为正序，则每个待插入的记录只需要比较一次就能够找到合适的位置插入，故算法的时间复杂度为O(n)，这时最好的情况。<br/>
 *         若初态为反序，则第i个待插入记录需要比较i+1次才能找到合适位置插入，故时间复杂度为O(n2)，这时最坏的情况。<br/>
　　		  直接插入排序的平均时间复杂度为O(n2)。<br/>
 **/
public class SingleInsertSort implements IInsertSort {

	public static void main(String[] args) {

	}

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		for (int i = 1; i < datas.length; i++) {
			int temp = datas[i];
			int j;
			//从后向前找，凡是比temp大的往后移
			for (j = i - 1; j >= 0; j--) {
				if (datas[j] > temp) {
					datas[j + 1] = datas[j];
				} else {
					break;
				}
			}
			datas[j + 1] = temp;
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Insert Sort : ";
	}
}
