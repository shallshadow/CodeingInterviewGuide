
package sort;

/**
 * @fun 希尔排序 (Shell Sort) 不稳定的排序算法<br/>
 *      基本思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。
 *      先在各组内进行直接插入排序；<br/>
 *      然后取第二个增量d2<d1重复上述的分组和排序，直至所取得增量dt=1(d1>d2>...>dt)，即所有记录放在同一组中进行直接插入排序为止。
 *      <br/>
 *      实际是分组插入法。<br/>
 * 
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月28日下午8:25:38
 * @version 1.0
 * @since
 * 
 * 		希尔排序的时间性能优于直接插入排序，原因如下：<br/>
 *        （1）当文件初态基本有序时直接插入排序所需的比较和移动次数均较少。<br/>
 *        （2）当n值较小时，n和n2的差别也较小，即直接插入排序的最好时间复杂度O(n)和最坏时间复杂度0(n2)差别不大。<br/>
 *        （3）在希尔排序开始时增量较大，分组较多，每组的记录数目少，故各组内直接插入较快，后来增量di逐渐缩小，分组数逐渐减少，<br/>
 *        而各组的记录数目逐渐增多，但由于已经按di-1作为距离排过序，使文件较接近于有序状态，所以新的一趟排序过程也较快。<br/>
 *        因此，希尔排序在效率上较直接插人排序有较大的改进。 希尔排序的平均时间复杂度为O(nlogn)。<br/>
 *
  
 *        **/
public class ShellSort implements IInsertSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if (datas == null || datas.length == 0) {
			return;
		}

		int d = datas.length;
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				// 直接插入排序
				for (int i = x + d; i < datas.length; i = i + d) {
					int temp = datas[i];
					int j;
					for (j = i - 1; j >= 0; j--) {
						if (temp < datas[j]) {
							datas[j + 1] = datas[j];
						} else {
							break;
						}
					}
					datas[j + 1] = temp;
				}
			}

			if (d == 1) {
				break;
			}
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Shell Sort : ";
	}

}
