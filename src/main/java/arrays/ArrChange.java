
package arrays;

/**
 * @fun Given a descending array A,recorder it to:Ln->L0->Ln-1->L1->Ln-2->...
 *      Notice:do this with only O(1) memory space and in O(n) time complexity.
 * @author shadow
 * @Date 2016年9月18日下午3:08:01
 * @version 1.0
 * @since
 **/
public class ArrChange {
	public static void main(String[] args) {
		int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// new ArrChange1().getChange(arr);
		new ArrChange().change(arr);
	}

	/**
	 * ERROR
	 * 
	 */
	public void change3(int[] arr) {
		int pre = 0;
		int count = 1;
		int maxIndex = 0;
		//reverse(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length / 2; i++) {
			pre = arr[i];
			if(i + count == arr.length){
				
			}else{
				if(i % 2 == 1){
					count = count + 1;
				}			
				maxIndex = arr.length - (count - 1) - 1;
				arr[i] = arr[maxIndex];
				arr[maxIndex] = pre;
				if(count == 0){
					
				}

			}
		}
	}

	/**
	 * 递归解决该问题，但时间复杂度和空间复杂度不合乎要求。
	 * 
	 * @param arr
	 * @return
	 */
	public void change(int[] arr) {
		change3(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public void change(int[] arr, int start, int end) {
		if (end - start < 2) {
			return;
		}
		int index = end - 1;
		int mid = (end - start) % 2 == 0 ? start + (end - start) / 2 : start + (end - start) / 2 + 1;
		for (int i = start; i < mid; i++) {
			swap(arr, i, index);
		}
		change(arr, start + 2, end - 1);
	}

	/**
	 * 通过寻找规律，使用旋转和交换来解决该问题。 规律为：除去开始两个节点，前它节点以三个一组的形式，正序倒序排列。
	 * 
	 * @param arr
	 */
	public void change2(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int seg = arr.length / 3;
		// System.out.println("seg : " + seg);
		reverse(arr, start, end);
		start += 2;
		reverse(arr, start, end);

		for (int i = 0; i < seg; i++) {
			start += 3;
			reverse(arr, start, end);
		}
		int point = 1;
		for (int i = 0; i < seg; i++) {
			swap(arr, point + i * 3, point + i * 3 + 1);
		}
	}

	private void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
