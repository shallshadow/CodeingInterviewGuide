
package sort;

/**
 * @fun 堆排序<br/>
 *      基本思想：堆排序是一种树形选择排序，是对直接选择排序的有效改进。<br/>
 *      堆的定义下：具有n个元素的序列
 *      （h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）
 *      (i=1,2,...,n/2)时称之为堆。<br/>
 *      在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。<br/>
 *      完全二 叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。<br/>
 *      <p>
 *      思想:初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个 堆，这时堆的根节点的数最大。<br/>
 *      然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。<br/>
 *      依此类推，直到只有两个节点的堆，并对 它们作交换，最后得到有n个节点的有序序列。<br/>
 *      </p>
 *      <p>
 *      从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。<br/>
 *      所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。<br/>
 *      </P>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月28日下午9:05:51
 * @version 1.0
 * @since
 * 
 * 		分析：<br/>
 *        堆排序也是一种不稳定的排序算法。<br/>
 *        堆排序优于简单选择排序的原因：<br/>
 *        直接选择排序中，为了从R[1..n]中选出关键字最小的记录，必须进行n-1次比较，然后在R[2..n]中选出关键字最小的记录，又需要做n-
 *        2次比较。<br/>
 *        事实上，后面的n-2次比较中，有许多比较可能在前面的n-1次比较中已经做过，但由于前一趟排序时未保留这些比较结果，
 *        所以后一趟排序时又重复执行了这些比较操作。<br/>
 *        堆排序可通过树形结构保存部分比较结果，可减少比较次数。<br/>
 *        堆排序的最坏时间复杂度为O(nlogn)。堆序的平均性能较接近于最坏性能。<br/>
 *        由于建初始堆所需的比较次数较多，所以堆排序不适宜于记录数较少的文件。<br/>
 **/
public class HeapSort implements ISelectSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if (datas == null || datas.length == 0) {
			return;
		}

		buildMaxHeap(datas);
	}

	/**
	 * 建堆
	 * 
	 * @param datas
	 */
	private void buildMaxHeap(int[] datas) {
		// 循环建堆
		int len = datas.length;
		for (int i = 0; i < len; i++) {
			// 建堆
			buildMaxHeap(datas, len - i - 1);
			// 交换堆顶和最后一个元素（重要）
			swap(datas, 0, len - 1 - i);
		}
	}

	/**
	 * 对data数据从0到lastIndex建大顶堆
	 * 
	 * @param datas
	 * @param lastIndex
	 */
	private void buildMaxHeap(int[] datas, int lastIndex) {
		// 从lastIndex处节点(最后一个节点)的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k保存当前正在判断的节点
			int k = i;
			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				// k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				// 如果biggerIndex小于lastIndex,即biggerIndex+1代表的k节点的右子节点存在
				if (biggerIndex < lastIndex) {
					// 如果右子节点的值较大
					if (datas[biggerIndex] < datas[biggerIndex + 1]) {
						// biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				// 如果k节点的值小于其较大的子节点的值
				if (datas[k] < datas[biggerIndex]) {
					// 施行交换
					swap(datas, k, biggerIndex);
					// 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				} else {
					break;
				}
			}

		}
	}

	/**
	 * 交换
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	private void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Heap Sort : ";
	}

}
