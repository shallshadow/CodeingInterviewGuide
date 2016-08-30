
package sort;
/**
 * @fun 冒泡排序	稳定的排序算法
 * 		基本思想：在要排序的一组数种，对当前还未排好序的范围内额全部数，自上而下对相邻的两个数依次进行比较和调整，<br/>
 *		让较大的数往下沉，较小的数往上冒。即：每当两相邻的数比较厚发现它们的排序和排序要求相反时，交换它们。<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月29日下午3:03:29
 * @version 1.0
 * @since 
 * 
 * 
 * 分析：<br/>
 * 	若文件初状为正序，则一趟起泡就可完成排序，排序码的比较次数为n-1，且没有记录移动，时间复杂度是O(n)
 *	若文件初态为逆序，则需要n-1趟起泡，每趟进行n-i次排序码的比较，且每次比较都移动三次，比较和移动次数均达到最大值∶O(n2)
 *	起泡排序平均时间复杂度为O(n2)
 **/
public class BubbleSort implements IExchangeSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if(datas ==  null || datas.length == 0){
			return;
		}
		
		for(int i = 0; i < datas.length; i++){
			//-i主要是每遍历一次都把最大的i个数沉到最低下去了，没有必要再替换了。
			for(int j = 0; j < datas.length - i - 1; j++){
				if(datas[j] > datas[j + 1]){
					swap(datas, j, j + 1);
				}
			}
		}
	}
	
	private void swap(int[] datas, int i, int j){
		int temp = datas[j];
		datas[j] = datas[i];
		datas[i] = temp;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Bubble Sort : ";
	}

}
