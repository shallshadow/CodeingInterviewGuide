
package other;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 第一种方法的时间复杂度为O(2^N),额外空间复杂度为O(N)
 * 第二种方法的时间复杂度为O(N*sum),额外空间复杂度为O(N)
 * @fun 正数数组的最小不可组成和
 * @author shadow
 * @Date 2016年9月7日下午6:43:42
 * @version 1.0
 * @since
 **/
public class UnformedSum {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 5, 15};

		UnformedSum sum = new UnformedSum();
		System.out.println("Min sum 1: " + sum.unfromedSum(arr));
		
		System.out.println("Min sum 2: " + sum.unfromedSum2(arr));
		System.out.println("Min sum 3: " + sum.unfromedSum3(arr));
		
	}
	
	/**
	 * 进阶问题：如果已知正数数组arr中肯定有1这个数，是否能更快地得到最小不可组成和？
	 * 时间复杂度O(NlogN),额外空间复杂度O(1)
	 * @param arr
	 * @return
	 */
	private int unfromedSum3(int[] arr){
		if(arr == null || arr.length == 0){
			return 1;
		}
		
		Arrays.sort(arr);
		int range = 0;
		for(int i = 0; i != arr.length; i++){
			if(arr[i] > range + 1){
				return range+ 1;
			}else{
				range += arr[i];
			}
		}
		
		return range + 1;
	}
	
	/**
	 * 利用动态规划求出最小不可加和
	 * @param arr 数组
	 * @return
	 */
	private int unfromedSum2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 1;
		}

		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			min = Math.min(arr[i], min);
		}
		//如果dp[j]为true，则表示j这个累加和能够被arr的子集相加得到，如果为false则表示不能
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for (int i = 0; i != arr.length; i++) {
			//自sum依次减1，判断是否出现在已在数组中的和。
			for (int j = sum; j >= arr[i]; j--) {
				dp[j] = dp[j - arr[i]] ? true : dp[j];
			}
		}
		
		for (int i = min; i != dp.length; i++) {
			if (!dp[i]) {
				return i;
			}
		}

		return sum + 1;
	}

	private int unfromedSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 1;
		}
		HashSet<Integer> set = new HashSet<>();
		process(arr, arr.length, 0, set);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		//count max and min
		for (Integer integer : set) {
			if (min > integer) {
				min = integer;
			}

			if (max < integer) {
				max = integer;
			}
		}

		for (int i = min; i < max; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		return max + 1;
	}

	/**
	 * 
	 * @param arr
	 *            目标数组
	 * @param i
	 *            数组下标
	 * @param sum
	 *            和
	 * @param set
	 *            记录数组和
	 */
	private void process(int[] arr, int i, int sum, HashSet<Integer> set) {
		if (i == 0) {
			set.add(sum);
			System.out.println("Sum : " + sum);
			return;
		}

		// 包含arr[i]的添加 
		process(arr, i - 1, sum, set);
		// 不包含arr[i]的添加
		//System.out.println("1 i : " + (i + 1) + " sum : " + sum);
		process(arr, i - 1, sum + arr[i - 1], set);
		//System.out.println("2 i : " + (i + 1) + " sum : " + sum);
	}
}
