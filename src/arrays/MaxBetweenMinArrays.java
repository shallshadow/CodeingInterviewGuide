package arrays;

import java.util.LinkedList;
/**
 * @author shadow
 * @Date 2016��7��29������9:18:59
 * @Fun ���ֵ��ȥ��СֵС�ڻ����num������������
 **/
public class MaxBetweenMinArrays {
	public int getNum(int[] arr, int num){
		if(arr == null || arr.length == 0){
			return 0;
		}
		
		LinkedList<Integer> qminList = new LinkedList<>();
		LinkedList<Integer> qmaxList = new LinkedList<>();
		
		int i = 0;
		int j = 0;
		int res = 0;
		while(i < arr.length){
			while(j < arr.length){
				while (!qminList.isEmpty() && arr[qminList.peekFirst()] >= arr[j]) {
					qminList.pollLast();					
				}
				qminList.addLast(j);
				
				while(!qmaxList.isEmpty() && arr[qmaxList.pollFirst()] <= arr[j]){
					break;
				}				
				qmaxList.addLast(j);
				
				if(arr[qmaxList.getFirst() - arr[qminList.getFirst()]] > num){
					break;
				}
				j++;
			}
			if(qminList.peekFirst() == i){
				qminList.pollFirst();
			}
			
			if(qmaxList.peekFirst() == i){
				qmaxList.pollFirst();
			}
			
			res += j - 1;
			i++; 
		}
		
		return res;
	}
}
