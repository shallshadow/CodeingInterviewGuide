
package sort;

/**
 *
 * @fun 二分法插入排序(按二分法找到合适位置插入)<br/> 
 *      基本思想：二分法插入排序的思想和直接插入一样，只是找到合适的插入位置的方式不同，这里是按二分法找到合适的位置，可以减少比较次数。<br/>
 *		稳定的排序算法。
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月28日下午8:03:28
 * @version 1.0
 * @since
 * 	分析：
 * 	二分插入排序的比较次数与待排序记录的初始状态无关，仅依赖于记录的个数。
 * 	当n较大时，比直接插入排序的最大比较次数少得多。
 * 	但大于直接插入排序的最小比较次数。
 * 	算法的移动次数与直接插入排序算法的相同，最坏的情况为n2/2，最好的情况为n，平均移动次数为O(n2)。
 **/
public class BinaryInsertSort implements IInsertSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if(datas == null || datas.length == 0){
			return;
		}
		
		for(int i = 1; i < datas.length; i++){
			int temp = datas[i];
			int left =binarySearch(datas, i);
			for(int j = i - 1; j >= left; j--){
				datas[j + 1] = datas[j];
			}
			
			if(left != i){
				datas[left] = temp;
			}
		}
	}

	//二分法遍历查找
	private int binarySearch(int[] datas, int i) {
		int temp = datas[i];
		int left = 0;
		int right = i - 1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (temp < datas[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Binary Insertion : ";
	}

}
