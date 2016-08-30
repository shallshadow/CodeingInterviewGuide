
package sort;

/**
 * @fun 鸡尾酒排序(双向冒泡排序算法) 基本思想：先找到最小的数字，把他放到第一位，然后找到最大的数字放到最后一位。然后再找到第二小的数字放到第二位，
 *      <br/>
 *      再找到第二大的数字放到倒数第二位。依次类推，直到完成排序。<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月29日下午8:02:52
 * @version 1.0
 * @since
 * 
 * 		分析：<br/>
 *        鸡尾酒排序最糟或是平均所花费的次数都是O(n^2)，但如果序列在一开始已经大部分排序过的话，会接近O(n)。<br/>
 **/
public class CocktailSort implements IExchangeSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if (datas == null || datas.length == 0) {
			return;
		}

		for (int i = 0; i < datas.length; i++) {
			// 将最大的数排到队尾
			for (int j = 0; j < datas.length - i - 1; j++) {
				if (datas[j] > datas[j + 1]) {
					swap(datas, j, j + 1);
				}
			}
			// 将最小的数排到队头
			for (int j = datas.length - 1 - (i + 1); j > i; j--) {
				if (datas[j] < datas[j - 1]) {
					swap(datas, j, j - 1);
				}
			}
		}
	}

	private void swap(int[] datas, int i, int j) {
		int temp = datas[j];
		datas[j] = datas[i];
		datas[i] = temp;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Cocktail Sort : ";
	}

}
