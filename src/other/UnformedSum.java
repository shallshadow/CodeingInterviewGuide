
package other;

import java.util.HashSet;

/**
 *
 * @author shadow 
 * @Date 2016年9月7日下午6:43:42
 * @version 1.0
 * @since 
 **/
public class UnformedSum {
	public static void main(String[] args) {
		int[] arr = {1,3,2};
		
		UnformedSum sum = new UnformedSum();
		System.out.println("Min sum : " + sum.unfromedSum(arr));
	}
	
	private int unfromedSum(int[] arr){
		if(arr == null || arr.length == 0){
			return 1;
		}
		HashSet<Integer> set = new HashSet<>();
		process(arr, 0, 0, set);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(Integer integer : set){
			if(min > integer){
				min = integer;
			}
			
			if(max < integer){
				max = integer;
			}
		}
		
		for(int i = min; i < max; i++){
			if(!set.contains(i)){
				return i;
			}
		}		
		
		return max + 1;
	}
	
	/**
	 * 
	 * @param arr 目标数组
	 * @param i   数组下标
	 * @param sum 和
	 * @param set 记录数组和
	 */
	private void process(int[] arr, int i, int sum, HashSet<Integer> set){
		if(i == arr.length){
			set.add(sum);
			return;
		}
		
		//包含arr[i]的添加 1		
		process(arr, i + 1, sum, set);
		//不包含arr[i]的添加
		System.out.println("1 i : " + (i + 1) + " sum : " + sum);
		process(arr, i + 1, sum + arr[i], set);
		System.out.println("2 i : " + (i + 1) + " sum : " + sum);
	}
}
