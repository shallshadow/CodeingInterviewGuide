
package sort;
/**
 * @fun 简单的选择排序
 * 		基本思想：在要排序的一组数中，选出最小的一个数和第一个位置的数交换，然后再剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月28日下午8:54:22
 * @version 1.0
 * @since 
 * 
 * @analysis 简单选择排序是不稳定的排序。时间复杂度：T(n)=O(n2)。
 **/
public class SingleSelectSort implements ISelectSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if(datas == null || datas.length == 0){
			return;
		}
		
		for(int i = 0; i < datas.length; i++){
			int min = datas[i];
			int minIndex = i;
			for(int j = i + 1; j < datas.length; j++){
				if(min > datas[j]){
					min = datas[j];
					minIndex = j;
				}
			}
			
			datas[minIndex] = datas[i];
			datas[i] = min;				
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Single Selection Sort : ";
	}

}
