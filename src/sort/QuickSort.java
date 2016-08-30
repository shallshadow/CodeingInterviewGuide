
package sort;
/**
 * @fun 快速排序 <br/>
 * 		基本思想：选择一个基准元素，通常选择第一个元素或者最后一个元素，通过一趟扫描，将待排序列分成两部分，一部分比基准元素小，一部分大于等于基准元素。<br/>\
 * 		此时基准元素在其排好序后的正确位置，然后再用同样的方法递归地排序划分的两部分。<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月29日下午3:27:24
 * @version 1.0
 * @since 
 * 
 * 分析：<br/>
 * 	快速排序是不稳定的排序。<br/>
 * 	快速排序的时间复杂度为O(nlogn)。<br/>
 * 	当n较大时使用快排比较好，当序列基本有序时用快排反而不好。<br/>
 **/
public class QuickSort implements IExchangeSort,IDistributionSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if(datas == null || datas.length == 0){
			return;
		} 
		
		quickSort(datas, 0, datas.length - 1);
	}

	private void quickSort(int[] datas, int low, int high){
		if(low < high){
			int middle = getMiddle(datas, low, high);
			//先排左半部分
			quickSort(datas, 0, middle - 1);
			//后排右半部分
			quickSort(datas, middle + 1, high);
		}
	}
	
	private int getMiddle(int[] datas, int low, int high){
		//基准元素
		int temp = datas[low];
		
		while(low < high){			
			//找到比基准元素小的位置
			while(low < high && datas[high] >= temp){
				high--;
			}			
			datas[low] = datas[high];
			
			while(low < high && datas[low] <= temp){
				low++;
			}
			datas[high] = datas[low];
		}
		datas[low] = temp;
		return low;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Quick Sort : ";
	}
	
}
