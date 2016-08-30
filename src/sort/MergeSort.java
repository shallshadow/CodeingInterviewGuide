
package sort;

/**
 * @fun 归并排序<br/>
 *      基本思想：归并(Merge)排序法是将两个(两个以上)有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列式有序的。<br/>
 *      然后再把有序子序列合并为整体有序序列。<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月29日下午4:16:26
 * @version 1.0
 * @since
 * 
 * 分析：<br/>
 *　	归并排序是稳定的排序方法。<br/>
 *	归并排序的时间复杂度为O(nlogn)。<br/>
 *	速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。<br/>
 **/
public class MergeSort implements IMergerSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if (datas == null || datas.length == 0) {
			return;
		}
		
		mergeSort(datas, 0, datas.length - 1);
	}
	//归并排序开始
	private void mergeSort(int[] datas, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			//对左边进行递归
			mergeSort(datas, left, middle);
			//对右边进行递归
			mergeSort(datas, middle + 1, right);
			//合并
			merge(datas, left, middle, right);
		}
	}

	//合并两个数组
	private void merge(int[] datas, int left, int middle, int right) {
		int[] tmpArr = new int[datas.length];
		// 右边的起始位置
		int mid = middle + 1;
		int tmp = left;
		int third = left;
		while (left <= middle && mid <= right) {
			// 从两个数组中选取较小的数放入中间数组
			if (datas[left] <= datas[mid]) {
				tmpArr[third++] = datas[left++];
			} else {
				tmpArr[third++] = datas[mid++];
			}
		}
		
		//将剩余的部分放入中间数组
		while(left <= middle){
			tmpArr[third++] = datas[left++];
		}
		
		while(mid <= right){
			tmpArr[third++] = datas[mid++];
		}
		
		//将中间数组复制回原数组
		while(tmp <= right){
			datas[tmp] = tmpArr[tmp++];
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Merge Sort : ";
	}

}
