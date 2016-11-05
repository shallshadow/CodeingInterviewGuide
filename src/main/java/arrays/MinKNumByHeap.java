
package arrays;

/**
 *
 * @author shadow
 * @Date 2016年9月13日下午4:04:26
 * @version 1.0
 * @since
 **/
public class MinKNumByHeap extends ArrayProblem {

	public static void main(String[] args) {
		int k = 5;
		int[] datas = { 1, 5, 8, 9, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		MinKNumByHeap heap = new MinKNumByHeap(datas, k);
		heap.solve();
		heap.showResult();
	}

	private int k;
	private int[] res;

	public MinKNumByHeap(int[] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}

	public MinKNumByHeap(int[] datas, int k) {
		super(datas);
		// TODO Auto-generated constructor stub
		this.k = k;
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if (!super.solve()) {
			return false;
		}
		res = getMinKNumsByHeap(datas, k);
		return true;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + " Min Num K Arrays ";
	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + " Result : ");
		for (int i : res) {
			System.out.print(" " + i);
		}
		System.out.println();
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return res;
	}

	private int[] getMinKNumsByHeap(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			return arr;
		}

		int[] kHeap = new int[k];
		for (int i = 0; i != k; i++) {
			heapInsert(kHeap, arr[i], i);
		}

		for (int i = 0; i != arr.length; i++) {
			if (arr[i] < kHeap[0]) {
				kHeap[0] = arr[i];
				heapify(kHeap, 0, k);
			}
		}
		return kHeap;
	}

	public void heapInsert(int[] arr, int value, int index) {
		arr[index] = value;
		while (index != 0) {
			int parent = (index - 1) / 2;
			if (arr[parent] < arr[index]) {
				swap(arr, parent, index);
				index = parent;
			} else {
				break;
			}
		}
	}

	public void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		while (left < heapSize) {
			if (arr[left] > arr[index]) {
				largest = left;
			}

			if (right < heapSize && arr[right] > arr[largest]) {
				largest = right;
			}

			if (largest != index) {
				swap(arr, largest, index);
			} else {
				break;
			}

			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}
	}

	private void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
