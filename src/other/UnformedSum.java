
package other;

import java.util.Arrays;
import java.util.HashSet;

/**
 * ��һ�ַ�����ʱ�临�Ӷ�ΪO(2^N),����ռ临�Ӷ�ΪO(N)
 * �ڶ��ַ�����ʱ�临�Ӷ�ΪO(N*sum),����ռ临�Ӷ�ΪO(N)
 * @fun �����������С������ɺ�
 * @author shadow
 * @Date 2016��9��7������6:43:42
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
	 * �������⣺�����֪��������arr�п϶���1��������Ƿ��ܸ���صõ���С������ɺͣ�
	 * ʱ�临�Ӷ�O(NlogN),����ռ临�Ӷ�O(1)
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
	 * ���ö�̬�滮�����С���ɼӺ�
	 * @param arr ����
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
		//���dp[j]Ϊtrue�����ʾj����ۼӺ��ܹ���arr���Ӽ���ӵõ������Ϊfalse���ʾ����
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for (int i = 0; i != arr.length; i++) {
			//��sum���μ�1���ж��Ƿ���������������еĺ͡�
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
	 *            Ŀ������
	 * @param i
	 *            �����±�
	 * @param sum
	 *            ��
	 * @param set
	 *            ��¼�����
	 */
	private void process(int[] arr, int i, int sum, HashSet<Integer> set) {
		if (i == 0) {
			set.add(sum);
			System.out.println("Sum : " + sum);
			return;
		}

		// ����arr[i]����� 
		process(arr, i - 1, sum, set);
		// ������arr[i]�����
		//System.out.println("1 i : " + (i + 1) + " sum : " + sum);
		process(arr, i - 1, sum + arr[i - 1], set);
		//System.out.println("2 i : " + (i + 1) + " sum : " + sum);
	}
}
