
package sort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @fun 基数排序 基本思想：将所有待比较数值(正整数)统一为同样的位数长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。<br/>
 *      这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月29日下午7:29:37
 * @version 1.0
 * @since
 * 
 * 分析：<br/>
 * 基数排序是稳定的排序算法。
 * 基数排序的时间复杂度为O(d(n+r)),d为位数，r为基数
 **/
public class RadixSort implements IDistributionSort {
	private final int QUEUEMAX = 10;
	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if(datas == null || datas.length == 0){
			return;
		}
		//找到最大值
		int max = getMax(datas);
		//判断位数
		int times= getTimes(max);
		
		//建立QUEUEMAX个队列
		List<Deque<Integer>> list = new ArrayList<>();
		for(int i = 0; i < QUEUEMAX; i++){
			Deque<Integer> deque = new LinkedList<>();
			list.add(deque);
		}
		//进行times次分配和收集
		for(int i = 0; i < times; i++){
			for(int j = 0; j < datas.length; j++){
				int x = datas[j] % (int)Math.pow(10, i+1) / (int)Math.pow(10, i);
				Deque<Integer> deque = list.get(x);
				deque.offer(datas[j]);
				list.set(x, deque);
			}
			//收集
			int count = 0;
			for(int j = 0; j < QUEUEMAX; j++){
				//分配
				while(list.get(j).size() > 0){
					Deque<Integer> deque = list.get(j);
					datas[count] = deque.poll();
					count++;
				}
			}
		}
		
	}

	private int getMax(int[] datas) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < datas.length; i++) {
			if (max < datas[i]) {
				max = datas[i];
			}
		}

		return max;
	}

	private int getTimes(int max) {
		int sum = 0;
		while (max > 0) {
			max = max / 10;
			sum++;
		}
		return sum;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Radix Sort : ";
	}

}
