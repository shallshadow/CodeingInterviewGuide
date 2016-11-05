package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Fun 生产窗口最大值数组
 * @author shadow
 *
 */
public class MaxWindow {
	public static int[] getMaxWindow(int[] arr, int w){		
		if(arr == null || w < 1 || arr.length < w){
			return null;
		}
		
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for(int i = 0; i < arr.length; i++)
		{
			//判断队列是否为空并且最后一个数是否小于下一个数
			while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){				
				deque.pollLast();
			}
			
			deque.addLast(i);
			if(deque.peekFirst() == i - w){
				deque.pollFirst();
			}
			
			if(i >= w - 1){
				res[index++] = arr[deque.peekFirst()];
			}
		}
	
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] testData = {4,3,5,4,3,3,6,7};
		int[] goalData = MaxWindow.getMaxWindow(testData, 3);
		
		for(int i = 0; i < goalData.length; i++){
			System.err.println(goalData[i]);
		}
	}
}
